package ro.adc.hra.employee;

import ro.adc.hra.base.ModificationIdHolder;
import ro.adc.hra.base.ServiceMessages;

class EmployeeModificationHandler implements EmployeeOperationHandler<EmployeeModification> {

    private final EmployeeRepository employeeRepo;

    public EmployeeModificationHandler(final EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void handleEmployeeOperation(final ModificationIdHolder modificationId,
            final EmployeeModification emplModif, final ServiceMessages messages) {
        final UpdateEmployeeDetailParam param = new UpdateEmployeeDetailParam();
        param.setEmployeeCodeIs(emplModif.getEmployeeCode());
        param.setEmployeeName(emplModif.getName());
        param.setModificationId(modificationId.get());
        employeeRepo.updateEmployeeDetail(param);
    }

}
