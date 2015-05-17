package ro.adc.hra.employee;

import java.io.Serializable;
import java.util.Objects;

import ro.adc.hra.base.RecordTrace;
import ro.adc.hra.obj.Objs;
import ro.adc.hra.obj.ValueEqEvaluator;

public class EmployeeRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private EmployeeDetail detail;
    private RecordTrace recordTrace;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public EmployeeDetail getDetail() {
        return detail;
    }

    public void setDetail(final EmployeeDetail employeeDetail) {
        detail = employeeDetail;
    }

    public RecordTrace getRecordTrace() {
        return recordTrace;
    }

    public void setRecordTrace(final RecordTrace versionInfo) {
        recordTrace = versionInfo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(detail, recordTrace);
    }

    @Override
    public boolean equals(final Object obj) {
        return Objs.eq(this, obj, VeqEvaluator.INSTANCE);
    }

    @Override
    public String toString() {
        return Objs.toStringBuider().add("detail", detail).add("recordTrace", recordTrace).toString();
    }

    private enum VeqEvaluator implements ValueEqEvaluator<EmployeeRecord> {
        INSTANCE;

        @Override
        public boolean evaluateLogicalEquality(final EmployeeRecord anObject, final EmployeeRecord anoterObject) {
            return Objects.equals(anObject.detail, anoterObject.detail)
                    && Objects.equals(anObject.recordTrace, anoterObject.recordTrace);
        }

    }

}
