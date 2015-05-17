package ro.adc.hra.employee;

import java.io.Serializable;
import java.util.Objects;

import ro.adc.hra.base.RecordStatus;
import ro.adc.hra.obj.Objs;
import ro.adc.hra.obj.ValueEqEvaluator;

public class EmployeeCriteria implements Serializable {
    private static final long serialVersionUID = 1L;

    private static EmployeeCriteria ALL = new EmployeeCriteria();

    private final String employeeUuidEqCriterion;
    private final RecordStatus recordStatusEqCriterion;
    private final String employeeCodeEqCriterion;

    public static class Builder {
        private String employeeUuidEqCriterion;
        private RecordStatus recordStatusEqCriterion;
        private String employeeCodeEqCriterion;

        private Builder() {

        }

        public Builder employeeUuidEq(final String employeeUuidEqCriterion) {
            this.employeeUuidEqCriterion = employeeUuidEqCriterion;
            return this;
        }

        public Builder recordStatusEq(final RecordStatus recordStatusEqCriterion) {
            this.recordStatusEqCriterion = recordStatusEqCriterion;
            return this;
        }

        public Builder employeeCodeEq(final String employeeCodeEqCriterion) {
            this.employeeCodeEqCriterion = employeeCodeEqCriterion;
            return this;
        }

        public EmployeeCriteria build() {
            EmployeeCriteria res = new EmployeeCriteria(this);
            if (res.equals(ALL)) {
                res = ALL;
            }
            return res;
        }
    }

    public static EmployeeCriteria all() {
        return ALL;
    }

    public static Builder builder() {
        return new Builder();
    }

    private EmployeeCriteria() {
        employeeUuidEqCriterion = null;
        employeeCodeEqCriterion = null;
        recordStatusEqCriterion = null;
    }

    private EmployeeCriteria(final Builder builder) {
        employeeUuidEqCriterion = builder.employeeUuidEqCriterion;
        employeeCodeEqCriterion = builder.employeeCodeEqCriterion;
        recordStatusEqCriterion = builder.recordStatusEqCriterion;
    }

    public String getEmployeeUuidEqCriterion() {
        return employeeUuidEqCriterion;
    }

    public RecordStatus getRecordStatusEqCriterion() {
        return recordStatusEqCriterion;
    }

    public String getEmployeeCodeEqCriterion() {
        return employeeCodeEqCriterion;
    }

    @Override
    public boolean equals(final Object obj) {
        return Objs.eq(this, obj, Veq.INSTANCE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeCodeEqCriterion, employeeUuidEqCriterion, recordStatusEqCriterion);
    }

    @Override
    public String toString() {
        return Objs.toStringBuider().omitNull().add("employeeCodeEqCriterion", employeeCodeEqCriterion)
                .add("employeeUuidEqCriterion", employeeUuidEqCriterion)
                .add("recordStatusEqCriterion", recordStatusEqCriterion).toString();
    }

    private enum Veq implements ValueEqEvaluator<EmployeeCriteria> {
        INSTANCE;

        @Override
        public boolean evaluateLogicalEquality(final EmployeeCriteria anObject, final EmployeeCriteria anoterObject) {
            return Objects.equals(anObject.employeeCodeEqCriterion, anoterObject.employeeCodeEqCriterion)
                    && Objects.equals(anObject.employeeUuidEqCriterion, anoterObject.employeeUuidEqCriterion)
                    && Objects.equals(anObject.recordStatusEqCriterion, anoterObject.recordStatusEqCriterion);
        }

    }
}
