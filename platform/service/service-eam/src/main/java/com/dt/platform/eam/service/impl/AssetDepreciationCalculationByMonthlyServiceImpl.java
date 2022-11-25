package com.dt.platform.eam.service.impl;

import com.dt.platform.constants.enums.eam.*;
import com.dt.platform.domain.eam.*;
import com.dt.platform.domain.eam.meta.AssetDepreciationOperMeta;
import com.dt.platform.eam.service.*;
import com.github.foxnic.api.error.ErrorDesc;
import com.github.foxnic.api.transter.Result;
import com.github.foxnic.sql.expr.ConditionExpr;
import org.apache.commons.jexl3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("AssetDepreciationCalculationByMonthlyService")
public class AssetDepreciationCalculationByMonthlyServiceImpl implements IAssetDepreciationCalculationService {




    @Autowired
    private IAssetDepreciationService assetDepreciationService;

    @Autowired
    private IAssetDepreciationOperService assetDepreciationOperService;

    @Autowired
    private IAssetDepreciationDetailService assetDepreciationDetailService;


    @Autowired
    private IAssetService assetService;

    public static void main(String[] args) {
        AssetDepreciationDetail d=new AssetDepreciationDetail();
     //   d.setDepreciationPrice(new BigDecimal("2.2"));
        Map<String, Object> map = new HashMap<String, Object>();
        // map key是  公式中的 x  value 是x的值
        // map 中可以放多个值  y  z  之类
        map.put("e", d);
        String formula = "0";
        String result = calculation(formula,map);
        System.out.println(result);
        BigDecimal bNum = new BigDecimal(result).setScale(2,BigDecimal.ROUND_DOWN);
        System.out.println(bNum.toString());
    }

    //Jexl引擎能够创建两种解析器，其中JexlExpression不能使用 if、for、while 语句块

    private static String calculation(String jexlExp, Map<String, Object> map){
        JexlEngine jexl = new JexlBuilder().create();
        JexlExpression  expression = jexl.createExpression(jexlExp);
        JexlContext jc = new MapContext();
        for (String key : map.keySet()) {
            jc.set(key, map.get(key));
        }
        if (null == expression.evaluate(jc)) {
            return "";
        }
        return expression.evaluate(jc).toString();
    }

    @Override
    public AssetDepreciationCodeEnum getCode() {
        return AssetDepreciationCodeEnum.MONTHLY;
    }

    @Override
    public Result calculation(String billId) {
        return ErrorDesc.success();
    }

    @Override
    public Result fillAssetData(String billId) {
        AssetDepreciationOper bill=assetDepreciationOperService.getById(billId);
        assetDepreciationOperService.dao().fill(bill)
                .with(AssetDepreciationOperMeta.ASSET_DEPRECIATION)
                .execute();


        AssetDepreciation assetDepreciation=bill.getAssetDepreciation();
        if(AssetDepreciationStatusEnum.ACTING.code().equals(bill.getStatus())
                ||AssetDepreciationStatusEnum.NOT_START.code().equals(bill.getStatus())
                ||AssetDepreciationStatusEnum.FAILED.code().equals(bill.getStatus())
        ){
            System.out.println("start to collect asset data!");
        }else{
            return ErrorDesc.failureMessage("当前状态,不可进行本操作");
        }

        if(bill==null){
            return ErrorDesc.failureMessage("当前折旧单据不存在,不能进行操作!");
        }
        //删除数据
        assetDepreciationOperService.dao().execute("delete from eam_asset_depreciation_detail where depreciation_id=?",billId);

        //查询折旧资产
        AssetVO assetVO=new AssetVO();
        assetVO.setOwnerCode(AssetOwnerCodeEnum.ASSET.code());
        assetVO.setStatus(AssetHandleStatusEnum.COMPLETE.code());
        assetVO.setCleanOut("0");
        ConditionExpr expr=new ConditionExpr();
        if(assetDepreciationOperService.dao().queryRecord("select count(1) cnt from eam_asset_depreciation_category where deleted=0 and category_id<>'' and category_id is not null and depreciation_id=?",bill.getDepreciationId()).getInteger("cnt")>0) {
            expr.and("category_id in (select category_id from eam_asset_depreciation_category where deleted=0 and depreciation_id='"+bill.getDepreciationId()+"')");
        }else{
        }
        List<Asset> assetList=assetService.queryList(assetVO,expr);
        //关联获取资产属性实体数据
        assetService.joinData(assetList);

        List<AssetDepreciationDetail> detailList=new ArrayList<>();
        if(assetList.size()>0){
            for(Asset asset:assetList){
                String assetId=asset.getId();
                AssetDepreciationDetail detail=new AssetDepreciationDetail();
                detail.setResult(AssetDetailDepreciationResultEnum.WAIT_CALCULATE.code());
//				detail.setCurPrice(asset.getNavPrice());
//				detail.setBeforePrice(asset.getNavPrice());
                detail.setOperId(billId);
                detail.setDepreciationMethod(assetDepreciation.getMethod());
                detail.setDepreciationId(bill.getDepreciationId());
                detail.setAssetId(assetId);
//				detail.setResidualRate(assetDepreciation.getPreResidualRate());
//				detail.setServiceLife(asset.getServiceLife());
//				detail.setPurchaseDate(asset.getPurchaseDate());
//				detail.setPurchaseUnitPrice(asset.getPurchaseUnitPrice());

                detail.setAssetCode(asset.getAssetCode());
                detail.setAssetName(asset.getName());
                detail.setAssetModel(asset.getModel());
                //	detail.setOriginalUnitPrice(asset.getOriginalUnitPrice());

                asset.setId(null);
                asset.setOwnerCode(AssetOwnerCodeEnum.ASSET_DEPRECIATION_DATA.code());
                assetService.insert(asset);
                detail.setDetailIdSource(asset.getId());
                detailList.add(detail);
            }
        }else{
            return ErrorDesc.failureMessage("没有资产数据需要折旧");
        }
        assetDepreciationDetailService.insertList(detailList);
        AssetDepreciationOper ups=new AssetDepreciationOper();
        ups.setId(billId);
        ups.setStatus(AssetDepreciationStatusEnum.ACTING.code());
   //     super.save(ups, SaveMode.NOT_NULL_FIELDS,true);
        return ErrorDesc.success();
    }


    /*
    * */
    public Result calculationAsset(String id) {
        //检查


        //计算


        //存入


        return ErrorDesc.success();
    }
}
