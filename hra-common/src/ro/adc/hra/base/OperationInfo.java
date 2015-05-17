package ro.adc.hra.base;

import java.util.Objects;

import org.joda.time.LocalDateTime;

import ro.adc.hra.obj.Objs;
import ro.adc.hra.obj.ValueEqEvaluator;

public class OperationInfo {
    private String operator;
    private LocalDateTime timestamp;

    public OperationInfo() {
    }

    public OperationInfo(final String operator, final LocalDateTime timestamp) {
        this.operator = operator;
        this.timestamp = timestamp;
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
        return Objects.hash(timestamp, operator);
    }

    @Override
    public String toString() {
        return Objs.toStringBuider().add("operator", operator).add("timestamp", timestamp).toString();
    }

    private enum Veq implements ValueEqEvaluator<OperationInfo> {
        INSTANCE;

        @Override
        public boolean evaluateLogicalEquality(final OperationInfo anObject, final OperationInfo anoterObject) {
            return Objects.equals(anObject.operator, anoterObject.operator)
                    && Objects.equals(anObject.timestamp, anoterObject.timestamp);
        }

    }
}
