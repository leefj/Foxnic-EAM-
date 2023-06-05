package com.dt.platform.relation.modules;

import com.dt.platform.constants.db.HrTables;
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
		this.setupSalaryAction();

		this.setupRecruitPersonRec();
	}
 
	public void setupProperties() {

	}
	
	private void setupRelations() {

	}

	private void setupRecruitPersonRec() {
		this.property(RecruitPersonRecMeta.RECRUIT_POST_REC_PROP)
				.using(HrTables.HR_RECRUIT_PERSON_REC.POST_ID).join(HrTables.HR_RECRUIT_POST_REC.ID);
	}

	private void setupSalaryAction() {


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
