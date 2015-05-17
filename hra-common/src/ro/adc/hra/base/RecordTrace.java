package ro.adc.hra.base;

import java.io.Serializable;
import java.util.Objects;

import ro.adc.hra.obj.Objs;
import ro.adc.hra.obj.ValueEqEvaluator;

public class RecordTrace implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer verno;
    private RecordStatus status;
    private Modification since;
    private Modification until;

    public static class Builder {
        private Integer verno;
        private RecordStatus status;
        private Modification since;
        private Modification until;

        private Builder() {
        }

        public Builder verno(final Integer verno) {
            this.verno = verno;
            return this;
        }

        public Builder status(final RecordStatus status) {
            this.status = status;
            return this;
        }

        public Builder since(final Modification since) {
            this.since = since;
            return this;
        }

        public Builder until(final Modification until) {
            this.until = until;
            return this;
        }

        public RecordTrace build() {
            return new RecordTrace(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public RecordTrace() {

    }

    private RecordTrace(final Builder builder) {
        verno = builder.verno;
        status = builder.status;
        since = builder.since;
        until = builder.until;
    }

    public Integer getVerno() {
        return verno;
    }

    public void setVerno(final Integer verno) {
        this.verno = verno;
    }

    public Modification getSince() {
        return since;
    }

    public void setSince(final Modification since) {
        this.since = since;
    }

    public Modification getUntil() {
        return until;
    }

    public void setUntil(final Modification until) {
        this.until = until;
    }

    public RecordStatus getStatus() {
        return status;
    }

    public void setStatus(final RecordStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(final Object other) {
        return Objs.eq(this, other, Veq.INSTANCE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verno, status, since, until);
    }

    @Override
    public String toString() {
        return Objs.toStringBuider().add("verno", verno).add("status", status).add("since", since).add("until", until)
                .toString();
    }

    private enum Veq implements ValueEqEvaluator<RecordTrace> {
        INSTANCE;

        @Override
        public boolean evaluateLogicalEquality(final RecordTrace anObject, final RecordTrace anoterObject) {
            return Objects.equals(anObject.verno, anoterObject.verno)
                    && Objects.equals(anObject.status, anoterObject.status)
                    && Objects.equals(anObject.since, anoterObject.since)
                    && Objects.equals(anObject.until, anoterObject.until);
        }

    }
}
