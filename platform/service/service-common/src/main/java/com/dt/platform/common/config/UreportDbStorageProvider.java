package com.dt.platform.common.config;
import com.bstek.ureport.provider.report.ReportFile;
import com.bstek.ureport.provider.report.ReportProvider;
import com.dt.platform.common.service.IReportUDefService;
import com.dt.platform.domain.common.ReportUDef;
import com.github.foxnic.dao.data.SaveMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UreportDbStorageProvider implements ReportProvider {

    private static final String NAME ="db-provider";

    @Autowired
    private IReportUDefService reportUDefService;

    //特定前缀，ureport底层调用getPrefix方法来获报表操作的Provier类
    private String prefix = "db:";

    //是否禁用
    private boolean disable = false;

    @Override
    public InputStream loadReport(String s) {

        ReportUDef q=new ReportUDef();
        q.setFileName(getCorrectName(s));
        ReportUDef data= reportUDefService.queryEntity(q);
        if(data!=null){
            byte[] bytes=data.getContent().getBytes();
            return new ByteArrayInputStream(bytes);
        }
        return null;
    }

    @Override
    public void deleteReport(String s) {
        ReportUDef q=new ReportUDef();
        q.setFileName(getCorrectName(s));
        ReportUDef data= reportUDefService.queryEntity(q);
        if(data!=null){
            reportUDefService.deleteByIdPhysical(data.getId());
        }
    }

    @Override
    public List<ReportFile> getReportFiles() {
        List<ReportUDef> list=reportUDefService.queryList(new ReportUDef());
        List<ReportFile> resList=new ArrayList<>();
        if(list!=null&&list.size()>0){
            for (ReportUDef tpl : list) {
                resList.add(new ReportFile(getCorrectName(tpl.getFileName()),tpl.getUpdateTime()));
            }
        }
        return resList;
    }

    @Override
    public void saveReport(String s, String s1) {
        String fname=getCorrectName(s);
        ReportUDef q=new ReportUDef();
        q.setFileName(fname);
        ReportUDef data= reportUDefService.queryEntity(q);
        if(data==null){
            ReportUDef def=new ReportUDef();
            def.setContent(s1);
            def.setUpdateTime(new Date());
            def.setFileName(getCorrectName(fname));
            reportUDefService.insert(def,false);

        }else{
            //更新
            data.setContent(s1);
            data.setUpdateTime(new Date());
            reportUDefService.update(data, SaveMode.NOT_NULL_FIELDS);
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public boolean disabled() {
        return disable;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    private String getCorrectName(String name){

        if(name.startsWith(prefix)){
            name = name.substring(prefix.length(), name.length());
        }
        return name;
    }

}
