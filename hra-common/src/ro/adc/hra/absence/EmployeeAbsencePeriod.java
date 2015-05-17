package ro.adc.hra.absence;

import ro.adc.hra.base.LocalDatePeriod;
import ro.adc.hra.employee.EmployeeDetail;

public class EmployeeAbsencePeriod {
    private LocalDatePeriod period;

    private AbsenceType absenceType;

    private EmployeeDetail employee;

    private Boolean allDay;

    private Integer Integer;

    public LocalDatePeriod getPeriod() {
        return period;
    }

    public void setPeriod(final LocalDatePeriod period) {
        this.period = period;
    }

    public AbsenceType getAbsenceType() {
        return absenceType;
    }

    public void setAbsenceType(final AbsenceType absenceType) {
        this.absenceType = absenceType;
    }

    public EmployeeDetail getEmployee() {
        return employee;
    }

    public void setEmployee(final EmployeeDetail employee) {
        this.employee = employee;
    }

    public Boolean getAllDay() {
        return allDay;
    }

    public void setAllDay(final Boolean allDay) {
        this.allDay = allDay;
    }

    public Integer getInteger() {
        return Integer;
    }

    public void setInteger(final Integer Integer) {
        this.Integer = Integer;
    }

}
