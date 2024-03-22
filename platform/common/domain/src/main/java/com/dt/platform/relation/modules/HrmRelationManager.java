package com.dt.platform.relation.modules;

import com.dt.platform.constants.db.EAMTables;
import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.domain.eam.MaintainProject;
import com.dt.platform.domain.eam.meta.InventoryMeta;
import com.dt.platform.domain.eam.meta.MaintainPlanMeta;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.*;
import com.github.foxnic.dao.relation.Join;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class HrmRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupRelations();
		this.setupProperties();
		this.setupPosition();
		this.setupPersonContract();
		this.setupCert();
		this.setupPerson();
		this.setupPersonFile();
		this.setupSalary();
		this.setupSalaryDetail();
		this.setupSalaryTpl();
		this.setupSalaryTplItem();
		this.setupSalaryAction();
		this.setupRecruitPersonRec();
		this.setupPersonAttendanceRec();
		this.setupPersonCert();
		this.setupPersonEducation();
		this.setupPersonSocialRelation();
		this.setupPersonWork();
		this.setupPersonScore();
		this.setupPersonResignation();
		this.setupPersonProjectCommissionRcd();
		this.setupPersonProjectTimeRcd();
		this.setupPersonProjectUnitRcd();
		this.setupPersonBusiInsure();
		this.setupScoreTplItem();
		this.setupScoreTpl();
		this.setupPersonTransferRcd();
		this.setupPersonTransfer();
		this.setupPersonLeave();
		this.setupPersonConfirmApply();
		this.setupAbsenceApply();
		this.setupAbsenceOfficeBusinessApply();
		this.setupAttendanceYearDay();
		this.setupTaskConf();
		this.setupTaskInst();
		this.setupScoreUser();

		this.setupAttendanceRecord();
		this.setupAttendanceTplDtl();
		this.setupAttendanceData();
		this.setupAttendanceOvertime();
		this.setupAttendanceHoliday();
		this.setupAttendanceOfficialBusi();
		this.setupTrainingInstructor();
		this.setupRecruitmentPlanApply();
		this.setupPersonnelRequirementApply();
		this.setupIncomeCertificateApply();
		this.setupInterview();
		this.setupPersonInterview();
		this.setupPersonStore();
		this.setupAttendanceDataProcess();
		this.setupAttendanceDate();
		this.setupAttendanceProcess();
		this.setupIndicator();


		this.setupAssessmentPlan();
		this.setupAssessmentTpl();
		this.setupAssessmentTask();
		this.setupAssessmentBill();
		this.setupAssessmentBillTask();
		this.setupAssessmentBillTaskDtl();
		this.setupAssessmentTaskUserMap();

		this.setupAssessmentTaskDtl();
		this.setupAssessmentIndicator();
		this.setupAssessmentIndicatorValue();
		this.setupAssessmentTaskPaper();

	}


	public void setupAssessmentIndicatorValue(){
		this.property(AssessmentIndicatorValueMeta.ASSESSMENT_INDICATOR_PROP)
				.using(HrTables.HR_ASSESSMENT_INDICATOR_VALUE.INDICATOR_ID).join(HrTables.HR_ASSESSMENT_INDICATOR.ID);
	}

	public void setupAssessmentTaskPaper(){
		this.property(AssessmentBillTaskPaperMeta.ASSESSMENT_INDICATOR_VALUE_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.ID).join(HrTables.HR_ASSESSMENT_INDICATOR_VALUE.TASK_PAPER_ID);

		this.property(AssessmentBillTaskPaperMeta.ASSESSOR_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.ASSESSOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(AssessmentBillTaskPaperMeta.ASSESSEE_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.ASSESSEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


	}
	public void setupAssessmentTaskUserMap(){



		this.property(AssessmentBillUserMapMeta.LEADER_USER_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.LEADER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(AssessmentBillUserMapMeta.SECOND_LEADER_USER_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.SECOND_LEADER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(AssessmentBillUserMapMeta.ASSESSEE_USER_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(AssessmentBillUserMapMeta.SAME_USER_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.condition("owner='same_user'")
				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(FoxnicWeb.HRM_EMPLOYEE.ID);


		this.property(AssessmentBillUserMapMeta.HR_USER_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.HR_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


		//关联数据
		this.property(AssessmentBillUserMapMeta.LEADER_USER_REL_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID)
			.using(FoxnicWeb.HRM_EMPLOYEE.DIRECT_LEADER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(AssessmentBillUserMapMeta.SECOND_LEADER_USER_REL_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.LEADER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID)
				.using(FoxnicWeb.HRM_EMPLOYEE.DIRECT_LEADER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		//上一直属领导的所有，如果一个领导管理多个，可能会导致数据跨部门同事数据带出来
		this.property(AssessmentBillUserMapMeta.SAME_USER_LIST_REL_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.LEADER_ID).join(FoxnicWeb.HRM_EMPLOYEE.DIRECT_LEADER_ID);



		//得分情况
		this.property(AssessmentBillUserMapMeta.SELF_SCORE_PAPER_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ID).join(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.USER_MAP_ID)
				.condition("relationship='self'")
		;
		//得分情况
		this.property(AssessmentBillUserMapMeta.SECOND_LEADER_SCORE_PAPER_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ID).join(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.USER_MAP_ID)
				.condition("relationship='secondLeader'")
		;

		//得分情况
		this.property(AssessmentBillUserMapMeta.LEADER_SCORE_PAPER_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ID).join(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.USER_MAP_ID)
				.condition("relationship='leader'")
		;
		//得分情况
		this.property(AssessmentBillUserMapMeta.SAME_SCORE_PAPER_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ID).join(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.USER_MAP_ID)
				.after((tag,point,checkItems,map)->{
					int total=checkItems.size();
					int w=0;
					int f=0;
					if(checkItems!=null&&checkItems.size()>0){
						BigDecimal sum =new BigDecimal("0");
						for(int i=0;i<checkItems.size();i++){
							if(checkItems.get(i).getAssesseeId().equals(checkItems.get(i).getAssessorId())){
								total--;
								continue;
							}
							sum=sum.add(checkItems.get(i).getScoreValue());
						}
						if(total>0){
							point.setSameUserAvgScoreValue(sum.divide(new BigDecimal(total)).toString());
						}
					}
					point.setSameScore(new BigDecimal(100));
			return checkItems;
		}).condition("relationship='sameUser'");

		//得分情况
		this.property(AssessmentBillUserMapMeta.INCOMPLETE_PAPER_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ID).join(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.USER_MAP_ID)
				.after((tag,point,checkItems,map)->{
					int self=0;
					int same=0;
					int leader=0;
					int secondleader=0;
					if(checkItems!=null&&checkItems.size()>0){
						for(int i=0;i<checkItems.size();i++){
							if("self".equals(checkItems.get(i).getRelationship())){
								self++;
							}else if("leader".equals(checkItems.get(i).getRelationship())){
								leader++;
							}else if("sameUser".equals(checkItems.get(i).getRelationship())){
								same++;
							}else if("secondLeader".equals(checkItems.get(i).getRelationship())){
								secondleader++;
							}
						}
					}
					point.setIncompleteLeaderPaperCount(leader+"");
					point.setIncompleteSelfPaperCount(self+"");
					point.setIncompleteSamePaperCount(same+"");
					point.setIncompleteSecondLeaderPaperCount(secondleader+"");
					return checkItems;
				}).using(HrTables.HR_ASSESSMENT_BILL_TASK_PAPER.BILL_TASK_DTL_ID).join(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.ID)
				.condition("status='wait'");

	}



	public void setupAssessmentIndicator(){

		this.property(AssessmentIndicatorMeta.INDICATOR_LIB_PROP)
				.using(HrTables.HR_ASSESSMENT_INDICATOR.TPL_INDICATOR_ID).join(HrTables.HR_INDICATOR_LIB.ID);
	}


	public void setupAssessmentBill(){

		this.property(AssessmentBillMeta.ASSESSMENT_BILL_TASK_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL.ID).join(HrTables.HR_ASSESSMENT_BILL_TASK.BILL_ID);


		this.property(AssessmentBillMeta.ASSESSMENT_TASK_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL.TASK_ID).join(HrTables.HR_ASSESSMENT_TASK.ID);

		this.property(AssessmentBillMeta.ASSESSMENT_DATA_TASK_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL.TASK_DATA_ID).join(HrTables.HR_ASSESSMENT_TASK.ID);
	}

	public void setupAssessmentBillTaskDtl(){
		this.property(AssessmentBillTaskDtlMeta.ASSESSMENT_BILL_TASK_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.BILL_TASK_ID).join(HrTables.HR_ASSESSMENT_BILL_TASK.ID);

		this.property(AssessmentBillTaskDtlMeta.ASSESSOR_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.BILL_TASK_ID).join(HrTables.HR_ASSESSMENT_BILL_TASK.ID)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
	}


	public void setupAssessmentPlan(){
		this.property(AssessmentPlanMeta.ASSESSMENT_TPL_PROP)
				.using(HrTables.HR_ASSESSMENT_PLAN.ID).join(HrTables.HR_ASSESSMENT_TPL.ID);
	}

	public void setupAssessmentTask(){



		this.property(AssessmentTaskMeta.TYPE_DICT_PROP)
				.using(HrTables.HR_ASSESSMENT_TASK.TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_assessment_type'");


		this.property(AssessmentTaskMeta.ASSESSMENT_TPL_PROP)
				.using(HrTables.HR_ASSESSMENT_TASK.TPL_ID).join(HrTables.HR_ASSESSMENT_TPL.ID);

		this.property(AssessmentTaskMeta.ORGANIZATION_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_TASK.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.condition("owner='org'")
			  .using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(FoxnicWeb.HRM_ORGANIZATION.ID);

		this.property(AssessmentTaskMeta.PERSON_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_TASK.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.condition("owner='person'")
				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(AssessmentTaskMeta.EXCLUDE_PERSON_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_TASK.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.condition("owner='experson'")
				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(AssessmentTaskMeta.ASSESSMENT_INDICATOR_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_TASK.ID).join(HrTables.HR_ASSESSMENT_INDICATOR.ASSESSMENT_ID);

		this.property(AssessmentTaskMeta.HR_USER_PROP)
				.using(HrTables.HR_ASSESSMENT_TASK.HR_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


	}

	public void setupAssessmentTaskDtl(){

		this.property(AssessmentBillTaskDtlMeta.WITH_LEADER_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.BILL_TASK_ID).join(HrTables.HR_ASSESSMENT_BILL_TASK.ID)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID).join(HrTables.HR_ASSESSMENT_BILL_USER_MAP.LEADER_ID)
				.condition("status='enable'")
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


		this.property(AssessmentBillTaskDtlMeta.WITH_SECOND_LEADER_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.BILL_TASK_ID).join(HrTables.HR_ASSESSMENT_BILL_TASK.ID)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID).join(HrTables.HR_ASSESSMENT_BILL_USER_MAP.SECOND_LEADER_ID)
				.condition("status='enable'")
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


		this.property(AssessmentBillTaskDtlMeta.WITH_SELF_USER_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.BILL_TASK_ID).join(HrTables.HR_ASSESSMENT_BILL_TASK.ID)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID).join(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID)
				.condition("status='enable'")
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(AssessmentBillTaskDtlMeta.WITH_SAME_USER_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.BILL_TASK_ID).join(HrTables.HR_ASSESSMENT_BILL_TASK.ID)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID).join(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID)
				.condition("status='enable'")
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.condition("owner='same_user'")
				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(FoxnicWeb.HRM_EMPLOYEE.ID);
	}

	public void setupAssessmentBillTask(){
		this.property(AssessmentBillTaskMeta.ASSESSMENT_TASK_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK.BILL_ID).join(HrTables.HR_ASSESSMENT_BILL.ID)
				.using(HrTables.HR_ASSESSMENT_BILL.TASK_ID).join(HrTables.HR_ASSESSMENT_TASK.ID);

		this.property(AssessmentBillTaskMeta.ASSESSMENT_DATA_TASK_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK.BILL_ID).join(HrTables.HR_ASSESSMENT_BILL.ID)
				.using(HrTables.HR_ASSESSMENT_BILL.TASK_DATA_ID).join(HrTables.HR_ASSESSMENT_TASK.ID);

		this.property(AssessmentBillTaskMeta.WITH_LEADER_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID).join(HrTables.HR_ASSESSMENT_BILL_USER_MAP.LEADER_ID)
				.condition("status='enable'")
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(AssessmentBillTaskMeta.WITH_SECOND_LEADER_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID).join(HrTables.HR_ASSESSMENT_BILL_USER_MAP.SECOND_LEADER_ID)
				.condition("status='enable'")
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(AssessmentBillTaskMeta.WITH_SAME_USER_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID).join(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ASSESSEE_ID)
				.condition("status='enable'")
				.using(HrTables.HR_ASSESSMENT_BILL_USER_MAP.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.condition("owner='same_user'")
				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(FoxnicWeb.HRM_EMPLOYEE.ID);



		this.property(AssessmentBillTaskMeta.ASSESSOR_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK.ASSESSOR_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(AssessmentBillTaskMeta.ASSESSMENT_BILL_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK.BILL_ID).join(HrTables.HR_ASSESSMENT_BILL.ID);


		this.property(AssessmentBillTaskMeta.ASSESSMENT_BILL_TASK_DTL_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_BILL_TASK.ID).join(HrTables.HR_ASSESSMENT_BILL_TASK_DTL.BILL_TASK_ID);


	}


	public void setupAssessmentTpl(){
		this.property(AssessmentTplMeta.POSITION_LIST_PROP)
				.using(HrTables.HR_ASSESSMENT_TPL.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.condition("owner='pos'")
				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(HrTables.HR_POSITION.ID);


		this.property(AssessmentTplMeta.TYPE_DICT_PROP)
				.using(HrTables.HR_ASSESSMENT_TPL.TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_assessment_type'");

	}

	public void setupIndicator(){
		this.property(IndicatorLibMeta.TYPE_DICT_PROP)
				.using(HrTables.HR_INDICATOR_LIB.TYPE_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_indicator_lib'");

	}

	public void setupAttendanceProcess(){

		this.property(AttendanceProcessMeta.PERSON_LIST_PROP)
				.using(HrTables.HR_ATTENDANCE_PROCESS.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.condition("owner='def'")
				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(HrTables.HR_PERSON.ID);

		this.property(AttendanceProcessMeta.ORGANIZATION_LIST_PROP)
				.using(HrTables.HR_ATTENDANCE_PROCESS.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.condition("owner='def'")
				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(FoxnicWeb.HRM_ORGANIZATION.ID);

	}



	public void setupAttendanceDate(){

		this.property(AttendanceDateMeta.ATTENDANCE_TPL_LIST_PROP)
				.using(HrTables.HR_ATTENDANCE_DATE.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.condition("owner='def'")
				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(HrTables.HR_ATTENDANCE_TPL.CODE);

		this.property(AttendanceDateMeta.ATTENDANCE_TPL_LIST2_PROP)
				.using(HrTables.HR_ATTENDANCE_DATE.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.condition("owner='need'")
				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(HrTables.HR_ATTENDANCE_TPL.CODE);

		this.property(AttendanceDateMeta.ATTENDANCE_TPL_LIST3_PROP)
				.using(HrTables.HR_ATTENDANCE_DATE.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.condition("owner='half'")
				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(HrTables.HR_ATTENDANCE_TPL.CODE);
	}

	public void setupAttendanceDataProcess(){
		this.property(AttendanceDataProcessMeta.PERSON_PROP)
				.using(HrTables.HR_ATTENDANCE_DATA_PROCESS.PERSON_ID).join(HrTables.HR_PERSON.ID);

	}


	public void setupPersonStore(){
		this.property(PersonStoreMeta.SEX_DICT_PROP)
				.using(HrTables.HR_PERSON_STORE.SEX_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='sex'");


		this.property(PersonStoreMeta.MARITAL_STATUS_DICT_PROP)
				.using(HrTables.HR_PERSON_STORE.MARITAL_STATUS).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_marital_status'");

		this.property(PersonStoreMeta.EDUCATION_DATA_PROP)
				.using(HrTables.HR_PERSON_STORE.EDUCATION_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_education'");

		this.property(PersonStoreMeta.POLITIC_COUNTENANCE_DATA_PROP)
				.using(HrTables.HR_PERSON_STORE.POLITIC_COUNTENANCE_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_politic_countenance'");

//		this.property(PersonStoreMeta.ORGANIZATION_PROP)
//				.using(HrTables.HR_PERSON_STORE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
//				.condition("dict_code='hr_education'");
	}

	public void setupInterview() {
		this.property(InterviewMeta.EMPLOYEE_PROP)
				.using(HrTables.HR_INTERVIEW.USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

	}

	public void setupPersonInterview() {

		this.property(PersonInterviewMeta.INTERVIEW_PROP)
				.using(HrTables.HR_PERSON_INTERVIEW.INTERVIEW_ID).join(HrTables.HR_INTERVIEW.ID);


		this.property(PersonInterviewMeta.ORGANIZATION_PROP)
				.using(HrTables.HR_PERSON_INTERVIEW.ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

		this.property(PersonInterviewMeta.SEX_DICT_PROP)
				.using(HrTables.HR_PERSON_INTERVIEW.SEX_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='sex'");

		this.property(PersonInterviewMeta.SOURCE_DICT_PROP)
				.using(HrTables.HR_PERSON_INTERVIEW.SOURCE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_interview_profile_source'");

		this.property(PersonInterviewMeta.INTERVIEW_METHOD_DICT_PROP)
				.using(HrTables.HR_PERSON_INTERVIEW.INTERVIEW_METHOD).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_interview_method'");


		this.property(PersonInterviewMeta.EDUCATION_DATA_PROP)
				.using(HrTables.HR_PERSON_INTERVIEW.EDUCATION_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_education'");

	}


	public void setupIncomeCertificateApply() {
		this.property(PersonIncomeCertificateApplyMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.PERSON_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(PersonIncomeCertificateApplyMeta.ORGANIZATION_PROP)
				.using(HrTables.HR_PERSON_INCOME_CERTIFICATE_APPLY.ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

	}

	public void setupRecruitmentPlanApply() {
		this.property(RecruitmentPlanApplyMeta.PERSON_PROP)
				.using(HrTables.HR_RECRUITMENT_PLAN_APPLY.APPLY_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(RecruitmentPlanApplyMeta.ORGANIZATION_PROP)
				.using(HrTables.HR_RECRUITMENT_PLAN_APPLY.ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

	}
	public void setupPersonnelRequirementApply() {

		this.property(PersonnelRequirementApplyMeta.PERSON_PROP)
				.using(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.APPLY_USER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(PersonnelRequirementApplyMeta.ORGANIZATION_PROP)
				.using(HrTables.HR_PERSONNEL_REQUIREMENT_APPLY.ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

	}

	public void setupTrainingInstructor() {

		this.property(TrainingInstructorMeta.TRAINING_INSTITUTION_PROP)
				.using(HrTables.HR_TRAINING_INSTRUCTOR.ORG_ID).join(HrTables.HR_TRAINING_INSTITUTION.ID);
	}

	public void setupAttendanceOvertime() {
		this.property(AttendanceOvertimeMeta.PERSON_PROP)
				.using(HrTables.HR_ATTENDANCE_OVERTIME.PERSON_ID).join(HrTables.HR_PERSON.ID);

		this.property(AttendanceOvertimeMeta.TYPE_DICT_PROP)
				.using(HrTables.HR_ATTENDANCE_OVERTIME.ACTION_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_attendance_overtime_type'");


	}

	public void setupAttendanceHoliday() {
		this.property(AttendanceHolidayMeta.PERSON_PROP)
				.using(HrTables.HR_ATTENDANCE_HOLIDAY.PERSON_ID).join(HrTables.HR_PERSON.ID);

		this.property(AttendanceHolidayMeta.TYPE_DICT_PROP)
				.using(HrTables.HR_ATTENDANCE_HOLIDAY.ACTION_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_attendance_h_type'");

		this.property(AttendanceHolidayMeta.ATTENDANCE_TPL_LIST_PROP)
				.using(HrTables.HR_ATTENDANCE_HOLIDAY.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.condition("owner='def'")
				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(HrTables.HR_ATTENDANCE_TPL.CODE);



	}

	public void setupAttendanceOfficialBusi() {
		this.property(AttendanceOfficialBusiMeta.PERSON_PROP)
				.using(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.PERSON_ID).join(HrTables.HR_PERSON.ID);

		this.property(AttendanceOfficialBusiMeta.TYPE_DICT_PROP)
				.using(HrTables.HR_ATTENDANCE_OFFICIAL_BUSI.ACTION_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_attendance_ob_type'");
	}

	public void setupAttendanceData() {



		this.property(AttendanceDataMeta.PERSON_PROP)
				.using(HrTables.HR_ATTENDANCE_DATA.PERSON_ID).join(HrTables.HR_PERSON.ID);


		this.property(AttendanceDataMeta.ATTENDANCE_TPL_PROP)
				.using(HrTables.HR_ATTENDANCE_DATA.ATTENDANCE_TPL_CODE).join(HrTables.HR_ATTENDANCE_TPL.CODE);


	}
	public void setupAttendanceTplDtl() {
		this.property(AttendanceTplDtlMeta.WEEK_DICT_PROP)
				.using(HrTables.HR_ATTENDANCE_TPL_DTL.WEEK).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_attendance_week'");

		this.property(AttendanceTplDtlMeta.FIRST_GROUP_PROP)
				.using(HrTables.HR_ATTENDANCE_TPL_DTL.FIRST_WORK).join(HrTables.HR_ATTENDANCE_TPL_GROUP.ID);

		this.property(AttendanceTplDtlMeta.SECOND_GROUP_PROP)
				.using(HrTables.HR_ATTENDANCE_TPL_DTL.SECOND_WORK).join(HrTables.HR_ATTENDANCE_TPL_GROUP.ID);

//
//		this.property(AttendanceTplMeta.UP_DAY_WEEK_DICT_PROP)
//				.using(HrTables.HR_ATTENDANCE_TPL.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
//				.condition("owner='up'")
//				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
//				.condition("dict_code='hr_attendance_week'");
//
//		this.property(AttendanceTplMeta.DOWN_DAY_WEEK_DICT_PROP)
//				.using(HrTables.HR_ATTENDANCE_TPL.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
//				.condition("owner='down'")
//				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
//				.condition("dict_code='hr_attendance_week'");
	}
	public void setupAttendanceRecord() {

		this.property(AttendanceRecordMeta.PERSON_PROP)
				.using(HrTables.HR_ATTENDANCE_RECORD.PERSON_ID).join(HrTables.HR_PERSON.ID);

	}
	public void setupTaskConf() {
		this.property(ScoreTaskConfMeta.SCORE_TPL_PROP)
				.using(HrTables.HR_SCORE_TASK_CONF.TPL_ID).join(HrTables.HR_SCORE_TPL.ID);

		this.property(ScoreTaskConfMeta.EVALUATION_RELATION_PROP)
				.using(HrTables.HR_SCORE_TASK_CONF.RELATIONSHIP).join(HrTables.HR_EVALUATION_RELATION.ID);
	}

	public void setupTaskInst() {
		this.property(ScoreTaskInstMeta.SCORE_TPL_PROP)
				.using(HrTables.HR_SCORE_TASK_INST.TPL_ID).join(HrTables.HR_SCORE_TPL.ID);

		this.property(ScoreTaskInstMeta.EVALUATION_RELATION_PROP)
				.using(HrTables.HR_SCORE_TASK_INST.RELATIONSHIP).join(HrTables.HR_EVALUATION_RELATION.CODE);

	}
	public void setupScoreUser() {

		this.property(ScoreUserMeta.RATED_USER_PROP)
				.using(HrTables.HR_SCORE_USER.RATED_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(ScoreUserMeta.RATER_USER_PROP)
				.using(HrTables.HR_SCORE_USER.RATER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(ScoreUserMeta.SCORE_TPL_PROP)
				.using(HrTables.HR_SCORE_USER.TPL_ID).join(HrTables.HR_SCORE_TPL.ID);

		this.property(ScoreUserMeta.EVALUATION_RELATION_PROP)
				.using(HrTables.HR_SCORE_USER.RELATIONSHIP).join(HrTables.HR_EVALUATION_RELATION.ID);



	}
	public void setupAttendanceYearDay() {
		this.property(AttendanceYearDayMeta.PERSON_PROP)
				.using(HrTables.HR_ATTENDANCE_YEAR_DAY.PERSON_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

	}

	public void setupPersonLeave() {
		this.property(PersonLeaveMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_LEAVE.PERSON_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(PersonLeaveMeta.HANDOVER_PROP)
				.using(HrTables.HR_PERSON_LEAVE.HANDOVER_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

	}
	public void setupPersonConfirmApply() {
		this.property(PersonConfirmApplyMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_CONFIRM_APPLY.PERSON_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
	}
	public void setupAbsenceApply() {
		this.property(PersonAbsenceApplyMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_ABSENCE_APPLY.PERSON_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(PersonAbsenceApplyMeta.ATTENDANCE_TYPE_PROP)
				.using(HrTables.HR_PERSON_ABSENCE_APPLY.APPLY_TYPE).join(HrTables.HR_ATTENDANCE_TYPE.CODE);


	}

	public void setupAbsenceOfficeBusinessApply() {

		this.property(PersonOfficialBusinessMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_OFFICIAL_BUSINESS.PERSON_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

	}


	public void setupScoreTpl() {
		this.property(ScoreTplMeta.SCORE_TPL_ITEM_LIST_PROP)
				.using(HrTables.HR_SCORE_TPL.ID).join(HrTables.HR_SCORE_TPL_ITEM.TPL_ID);

	}

	public void setupScoreTplItem() {

		this.property(ScoreTplItemMeta.SCORE_INDICATOR_PROP)
				.using(HrTables.HR_SCORE_TPL_ITEM.GROUP_ID).join(HrTables.HR_SCORE_INDICATOR.ID);

	}

	public void setupPersonBusiInsure() {

		this.property(PersonBusiInsureMeta.PERSON_BUSI_INSURE_TYPE_PROP)
				.using(HrTables.HR_PERSON_BUSI_INSURE.TYPE_CODE).join(HrTables.HR_PERSON_BUSI_INSURE_TYPE.CODE);

		this.property(PersonBusiInsureMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_BUSI_INSURE.PERSON_ID).join(HrTables.HR_PERSON.ID);
	}

	public void setupPersonProjectUnitRcd() {
		this.property(SalaryProjectUnitRcdMeta.PERSON_PROP)
				.using(HrTables.HR_SALARY_PROJECT_UNIT_RCD.PERSON_ID).join(HrTables.HR_PERSON.ID);

		this.property(SalaryProjectUnitRcdMeta.PROJECT_PROP)
				.using(HrTables.HR_SALARY_PROJECT_UNIT_RCD.PROJECT_CODE).join(HrTables.HR_SALARY_PROJECT_UNIT.CODE);

	}

	public void setupPersonProjectTimeRcd() {

		this.property(SalaryProjectTimeRcdMeta.PERSON_PROP)
				.using(HrTables.HR_SALARY_PROJECT_TIME_RCD.PERSON_ID).join(HrTables.HR_PERSON.ID);

		this.property(SalaryProjectTimeRcdMeta.PROJECT_PROP)
				.using(HrTables.HR_SALARY_PROJECT_TIME_RCD.PROJECT_CODE).join(HrTables.HR_SALARY_PROJECT_TIME.CODE);

	}

	public void setupPersonProjectCommissionRcd() {

		this.property(SalaryProjectCommissionRcdMeta.PERSON_PROP)
				.using(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PERSON_ID).join(HrTables.HR_PERSON.ID);

		this.property(SalaryProjectCommissionRcdMeta.PROJECT_PROP)
				.using(HrTables.HR_SALARY_PROJECT_COMMISSION_RCD.PROJECT_CODE).join(HrTables.HR_SALARY_PROJECT_COMMISSION.CODE);

	}


	public void setupSalaryTpl() {


		this.property(SalaryTplMeta.SALARY_TPL_ITEM_PROP)
				.using(HrTables.HR_SALARY_TPL.ID).join(HrTables.HR_SALARY_TPL_ITEM.TPL_ID);

		this.property(SalaryTplMeta.VALID_SALARY_TPL_ITEM_PROP)
				.using(HrTables.HR_SALARY_TPL.ID).join(HrTables.HR_SALARY_TPL_ITEM.TPL_ID)
				.condition("status='enable'");
	}

	public void setupSalaryTplItem() {
		this.property(SalaryTplItemMeta.SALARY_COLUMN_PROP)
				.using(HrTables.HR_SALARY_TPL_ITEM.CODE).join(HrTables.HR_SALARY_COLUMN.COL_CODE);
	}


	public void setupPersonTransferRcd() {
		this.property(PersonTransferRcdMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_TRANSFER_RCD.PERSON_ID).join(HrTables.HR_PERSON.ID);
	}

	public void setupPersonTransfer() {

		this.property(PersonTransferMeta.PERSON_LIST_PROP)
				.using(HrTables.HR_PERSON_TRANSFER.ID).join(HrTables.HR_PERSON_TRANSFER_RCD.TRANSFER_ID)
				.using(HrTables.HR_PERSON_TRANSFER_RCD.PERSON_ID).join(HrTables.HR_PERSON.ID);

		this.property(PersonTransferMeta.ORGANIZATION_PROP)
				.using(HrTables.HR_PERSON_TRANSFER.ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

		this.property(PersonTransferMeta.POSITION_PROP)
				.using(HrTables.HR_PERSON_TRANSFER.POSITION_CODE).join(HrTables.HR_POSITION.ID);

	}


	public void setupPersonResignation() {
		this.property(PersonResignationMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_RESIGNATION.PERSON_ID).join(HrTables.HR_PERSON.ID);
	}


	public void setupPersonScore() {
		this.property(PersonScoreMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_SCORE.PERSON_ID).join(HrTables.HR_PERSON.ID);
	}
	public void setupPersonCert() {
		this.property(PersonCertificateMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_CERTIFICATE.EMPLOYEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(PersonCertificateMeta.USER_PROP)
				.using(HrTables.HR_PERSON_CERTIFICATE.PERSON_ID).join(HrTables.HR_PERSON.ID);
	}

	public void setupPersonEducation() {
		this.property(PersonEducationMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_EDUCATION.EMPLOYEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
		this.property(PersonEducationMeta.EDUCATION_INFO_PROP)
				.using(HrTables.HR_PERSON_EDUCATION.EDUCATION).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_person_education'");

		this.property(PersonEducationMeta.USER_PROP)
				.using(HrTables.HR_PERSON_EDUCATION.PERSON_ID).join(HrTables.HR_PERSON.ID);
	}

	public void setupPersonSocialRelation() {
		this.property(PersonSocialRelationMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_SOCIAL_RELATION.EMPLOYEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
		this.property(PersonSocialRelationMeta.SOCIAL_RELATION_TYPE_PROP)
				.using(HrTables.HR_PERSON_SOCIAL_RELATION.REL_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_social_relation_type'");
		this.property(PersonSocialRelationMeta.SOCIAL_RELATION_PROP)
				.using(HrTables.HR_PERSON_SOCIAL_RELATION.REL).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_social_relation'");
		this.property(PersonSocialRelationMeta.USER_PROP)
				.using(HrTables.HR_PERSON_SOCIAL_RELATION.PERSON_ID).join(HrTables.HR_PERSON.ID);


	}
	public void setupPersonWork() {
		this.property(PersonWorkExperienceMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_WORK_EXPERIENCE.EMPLOYEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);

		this.property(PersonWorkExperienceMeta.USER_PROP)
				.using(HrTables.HR_PERSON_WORK_EXPERIENCE.PERSON_ID).join(HrTables.HR_PERSON.ID);

	}

	public void setupProperties() {
	}

	private void setupRelations() {
	}

	private void setupPersonAttendanceRec() {
		this.property(PersonAttendanceRecMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_ATTENDANCE_REC.PERSON_ID).join(HrTables.HR_PERSON.ID);
		this.property(PersonAttendanceRecMeta.EMPLOYEE_PROP)
				.using(HrTables.HR_PERSON_ATTENDANCE_REC.EMPLOYEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);
	}

	private void setupRecruitPersonRec() {
		this.property(RecruitPersonRecMeta.RECRUIT_POST_REC_PROP)
				.using(HrTables.HR_RECRUIT_PERSON_REC.POST_ID).join(HrTables.HR_RECRUIT_POST_REC.ID);

	}

	private void setupSalaryAction() {

		this.property(SalaryActionMeta.SALARY_DETAIL_LIST_PROP)
				.using(HrTables.HR_SALARY_ACTION.ID).join(HrTables.HR_SALARY_DETAIL.ACTION_ID);


		this.property(SalaryActionMeta.SALARY_TPL_PROP)
				.using(HrTables.HR_SALARY_ACTION.TPL_ID).join(HrTables.HR_SALARY_TPL.ID);

		this.property(SalaryActionMeta.PERSON_LIST_PROP)
				.using(HrTables.HR_SALARY_ACTION.TPL_ID).join(HrTables.HR_SALARY_TPL.ID)

				.using(HrTables.HR_SALARY_TPL.ID).join(HrTables.HR_PERSON.SALARY_TPL_ID);
		this.property(SalaryActionMeta.SALARY_MONTH_PROP)
				.using(HrTables.HR_SALARY_ACTION.ACTION_MONTH).join(HrTables.HR_SALARY_MONTH.CODE);
	}

	private void setupPersonFile() {

		this.property(PersonFileMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_FILE.USER_ID).join(HrTables.HR_PERSON.ID);
	}

	private void setupCert() {

		this.property(CertificateMeta.CERTIFICATE_LEVEL_PROP)
				.using(HrTables.HR_CERTIFICATE.CERT_LEVEL).join(HrTables.HR_CERTIFICATE_LEVEL.ID);

		this.property(CertificateMeta.CERTIFICATE_TYPE_PROP)
				.using(HrTables.HR_CERTIFICATE.TYPE).join(HrTables.HR_CERTIFICATE_TYPE.ID);
	}


	private void setupPosition() {
		this.property(PositionMeta.POSITION_TYPE_PROP)
				.using(HrTables.HR_POSITION.TYPE).join(HrTables.HR_POSITION_TYPE.ID);

	}




	private void setupSalary() {
		this.property(SalaryMeta.PERSON_PROP)
				.using(HrTables.HR_SALARY.PERSON_ID).join(HrTables.HR_PERSON.ID);

	}


	private void setupSalaryDetail() {

		this.property(SalaryDetailMeta.PERSON_SALARY_PROP)
				.using(HrTables.HR_SALARY_DETAIL.PERSON_ID).join(HrTables.HR_SALARY.PERSON_ID);

		this.property(SalaryDetailMeta.PERSON_PROP)
				.using(HrTables.HR_SALARY_DETAIL.PERSON_ID).join(HrTables.HR_PERSON.ID);

		this.property(SalaryDetailMeta.SALARY_TPL_PROP)
				.using(HrTables.HR_SALARY_DETAIL.TPL_ID).join(HrTables.HR_SALARY_TPL.ID);

		this.property(SalaryDetailMeta.SALARY_ACTION_PROP)
				.using(HrTables.HR_SALARY_DETAIL.ACTION_ID).join(HrTables.HR_SALARY_ACTION.ID);

	}

	private void setupPersonContract() {

		this.property(PersonContractMeta.CONTRACT_YEAR_DATA_PROP)
				.using(HrTables.HR_PERSON_CONTRACT.CONTRACT_YEAR).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_contract_year'");

		this.property(PersonContractMeta.CONTRACT_TYPE_DATA_PROP)
				.using(HrTables.HR_PERSON_CONTRACT.TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_contract_type'");

		this.property(PersonContractMeta.CONTRACT_ORG_PROP)
				.using(HrTables.HR_PERSON_CONTRACT.CONTRACT_PARTY_ID).join(HrTables.HR_CONTRACT_ORG.ID);


		this.property(PersonContractMeta.PERSON_PROP)
				.using(HrTables.HR_PERSON_CONTRACT.PERSON_ID).join(HrTables.HR_PERSON.ID);

		this.property(PersonContractMeta.EMPLOYEE_PROP)
				.using(HrTables.HR_PERSON_CONTRACT.PERSON_ID).join(HrTables.HR_PERSON.ID)
				.using(HrTables.HR_PERSON.EMPLOYEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);


	}

	private void setupPerson() {

		this.property(PersonMeta.ATTENDANCE_TPL_PROP)
				.using(HrTables.HR_PERSON.ATTENDANCE_TPL_CODE).join(HrTables.HR_ATTENDANCE_TPL.CODE);

		this.property(PersonMeta.ORGANIZATION_PROP)
				.using(HrTables.HR_PERSON.ORG_ID).join(FoxnicWeb.HRM_ORGANIZATION.ID);

		this.property(PersonMeta.SALARY_TPL_PROP)
				.using(HrTables.HR_PERSON.SALARY_TPL_ID).join(HrTables.HR_SALARY_TPL.ID);

		this.property(PersonMeta.SALARY_PROP)
				.using(HrTables.HR_PERSON.ID).join(HrTables.HR_SALARY.PERSON_ID);

		this.property(PersonMeta.RANK_PROP)
				.using(HrTables.HR_PERSON.RANK_CODE).join(HrTables.HR_RANK.ID);

		this.property(PersonMeta.POSITION_PROP)
				.using(HrTables.HR_PERSON.POSITION_CODE).join(HrTables.HR_POSITION.ID);

		this.property(PersonMeta.PROFESSIONAL_LEVEL_PROP)
				.using(HrTables.HR_PERSON.EMPLOYEE_TITLE_CODE).join(HrTables.HR_PROFESSIONAL_LEVEL.ID);

		this.property(PersonMeta.BLOOD_TYPE_DICT_PROP)
				.using(HrTables.HR_PERSON.BLOOD_TYPE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_blood_type'");

		this.property(PersonMeta.EMPLOYEE_IDENTITY_PROP)
				.using(HrTables.HR_PERSON.EMPLOYEE_IDENTITY_STATUS).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_employee_identity_status'");


		this.property(PersonMeta.BANK_PROP)
				.using(HrTables.HR_PERSON.PAYROLL_CARD_BANK_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_bank_list'");

		this.property(PersonMeta.SEX_DICT_PROP)
				.using(HrTables.HR_PERSON.SEX_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='sex'");

		this.property(PersonMeta.MARITAL_STATUS_DICT_PROP)
				.using(HrTables.HR_PERSON.MARITAL_STATUS).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_marital_status'");

		this.property(PersonMeta.EMPLOYEE_OWNER_TYPE_DICT_PROP)
				.using(HrTables.HR_PERSON.EMPLOYEE_TYPE_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_employee_owner_type'");

		this.property(PersonMeta.EDUCATION_DATA_PROP)
				.using(HrTables.HR_PERSON.EDUCATION_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_education'");

		this.property(PersonMeta.POLITIC_COUNTENANCE_DATA_PROP)
				.using(HrTables.HR_PERSON.POLITIC_COUNTENANCE_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_politic_countenance'");


		this.property(PersonMeta.EMPLOYEE_PROP)
				.using(HrTables.HR_PERSON.EMPLOYEE_ID).join(FoxnicWeb.HRM_EMPLOYEE.ID);



	}

	private void setupDcRack() {
//				this.property(DC_RACK.class, "roles", Role.class, "角色清单", "当前用户的所有角色清单").list().
//				using(new DBField[]{FoxnicWeb.SYS_USER.ID}).
//				join(new DBField[]{FoxnicWeb.SYS_ROLE_USER.USER_ID}).
//				using(new DBField[]{FoxnicWeb.SYS_ROLE_USER.ROLE_ID}).
//				join(new DBField[]{FoxnicWeb.SYS_ROLE.ID});
}


}
