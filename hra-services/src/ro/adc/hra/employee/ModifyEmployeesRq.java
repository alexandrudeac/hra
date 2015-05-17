package ro.adc.hra.employee;

import java.util.List;

import ro.adc.hra.base.ServiceRq;

public class ModifyEmployeesRq extends ServiceRq {

    private static final long serialVersionUID = 1L;
    private List<EmployeeOperation> operations;

    public List<EmployeeOperation> getOperations() {
        return operations;
    }

    public void setOperations(final List<EmployeeOperation> operations) {
        this.operations = operations;
    }

}
