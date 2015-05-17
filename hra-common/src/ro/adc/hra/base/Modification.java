package ro.adc.hra.base;

import java.io.Serializable;
import java.util.Objects;

import org.joda.time.LocalDateTime;

import ro.adc.hra.obj.Objs;
import ro.adc.hra.obj.ValueEqEvaluator;

public class Modification implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String operator;
    private LocalDateTime timestamp;

    public static class Builder {
        private Long id;
        private String operator;
        private LocalDateTime timestamp;

        private Builder() {
        }

        public Builder id(final Long id) {
            this.id = id;
            return this;
        }

        public Builder operator(final String operator) {
            this.operator = operator;
            return this;
        }

        public Builder timestamp(final LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Modification build() {
            return new Modification(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public Modification() {

    }

    private Modification(final Builder builder) {
        id = builder.id;
        operator = builder.operator;
        timestamp = builder.timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(final String operator) {
        this.operator = operator;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(final Object other) {
        return Objs.eq(this, other, Veq.INSTANCE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return Objs.toStringBuider().add("id", id).add("operator", operator).add("timestamp", timestamp).toString();
    }

    private enum Veq implements ValueEqEvaluator<Modification> {
        INSTANCE;

        @Override
        public boolean evaluateLogicalEquality(final Modification anObject, final Modification anoterObject) {
            return Objects.equals(anObject.id, anoterObject.id)
                    && Objects.equals(anObject.operator, anoterObject.operator)
                    && Objects.equals(anObject.timestamp, anoterObject.timestamp);
        }

    }
}
