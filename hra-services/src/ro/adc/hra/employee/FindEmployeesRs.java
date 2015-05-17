package ro.adc.hra.employee;

import java.util.List;

import ro.adc.hra.base.ServiceRs;

public class FindEmployeesRs extends ServiceRs {

    private Integer pageCount;
    private List<EmployeeRecord> employees;
    private EmployeeRecord employee;

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(final Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<EmployeeRecord> getEmployees() {
        return employees;
    }

    public void setEmployees(final List<EmployeeRecord> employees) {
        this.employees = employees;
    }

    public EmployeeRecord getEmployee() {
        return employee;
    }

    public void setEmployee(final EmployeeRecord employee) {
        this.employee = employee;
    }

}
