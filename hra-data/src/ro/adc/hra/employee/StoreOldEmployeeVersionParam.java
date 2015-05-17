package ro.adc.hra.employee;

import java.util.Objects;

public class StoreOldEmployeeVersionParam {
    private final String employeeCodeIs;
    private final Long modificationId;

    public static class Builder {
        private String employeeCodeIs;
        private Long modificationId;

        private Builder() {
            super();
        }

        public Builder employeeCodeIs(final String employeeCodeIs) {
            this.employeeCodeIs = employeeCodeIs;
            return this;
        }

        public Builder modificationId(final Long modificationId) {
            this.modificationId = modificationId;
            return this;
        }

        public StoreOldEmployeeVersionParam build() {
            return new StoreOldEmployeeVersionParam(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private StoreOldEmployeeVersionParam(final Builder builder) {
        Objects.requireNonNull(builder.employeeCodeIs, "Null 'employeeCodeIs' not allowed");
        Objects.requireNonNull(builder.modificationId, "Null 'modificationId' not allowed");
        employeeCodeIs = builder.employeeCodeIs;
        modificationId = builder.modificationId;
    }

    public String getEmployeeCodeIs() {
        return employeeCodeIs;
    }

    public Long getModificationId() {
        return modificationId;
    }

}
