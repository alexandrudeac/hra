package ro.adc.hra.employee;


public class CreateEmployeeParam {
    private EmployeeDetail employeeDetail;
    private Long modificationId;

    public EmployeeDetail getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(final EmployeeDetail employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

    public Long getModificationId() {
        return modificationId;
    }

    public void setModificationId(final Long modificationId) {
        this.modificationId = modificationId;
    }

}
