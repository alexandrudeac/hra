package ro.adc.hra.employee;

import ro.adc.hra.base.PaginationCriterion;
import ro.adc.hra.base.ServiceRq;

public class FindEmployeesRq extends ServiceRq {
    private static final long serialVersionUID = 1L;

    private Boolean expectsOne = Boolean.FALSE;
    private PaginationCriterion pagination;
    private String employeeCodeIs;

    public Boolean getExpectsOne() {
        return expectsOne;
    }

    public void setExpectsOne(final Boolean expectsOne) {
        this.expectsOne = expectsOne;
    }

    public PaginationCriterion getPagination() {
        return pagination;
    }

    public void setPagination(final PaginationCriterion paging) {
        this.pagination = paging;
    }

    public String getEmployeeCodeIs() {
        return employeeCodeIs;
    }

    public void setEmployeeCodeIs(final String employeeCodeIs) {
        this.employeeCodeIs = employeeCodeIs;
    }

}
