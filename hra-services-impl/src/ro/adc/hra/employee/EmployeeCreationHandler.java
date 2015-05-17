package ro.adc.hra.employee;

import java.util.UUID;

import ro.adc.hra.base.ModificationIdHolder;
import ro.adc.hra.base.ServiceInfo;
import ro.adc.hra.base.ServiceMessages;

class EmployeeCreationHandler implements EmployeeOperationHandler<EmployeeCreation> {

    private final EmployeeRepository employeeRepo;

    public EmployeeCreationHandler(final EmployeeRepository employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public void handleEmployeeOperation(final ModificationIdHolder modificationId, final EmployeeCreation operation,
            final ServiceMessages messages) {
        final CreateEmployeeParam createParam = new CreateEmployeeParam();
        createParam.setEmployeeDetail(operation.getEmployeeDetail());
        createParam.getEmployeeDetail().getBasic().setUuid(UUID.randomUUID().toString());
        createParam.setModificationId(modificationId.get());
        employeeRepo.createEmployee(createParam);
        final ServiceInfo info = new ServiceInfo();
        info.setMessage("!!!Angajatul a fost creat cu succes");
        messages.addInfo(info);
    }

}
