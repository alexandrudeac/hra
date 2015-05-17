package ro.adc.hra.employee;

import java.io.Serializable;
import java.util.Objects;

import ro.adc.hra.obj.Objs;
import ro.adc.hra.obj.ValueEqEvaluator;

public class EmployeeDetail implements Serializable {
    private static final long serialVersionUID = 1L;
    private Employee basic;
    private Boolean active = Boolean.FALSE;


    public Employee getBasic() {
        return basic;
    }

    public void setBasic(final Employee employee) {
        this.basic = employee;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        return Objects.hash(basic, active);
    }

    @Override
    public boolean equals(final Object obj) {
        return Objs.eq(this, obj, VeqEvaluator.INSTANCE);
    }

    @Override
    public String toString() {
        return Objs.toStringBuider().add("employee", basic).add("active", active).toString();
    }

    private enum VeqEvaluator implements ValueEqEvaluator<EmployeeDetail> {
        INSTANCE;

        @Override
        public boolean evaluateLogicalEquality(final EmployeeDetail anObject, final EmployeeDetail anoterObject) {
            return Objects.equals(anObject.basic, anoterObject.basic)
                    && Objects.equals(anObject.active, anoterObject.active);
        }

    }

}
