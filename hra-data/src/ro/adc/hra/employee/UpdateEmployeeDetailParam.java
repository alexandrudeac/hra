package ro.adc.hra.employee;

import ro.adc.hra.base.PersonName;

public class UpdateEmployeeDetailParam {
    private String employeeCodeIs;
    private PersonName employeeName;
    private Long modificationId;

    public String getEmployeeCodeIs() {
        return employeeCodeIs;
    }

    public void setEmployeeCodeIs(final String employeeCodeIs) {
        this.employeeCodeIs = employeeCodeIs;
    }

    public PersonName getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(final PersonName employeeName) {
        this.employeeName = employeeName;
    }

    public Long getModificationId() {
        return modificationId;
    }

    public void setModificationId(final Long modificationId) {
        this.modificationId = modificationId;
    }

}
