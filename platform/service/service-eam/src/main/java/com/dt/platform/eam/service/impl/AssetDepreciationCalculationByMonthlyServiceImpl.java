package com.dt.platform.eam.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.platform.constants.enums.common.StatusEnableEnum;
import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetDepreciationDetailMeta;
import com.dt.platform.domain.eam.meta.AssetDepreciationMeta;
import com.dt.platform.domain.eam.meta.AssetDepreciationOperMeta;
import com.dt.platform.domain.eam.meta.AssetMeta;
import com.dt.platform.domain.ops.MonitorNode;
import com.dt.platform.eam.service.*;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.bean.BeanUtil;
import com.github.foxnic.commons.collection.CollectorUtil;
import com.github.foxnic.commons.concurrent.SimpleJoinForkTask;
import com.github.foxnic.commons.lang.StringUtil;
import com.github.foxnic.commons.log.Logger;
import com.github.foxnic.dao.data.Rcd;
import com.github.foxnic.dao.data.SaveMode;
import com.github.foxnic.sql.expr.ConditionExpr;
import com.github.foxnic.sql.expr.SQL;
import com.mysql.jdbc.log.Log;
import org.apache.commons.jexl3.*;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.commons.math3.special.Erf;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.hrm.Person;
import org.github.foxnic.web.proxy.pcm.PcmCatalogDelegate;
import org.github.foxnic.web.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;


@Service("AssetDepreciationCalculationByMonthlyService")
public class AssetDepreciationCalculationByMonthlyServiceImpl implements IAssetDepreciationCalculationService {


    @Autowired
    private AssetDepreciationUtilService assetDepreciationUtilService;


    @Autowired
    private IAssetDepreciationService assetDepreciationService;

    @Autowired
    private IAssetDepreciationOperService assetDepreciationOperService;

    @Autowired
    private IAssetDepreciationDetailService assetDepreciationDetailService;


    @Autowired
    private IAssetService assetService;

    public static void main(String[] args) {
//        AssetDepreciationDetail d=new AssetDepreciationDetail();
//        d.setAssetRegisterDate(new Date());
//
//        Date date = new Date();
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(date);
//        // 把日期往后增加一天,整数  往后推,负数往前移动
//        calendar.add(Calendar.DATE, 90);
//        // 这个时间就是日期往后推一天的结果
//        date = calendar.getTime();
//
//        d.setBusinessDate(date);
//
//        Map<String, Object> map = new HashMap<String, Object>();
//        // map key是  公式中的 x  value 是x的值
//        // map 中可以放多个值  y  z  之类
//
////        System.out.println("2022-04-05");
////        System.out.println("2022-05-06");
//        Date d1=new Date();
//        Date d2=new Date();
//        map.put("asset",d);
//        map.put("x", d1);
//        map.put("y",d2);
//        String formula = "commonFunction:equalMonth(asset.businessDate,asset.assetRegisterDate)";
//        String result = calculation(formula,map);
//        System.out.println(result);
//        BigDecimal bNum = new BigDecimal(result).setScale(2,BigDecimal.ROUND_DOWN);
//        System.out.println(bNum.toString());
    }
    //Jexl引擎能够创建两种解析器，其中JexlExpression不能使用 if、for、while 语句块

    @Override
    public AssetDepreciationCodeEnum getCode() {
        return AssetDepreciationCodeEnum.MONTHLY;
    }



    @Override
    public Result fillAssetData(String billId) {
        AssetDepreciationOper bill=assetDepreciationOperService.getById(billId);
        assetDepreciationOperService.dao().fill(bill)
                .with(AssetDepreciationOperMeta.ASSET_DEPRECIATION)
                .execute();
        if(bill==null){
            return ErrorDesc.failureMessage("当前折旧单据不存在,不能进行操作!");
        }
        //判断当前状态不能进行输入导入
        AssetDepreciation assetDepreciation=bill.getAssetDepreciation();
        if(AssetDepreciationStatusEnum.ACTING.code().equals(bill.getStatus())
                ||AssetDepreciationStatusEnum.NOT_START.code().equals(bill.getStatus())
                ||AssetDepreciationStatusEnum.FAILED.code().equals(bill.getStatus())
        ){
            Logger.info("start to collect asset data!");
        }else{
            return ErrorDesc.failureMessage("当前状态,不可进行本操作");
        }


        //清空数据
        assetDepreciationOperService.dao().execute("delete from eam_asset_depreciation_detail where oper_id=?",billId);

        //查询折旧资产
        AssetVO assetVO=new AssetVO();
        assetVO.setOwnerCode(AssetOwnerCodeEnum.ASSET.code());
        assetVO.setStatus(AssetHandleStatusEnum.COMPLETE.code());
        assetVO.setCleanOut("0");
        ConditionExpr expr=new ConditionExpr();
        //添加过滤添加-资产类型
        String catalogSql="select count(1) cnt from eam_asset_depreciation_category where deleted=0 and category_id<>'' and category_id is not null and depreciation_id=?";
        Rcd catalogRs=assetDepreciationOperService.dao().queryRecord(catalogSql,bill.getDepreciationId());
        System.out.println("catalogRs:"+catalogRs.getString("cnt"));
        if("0".equals(catalogRs.getString("cnt"))) {
            Logger.info("fill catalog 0");
        }else{
            Logger.info("fill catalog expr");
            expr.and("category_id in (select category_id from eam_asset_depreciation_category where deleted=0 and depreciation_id='" + bill.getDepreciationId() + "')");
        }
        //添加过滤添加-确保分类存在，正常不需要这个条件
        expr.and("category_id in (select id from pcm_catalog where deleted=0)");

        List<Asset> assetList=assetService.queryList(assetVO,expr);
        //关联获取资产属性实体数据
        assetService.dao().fill(assetList).with(AssetMeta.CATEGORY)
                .with(AssetMeta.OWNER_COMPANY)
                .with(AssetMeta.USE_ORGANIZATION)
                .with(AssetMeta.USE_USER)
                .with(AssetMeta.MANAGER)
                .with(AssetMeta.ASSET_CYCLE_STATUS)
                .with(AssetMeta.CATEGORY_FINANCE)
                .with(AssetMeta.EXPENSE_ITEM_DICT)
                .with(AssetMeta.FINANCIAL_OPTION_DICT)
                .execute();
        List<Employee> useUser= CollectorUtil.collectList(assetList,Asset::getUseUser);
        assetService.dao().join(useUser, Person.class);
        List<Employee> managerUser= CollectorUtil.collectList(assetList,Asset::getManager);
        assetService.dao().join(managerUser, Person.class);

        //获取员工扩展数据
        List<String> ids1=new ArrayList<>();
        if(useUser!=null&useUser.size()>0){
             useUser.removeAll(Collections.singleton(null));
             ids1=CollectorUtil.collectList(useUser,Employee::getId);
        }
        List<String> ids2=new ArrayList<>();
        if(managerUser!=null&managerUser.size()>0){
            managerUser.removeAll(Collections.singleton(null));
            ids2=CollectorUtil.collectList(managerUser,Employee::getId);
        }
        ids1.addAll(ids2);
        ids1.removeAll(Collections.singleton(null));
        HashMap<String,JSONObject> userInfoExt=new HashMap<>();
        if(ids1.size()>0){
            PcmCatalogDelegate delegate=new PcmCatalogDelegate("649972331808030720");
            Result extInfoResult = delegate.queryDataByOwnerId(ids1.size(),1,ids1.toArray(new String[0]));
            JSONArray array =((JSONObject) extInfoResult.data()).getJSONArray("list");
            if(array!=null){
                for(int i=0;i<array.size();i++){
                    JSONObject e=array.getJSONObject(i);
                    System.out.println("extdata:"+e.toJSONString());
                 //   extdata:{"tenant_id":"T001","catalog_id":"649972331808030720","create_time":"2022-12-05 11:02:08.000000","owner_id":"586965217661943808","id":"652283595536203776","version":1}
                    userInfoExt.put(e.getString("owner_id"),e);
                }
            }
        }

        //填充资产折旧明细数据，用于折旧计算
        List<AssetDepreciationDetail> detailList=new ArrayList<>();
        List<List<AssetDepreciationDetail>> groupList=new ArrayList<>();
        String createBy= SessionUser.getCurrent().getActivatedEmployeeId();
        long start = System.currentTimeMillis();
        int batchCnt=0;
        if(assetList.size()>0){
            for(Asset asset:assetList){
                String assetId=asset.getId();
                AssetDepreciationDetail detail=new AssetDepreciationDetail();
                detail.setResult(AssetDetailDepreciationResultEnum.WAIT_CALCULATE.code());
                detail.setOperId(billId);
                detail.setBusinessDate(bill.getBusinessDate());
                detail.setFirstDepreciationMethod(assetDepreciation.getFirstDepreciationMethod());
                detail.setDepreciationMethod(assetDepreciation.getMethod());
                detail.setDepreciationId(bill.getDepreciationId());
                detail.setAssetId(assetId);
                detail.setAssetCode(asset.getAssetCode());
                detail.setAssetName(asset.getName());
                detail.setAssetModel(asset.getModel());
                detail.setAssetPurchaseDate(asset.getPurchaseDate());
                detail.setAssetRegisterDate(asset.getRegisterDate());
                detail.setAssetOriginalUnitPrice(asset.getOriginalUnitPrice());
                detail.setAssetPurchaseUnitPrice(asset.getPurchaseUnitPrice());
                detail.setAssetNavPrice(asset.getNavPrice());
                detail.setAssetTaxAmountRate(asset.getTaxAmountRate());
                detail.setAssetResidualsRate(asset.getResidualsRate());
                detail.setAssetResidualsPrice(asset.getResidualsPrice());
                detail.setUseOrgId(asset.getUseOrganizationId());
                detail.setUseUserId(asset.getUseUserId());
                detail.setManagerId(asset.getManagerId());
                detail.setAssetFinanceCategoryId(asset.getFinancialCategoryId());
                detail.setExpenseItemKey(asset.getExpenseItem());
                detail.setFinancialOptionKey(asset.getFinancialOption());
                //上次折旧操作Id
                detail.setLastOperId(asset.getDepreciationId());
                detail.setLastOperTime(asset.getDepreciationOperTime());
                detail.setCustomerInfo(asset.getCustomerInfo());
                detail.setDetailIdSource(asset.getId());
                detail.setCreateBy(createBy);
                if(asset.getAssetCycleStatus()!=null){
                    detail.setAssetStatusName(asset.getAssetCycleStatus().getName());
                }
                if(asset.getCategory()!=null){
                    detail.setAssetCategoryName(asset.getCategory().getName());
                }
                //已使用期限
                if(asset.getAssetUsedServiceLife()==null){
                    detail.setCUsedServiceLife(new BigDecimal("0"));
                }else{
                    detail.setCUsedServiceLife(asset.getAssetUsedServiceLife());
                }
                //如果设置了财务期限，以财务期限为准，否则使用资产本身的
                if(asset.getCategoryFinance()!=null){
                    detail.setAssetFinanceCategoryName(asset.getCategoryFinance().getCategoryName());
                    detail.setAssetFinanceServiceLife(asset.getCategoryFinance().getServiceLife());
                    if(asset.getAssetUsedServiceLife().compareTo(detail.getAssetFinanceServiceLife())>-1){
                        detail.setResult(AssetDetailDepreciationResultEnum.DEPRECIATION_FINISHED.code());
                    }
                }

                //如果设置资产的使用期限，以财务期限为准，否则使用资产本身的
                detail.setAssetServiceLife(asset.getServiceLife());
                if(asset.getAssetUsedServiceLife().compareTo(detail.getAssetServiceLife())>-1){
                    detail.setResult(AssetDetailDepreciationResultEnum.DEPRECIATION_FINISHED.code());
                }

                if(asset.getUseUser()!=null){
                    detail.setUseUserName(asset.getUseUser().getName());
                }
                if(asset.getManager()!=null){
                    detail.setManagerName(asset.getManager().getName());
                }
                if(asset.getUseOrganization()!=null){
                    detail.setUseOrgName(asset.getUseOrganization().getFullName());
                }
                if(asset.getExpenseItemDict()!=null){
                    detail.setExpenseItemName(asset.getExpenseItemDict().getLabel());
                }
                if(asset.getFinancialOptionDict()!=null){
                    detail.setFinancialOptionName(asset.getFinancialOptionDict().getLabel());
                }
                /*************定制开始----重置客户信息/***************/
                if("后台".equals(detail.getFinancialOptionName())){
                    detail.setCustomerInfo("无");
                }
                //加上成本中心
                if(!StringUtil.isBlank(asset.getUseUserId())){
                    //使用使用人员的成本中心
                   if(userInfoExt.containsKey(asset.getUseUserId())){
                       JSONObject ext=userInfoExt.get(asset.getUseUserId());
                       detail.setLabel(ext.getString("cost_center"));
                   }
                }else{
                    if(!StringUtil.isBlank(asset.getManagerId())){
                        //使用使用人员的成本中心
                        if(userInfoExt.containsKey(asset.getManagerId())){
                            JSONObject ext=userInfoExt.get(asset.getManagerId());
                            detail.setLabel(ext.getString("cost_center"));
                        }
                    }
                }
                /*************定制结束----重置客户信息/***************/
                detailList.add(detail);
                if(batchCnt>500){
                    groupList.add(detailList);
                    batchCnt=0;
                    detailList=new ArrayList<>();
                }
                batchCnt++;
            }
        }else{
            return ErrorDesc.failureMessage("没有资产数据需要折旧");
        }
        if(detailList.size()>0){
            groupList.add(detailList);
        }
//      Logger.info("并行运行,并行数:"+10);
        SimpleJoinForkTask<List<AssetDepreciationDetail> ,Result> task=new SimpleJoinForkTask<>(groupList,2);
        List<Result> rvs=task.execute(els->{
            System.out.println(Thread.currentThread().getName());
            List<Result> rs=new ArrayList<>();
            for (List<AssetDepreciationDetail> list : els) {
                rs.add(assetDepreciationDetailService.insertList(list));
            }
            return rs;
        });
        long finish = System.currentTimeMillis();
        long cost=(finish-start)/1000L;
        System.out.println("batch execute cost:"+cost);

        //更新单据
        AssetDepreciationOper ups=new AssetDepreciationOper();
        ups.setId(billId);
        ups.setStatus(AssetDepreciationStatusEnum.ACTING.code());
        assetDepreciationOperService.save(ups, SaveMode.NOT_NULL_FIELDS,true);
        //折旧排除
        String sql="update eam_asset_depreciation_detail a set result='"+AssetDetailDepreciationResultEnum.NOT_CALCULATE.code()+"',result_detail='折旧排除' where (oper_id,asset_id) in (\n" +
                "select a.oper_id,a.asset_id from eam_asset_depreciation_exclude b where a.asset_id=b.asset_id and a.deleted=0 and b.deleted=0\n" +
                "and a.depreciation_id=b.depreciation_id and a.oper_id=?)";
        assetDepreciationDetailService.dao().execute(sql,billId);
        Result r=new Result();
        r.success(true);
        r.message("导入成功，总共耗时:"+cost+"秒");
        return r;
    }

    /*
         按照单据进行折旧计算
    */
    @Override
    public Result depreciationCalculation(String billId) {
        long start = System.currentTimeMillis();
        Result fillDataResult=fillAssetData(billId);
        if(!fillDataResult.isSuccess()){
            return fillDataResult;
        }
        AssetDepreciationOper bill=assetDepreciationOperService.getById(billId);
        assetDepreciationOperService.dao().fill(bill)
                .with(AssetDepreciationOperMeta.ASSET_DEPRECIATION)
                .with(AssetDepreciationOperMeta.ASSET_DEPRECIATION_LIST)
                .execute();
        if(bill==null){
            return ErrorDesc.failureMessage("当前折旧单据不存在,不能进行操作!");
        }

        //判断当前状态不能进行输入导入
        if(AssetDepreciationStatusEnum.ACTING.code().equals(bill.getStatus())){
            Logger.info("start to collect asset data!");
        }else{
            return ErrorDesc.failureMessage("当前状态,不可进行本操作");
        }

        //判断当前状态不能进行输入导入
        if(AssetDepreciationStatusEnum.ACTING.code().equals(bill.getStatus())
                ||AssetDepreciationStatusEnum.NOT_START.code().equals(bill.getStatus())
                ||AssetDepreciationStatusEnum.FAILED.code().equals(bill.getStatus())){
            Logger.info("start to collect asset data!");
        }else{
            return ErrorDesc.failureMessage("当前状态,不可进行本操作");
        }
        //获取本次折旧数据，折旧规则，上次折旧数据
        List<AssetDepreciationDetail> list=bill.getAssetDepreciationList();
        assetDepreciationDetailService.dao().fill(list)
                .with(AssetDepreciationDetailMeta.CAL_RULE_LIST)
                .with(AssetDepreciationDetailMeta.LAST_ASSET_DEPRECIATION_DETAIL)
                .execute();
        //开始遍历进行折旧计算

        List<AssetDepreciationDetail> assetDepreciationDetailList=new ArrayList<>();
        List<List<AssetDepreciationDetail>> groupList=new ArrayList<>();
        int batchCnt=0;
        for(AssetDepreciationDetail assetDepreciationDetail:list){
            Result r=calculationAsset(assetDepreciationDetail);
            if(!r.isSuccess()){
                assetDepreciationDetailService.update(assetDepreciationDetail,SaveMode.NOT_NULL_FIELDS);
                Logger.info("id:"+assetDepreciationDetail.getDepreciationId()+",assetDepreciationDetail result:"+assetDepreciationDetail.getResult());
                Logger.info("id:"+assetDepreciationDetail.getDepreciationId()+",assetDepreciationDetail result detail:"+assetDepreciationDetail.getResultDetail());
                return ErrorDesc.failureMessage("折旧计算过程中,发现部分计算报错!");
            }
            assetDepreciationDetailList.add(assetDepreciationDetail);
            if(batchCnt>500){
                groupList.add(assetDepreciationDetailList);
                assetDepreciationDetailList=new ArrayList<>();
                batchCnt=0;
            }
            batchCnt++;
        }
        if(assetDepreciationDetailList.size()>0){
            groupList.add(assetDepreciationDetailList);
        }


        SimpleJoinForkTask<List<AssetDepreciationDetail> ,Result> task=new SimpleJoinForkTask<>(groupList,2);
        List<Result> rvs2=task.execute(els->{
            System.out.println(Thread.currentThread().getName());
            List<Result> rs2=new ArrayList<>();
            for (List<AssetDepreciationDetail> list2 : els) {
                rs2.add(assetDepreciationDetailService.updateList(list2,SaveMode.NOT_NULL_FIELDS));
            }
            return rs2;
        });
        long finish = System.currentTimeMillis();
        long cost=(finish-start)/1000L;
        System.out.println("cal batch execute cost:"+cost);
        Result r=new Result();
        r.success(true);
        r.message("折旧计算完成，总共耗时:"+cost+"秒");
        return r;
    }

    /*
   按资产进行折旧计算
    */
    private Result calculationAsset(AssetDepreciationDetail assetDepreciationDetail) {
        //不在做折旧处理
        if(AssetDetailDepreciationResultEnum.NOT_CALCULATE.code().equals(assetDepreciationDetail.getResult())){
            Result depreciationIdleResult=assetDepreciationUtilService.calRules(assetDepreciationDetail,AssetDepreciationRuleActionCodeEnum.DEPRECIATION_IDLE.code());
            if(depreciationIdleResult.isSuccess()){
                return depreciationIdleResult;
            }else{
                return depreciationIdleResult;
            }
        }

        //已完成折旧
        if(AssetDetailDepreciationResultEnum.DEPRECIATION_FINISHED.code().equals(assetDepreciationDetail.getResult())){
            Result depreciationIdleResult=assetDepreciationUtilService.calRules(assetDepreciationDetail,AssetDepreciationRuleActionCodeEnum.DEPRECIATION_FINISH.code());
            if(depreciationIdleResult.isSuccess()){
                return depreciationIdleResult;
            }else{
                return depreciationIdleResult;
            }
        }

        //正常折旧
        assetDepreciationDetail.setResult(AssetDetailDepreciationResultEnum.SUCCESS.code());
        Logger.info("当前折旧计算资产编号:"+assetDepreciationDetail.getAssetCode());
        //当前状态
        List<AssetDepreciationCalRule> ruleList=assetDepreciationDetail.getCalRuleList();
        if(ruleList==null||ruleList.size()==0){
            assetDepreciationDetail.setResult(AssetDetailDepreciationResultEnum.FAILED.code());
            assetDepreciationDetail.setResultDetail("本次折旧,没有找到折旧配置规则");
           // assetDepreciationDetailService.update(assetDepreciationDetail, SaveMode.NOT_NULL_FIELDS);
            return ErrorDesc.failureMessage("本次折旧,没有找到折旧配置规则");
        }
        System.out.println("#########################################折旧计算开始#########################################");
        //前置条件-规则定义
        Result preconditionsResult=assetDepreciationUtilService.calRules(assetDepreciationDetail,AssetDepreciationRuleActionCodeEnum.PRECONDITIONS.code());
        if(ruleList==null||ruleList.size()==0){
            assetDepreciationDetail.setResult(AssetDetailDepreciationResultEnum.FAILED.code());
            assetDepreciationDetail.setResultDetail(preconditionsResult.getMessage());
           // assetDepreciationDetailService.update(assetDepreciationDetail, SaveMode.NOT_NULL_FIELDS);
            return ErrorDesc.failureMessage(preconditionsResult.getMessage());
        }
        //前置条件-上次折旧时间
        if(assetDepreciationDetail.getLastOperTime()!=null){
            //不为null，说明上次做过折旧，这次做折旧时间必须大于上次(按照月份), 2022-11-25:34
            if("1".equals(assetDepreciationUtilService.equalMonth(assetDepreciationDetail.getLastOperTime(),assetDepreciationDetail.getBusinessDate()))){
                assetDepreciationDetail.setResult(AssetDetailDepreciationResultEnum.FAILED.code());
                assetDepreciationDetail.setResultDetail("本月已折旧过,请误重复操作,上次折旧时间:"+assetDepreciationDetail.getLastOperTime());
             //   assetDepreciationDetailService.update(assetDepreciationDetail, SaveMode.NOT_NULL_FIELDS);
                return ErrorDesc.failureMessage("本月已折旧过,请误重复操作,上次折旧时间:"+assetDepreciationDetail.getLastOperTime());
            }
        }
        //前置条件-日期是否符合逻辑，入账日期大于启用日期 assetDepreciationDetail.getAssetRegisterDate()<=assetDepreciationDetail.getBusinessDate()
        if("1".equals(assetDepreciationUtilService.compareDate(assetDepreciationDetail.getAssetRegisterDate(),assetDepreciationDetail.getBusinessDate()))){
            assetDepreciationDetail.setResult(AssetDetailDepreciationResultEnum.FAILED.code());
            assetDepreciationDetail.setResultDetail("启用日期需要大于等于入账日期");
          //  assetDepreciationDetailService.update(assetDepreciationDetail, SaveMode.NOT_NULL_FIELDS);
            return ErrorDesc.failureMessage("启用日期需要大于等于入账日期");
        }
        //前置条件-业务日期大于上次折旧日期 assetDepreciationDetail.getBusinessDate()>assetDepreciationDetail.getLastOperTime()
        if(assetDepreciationDetail.getLastOperTime()!=null){
            if("1".equals(assetDepreciationUtilService.compareDate(assetDepreciationDetail.getBusinessDate(),assetDepreciationDetail.getLastOperTime()))){
                System.out.println("");
            }else{
                assetDepreciationDetail.setResult(AssetDetailDepreciationResultEnum.FAILED.code());
                assetDepreciationDetail.setResultDetail("业务日期需要大于上次折旧日期");
           //     assetDepreciationDetailService.update(assetDepreciationDetail, SaveMode.NOT_NULL_FIELDS);
                return ErrorDesc.failureMessage("业务日期需要大于上次折旧日期");
            }
        }

        //前置条件-是否首次折旧
        String ifThisMonth=assetDepreciationUtilService.equalMonth(assetDepreciationDetail.getBusinessDate(),assetDepreciationDetail.getAssetRegisterDate());
        if("1".equals(ifThisMonth)){
            assetDepreciationUtilService.calRules(assetDepreciationDetail,AssetDepreciationRuleActionCodeEnum.DEPRECIATION_FIRST.code());
        }else{
            //正常折旧规则
            assetDepreciationUtilService.calRules(assetDepreciationDetail,AssetDepreciationRuleActionCodeEnum.DEPRECIATION_NORMAL.code());
        }
        System.out.println("#########################################折旧计算结束#########################################");
      //  assetDepreciationDetailService.update(assetDepreciationDetail, SaveMode.NOT_NULL_FIELDS);
        return ErrorDesc.success();
    }


}
