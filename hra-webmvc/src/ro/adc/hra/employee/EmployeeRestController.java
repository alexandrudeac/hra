package ro.adc.hra.employee;

import javax.inject.Inject;

import org.joda.time.LocalDateTime;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ro.adc.hra.base.OperationInfo;

import com.google.common.collect.ImmutableList;

@RestController
public class EmployeeRestController {

	private final EmployeeServices employeeServices;

	@Inject
	public EmployeeRestController(final EmployeeServices employeeServices) {
		this.employeeServices = employeeServices;
	}

	@RequestMapping(value = "/employee/{code}/updateActiveState", method = RequestMethod.POST)
	public ModifyEmployeesRs updateEmployeeActiveState(
			@PathVariable("code") final String code,
			@RequestParam(value = "active") final Boolean activeState) {
	    final EmployeeUpdateActiveState emplModif = new EmployeeUpdateActiveState();
        emplModif.setEmployeeCode(code);
        emplModif.setActiveState(activeState);
		return callEmployeeOperation(emplModif);
	}

	@RequestMapping(value = "/employee/{code}/delete", method = RequestMethod.POST)
    public ModifyEmployeesRs delete(
            @PathVariable("code") final String code,
            @RequestParam(value = "active") final Boolean activeState) {
	    final EmployeeDeletion emplDel = new EmployeeDeletion();
        emplDel.setEmployeeCode(code);
       return callEmployeeOperation(emplDel);
    }

    private ModifyEmployeesRs callEmployeeOperation(final EmployeeOperation op) {
        final ModifyEmployeesRq rq = new ModifyEmployeesRq();
        rq.setOperations(ImmutableList.<EmployeeOperation> builder().add(op).build());
        rq.setOperatorLocale("ro");
        rq.setOperationInfo(new OperationInfo("user-todo", LocalDateTime.now()));
        final ModifyEmployeesRs rs = employeeServices.modifyEmployees(rq);
        return rs;
    }
}
