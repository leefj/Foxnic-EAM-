package com.dt.platform.relation.modules;

import com.dt.platform.constants.db.HrTables;
import com.dt.platform.constants.db.SysTables;
import com.dt.platform.domain.hr.*;
import com.dt.platform.domain.hr.meta.*;
import com.github.foxnic.dao.relation.RelationManager;
import org.github.foxnic.web.constants.db.FoxnicWeb;

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
		this.setupAttendanceTpl();
		this.setupAttendanceData();

	}

	public void setupAttendanceData() {

		this.property(AttendanceDataMeta.PERSON_PROP)
				.using(HrTables.HR_ATTENDANCE_DATA.PERSON_ID).join(HrTables.HR_PERSON.ID);


		this.property(AttendanceDataMeta.ATTENDANCE_TPL_PROP)
				.using(HrTables.HR_ATTENDANCE_DATA.ATTENDANCE_TPL_CODE).join(HrTables.HR_ATTENDANCE_TPL.CODE);





	}
	public void setupAttendanceTpl() {
		this.property(AttendanceTplMeta.WEEK_DICT_PROP)
				.using(HrTables.HR_ATTENDANCE_TPL.ID).join(SysTables.SYS_MAPPING_OWNER.OWNER_ID)
				.using(SysTables.SYS_MAPPING_OWNER.SELECTED_CODE).join(FoxnicWeb.SYS_DICT_ITEM.CODE)
				.condition("dict_code='hr_attendance_week'");
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
