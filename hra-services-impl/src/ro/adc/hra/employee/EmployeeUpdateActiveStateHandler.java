package ro.adc.hra.employee;

import ro.adc.hra.base.ModificationIdHolder;
import ro.adc.hra.base.ServiceInfo;
import ro.adc.hra.base.ServiceMessages;

class EmployeeUpdateActiveStateHandler implements EmployeeOperationHandler<EmployeeUpdateActiveState> {

    private final EmployeeRepository employeeRepo;

    public EmployeeUpdateActiveStateHandler(final EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void handleEmployeeOperation(final ModificationIdHolder modificationId,
            final EmployeeUpdateActiveState emplModif, final ServiceMessages messages) {
        final UpdateEmployeeActiveStateParam param = UpdateEmployeeActiveStateParam.builder()
                .activeState(emplModif.getActiveState())
                .criteria(EmployeeCriteria.builder().employeeCodeEq(emplModif.getEmployeeCode()).build())
                .modificationId(modificationId.get()).build();
        employeeRepo.updateEmployeeActiveState(param);
        final ServiceInfo info = new ServiceInfo();
        info.setMessage(String.format("!!!Angajatul a fost %s.", param.getActiveState() ? "activat" : "dezactivat"));
        messages.addInfo(info);
    }

}
