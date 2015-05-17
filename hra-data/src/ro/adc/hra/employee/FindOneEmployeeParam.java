package ro.adc.hra.employee;


public class FindOneEmployeeParam {
    private EmployeeCriteria criteria;

    public EmployeeCriteria getCriteria() {
        return criteria;
    }

    public void setCriteria(final EmployeeCriteria criteria) {
        this.criteria = criteria;
    }

}
