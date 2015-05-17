package ro.adc.hra.timetable;

import java.io.Serializable;
import java.util.Objects;

import org.joda.time.Period;

import ro.adc.hra.employee.EmployeeDetail;
import ro.adc.hra.obj.Objs;
import ro.adc.hra.obj.ValueEqEvaluator;

public class EmployeeTimetable implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private EmployeeDetail employee;
    private Timetable timetable;
    private Period period;

    public EmployeeDetail getEmployee() {
        return employee;
    }

    public void setEmployee(final EmployeeDetail employee) {
        this.employee = employee;
    }

    public Timetable getTimetable() {
        return timetable;
    }

    public void setTimetable(final Timetable timetable) {
        this.timetable = timetable;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(final Period period) {
        this.period = period;
    }

    @Override
    public boolean equals(final Object obj) {
        return Objs.eq(this, obj, VeqEvaluator.INSTANCE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, timetable, period);
    }

    @Override
    public String toString() {
        return Objs.toStringBuider().add("id", id).add("employee", employee).add("timetable", timetable)
                .add("period", period).toString();
    }

    private enum VeqEvaluator implements ValueEqEvaluator<EmployeeTimetable> {
        INSTANCE;

        @Override
        public boolean evaluateLogicalEquality(final EmployeeTimetable anObject, final EmployeeTimetable anoterObject) {
            return Objects.equals(anObject.id, anoterObject.id) && Objects.equals(anObject.employee, anoterObject.timetable)
                    && Objects.equals(anObject.period, anoterObject.period);
        }

    }
}
