package com.dt.platform.common.service.impl;

import com.github.foxnic.api.transter.Result;
import com.github.foxnic.commons.log.Logger;
import org.github.foxnic.web.constants.enums.system.UnifiedUserType;
import org.github.foxnic.web.domain.bpm.ProcessInstance;
import org.github.foxnic.web.domain.hrm.Employee;
import org.github.foxnic.web.domain.oauth.User;
import org.github.foxnic.web.framework.busi.role.BusiRoleMemberRouter;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.proxy.oauth.UserServiceProxy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BusiRoleDrafter implements BusiRoleMemberRouter {

    @Override
    public List<Employee> getMembers(Context context) {
        Logger.info("BusiRoleDrafter Content:"+context.toString());
        Logger.info("BusiRoleDrafter Bills:"+context.getBillIds());
        Logger.info("BusiRoleDrafter ProcessInstance:"+context.getProcessInstance().toString());
        List<Employee> employees = new ArrayList();
        ProcessInstance processInstance = context.getProcessInstance();
        Result<Employee> empResult = null;
        if (processInstance.getDrafterTypeEnum() == UnifiedUserType.employee) {
            empResult = EmployeeServiceProxy.api().getById(processInstance.getDrafterId());
            if (empResult.success() && empResult.data() != null) {
                employees.add(((Employee)empResult.data()));
            }
        }

        if (employees.isEmpty()) {
            Result<User> userResult = UserServiceProxy.api().getById(processInstance.getDrafterUserId());
            if (userResult.success() && userResult.data() != null) {
                empResult = EmployeeServiceProxy.api().getById(((User)userResult.data()).getActivatedEmployeeId());
                if (empResult.success() && empResult.data() != null) {
                    employees.add(((Employee)empResult.data()));
                }
            }
        }
        return employees;
    }
}
