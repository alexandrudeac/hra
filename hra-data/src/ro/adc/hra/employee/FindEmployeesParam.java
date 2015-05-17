package ro.adc.hra.employee;

import ro.adc.hra.base.PaginationCriterion;

public class FindEmployeesParam {
    private EmployeeCriteria criteria;
    private PaginationCriterion paginationCriterion;

    public EmployeeCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(final EmployeeCriteria criteria) {
        this.criteria = criteria;
    }

    public PaginationCriterion getPaginationCriterion() {
        return paginationCriterion;
    }

    public void setPaginationCriterion(final PaginationCriterion paginationCriterion) {
        this.paginationCriterion = paginationCriterion;
    }

}
