package ro.adc.hra.employee;

import java.util.Objects;

public class MarkDeletedEmployeeParam {
    private final Boolean activeState;
    private final String employeeCodeIs;
    private final Long modificationId;

    public static class Builder {
        private String employeeCodeIs;
        private Long modificationId;
        private Boolean activeState;

        private Builder() {
            super();
        }

        public Builder employeeCodeIs(final String employeeCodeIs) {
            this.employeeCodeIs = employeeCodeIs;
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

        public MarkDeletedEmployeeParam build() {
            return new MarkDeletedEmployeeParam(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private MarkDeletedEmployeeParam(final Builder builder) {
        Objects.requireNonNull(builder.employeeCodeIs, "Null 'employeeCodeIs' not allowed");
        Objects.requireNonNull(builder.modificationId, "Null 'modificationId' not allowed");
        Objects.requireNonNull(builder.activeState, "Null 'activeState' not allowed");
        employeeCodeIs = builder.employeeCodeIs;
        modificationId = builder.modificationId;
        activeState = builder.activeState;
    }

    public String getEmployeeCodeIs() {
        return employeeCodeIs;
    }

    public Long getModificationId() {
        return modificationId;
    }

    public Boolean getActiveState() {
        return activeState;
    }

}
