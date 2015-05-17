package ro.adc.hra.employee;

import java.io.Serializable;
import java.util.Objects;

import ro.adc.hra.obj.Objs;
import ro.adc.hra.obj.ValueEqEvaluator;

public class UpdateEmployeeActiveStateParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Boolean activeState;
    private final EmployeeCriteria criteria;
    private final Long modificationId;

    public static class Builder {
        private EmployeeCriteria criteria;
        private Long modificationId;
        private Boolean activeState;

        private Builder() {
            super();
        }

        public Builder criteria(final EmployeeCriteria criteria) {
            this.criteria = criteria;
            return this;
        }

        public Builder activeState(final Boolean activeState) {
            this.activeState = activeState;
            return this;
        }

        public Builder modificationId(final Long modificationId) {
            this.modificationId = modificationId;
            return this;
        }

        public UpdateEmployeeActiveStateParam build() {
            return new UpdateEmployeeActiveStateParam(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private UpdateEmployeeActiveStateParam(final Builder builder) {
        Objects.requireNonNull(builder.criteria, "Null 'criteria' not allowed");
        Objects.requireNonNull(builder.modificationId, "Null 'modificationId' not allowed");
        Objects.requireNonNull(builder.activeState, "Null 'activeState' not allowed");
        criteria = builder.criteria;
        modificationId = builder.modificationId;
        activeState = builder.activeState;
    }

    public EmployeeCriteria getCriteria() {
        return criteria;
    }

    public Long getModificationId() {
        return modificationId;
    }

    public Boolean getActiveState() {
        return activeState;
    }

    @Override
    public boolean equals(final Object obj) {
        return Objs.eq(this, obj, Veq.INSTANCE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(criteria, modificationId, activeState);
    }

    @Override
    public String toString() {
        return Objs.toStringBuider().add("criteria", criteria)
                .add("activeState", activeState)
                .add("modificationId", modificationId)
                .toString();
    }

    private enum Veq implements ValueEqEvaluator<UpdateEmployeeActiveStateParam> {
        INSTANCE;

        @Override
        public boolean evaluateLogicalEquality(final UpdateEmployeeActiveStateParam anObject,
                final UpdateEmployeeActiveStateParam anoterObject) {
           return Objects.equals(anObject.criteria, anObject.criteria)
                   && Objects.equals(anObject.modificationId, anObject.modificationId)
                   && Objects.equals(anObject.activeState, anObject.activeState);
        }

    }

}
