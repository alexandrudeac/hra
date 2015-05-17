package ro.adc.hra.absence;

import ro.adc.hra.base.LocalDatePeriod;
import ro.adc.hra.employee.EmployeeDetail;

public class EmployeeAbsenceParam {
    private AbsenceParamSheet sheet;
    private EmployeeDetail employee;
    private LocalDatePeriod validity;

    public AbsenceParamSheet getSheet() {
        return sheet;
    }

    public void setSheet(final AbsenceParamSheet sheet) {
        this.sheet = sheet;
    }

    public EmployeeDetail getEmployee() {
        return employee;
    }

    public void setEmployee(final EmployeeDetail employee) {
        this.employee = employee;
    }

    public LocalDatePeriod getValidity() {
        return validity;
    }

    public void setValidity(final LocalDatePeriod validity) {
        this.validity = validity;
    }

}
