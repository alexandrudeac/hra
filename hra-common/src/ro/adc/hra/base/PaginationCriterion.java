package ro.adc.hra.base;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Objects;

import javax.annotation.Nonnull;

import ro.adc.hra.obj.Objs;
import ro.adc.hra.obj.ValueEqEvaluator;

import com.google.common.base.Preconditions;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners;

public class PaginationCriterion implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Interner<PaginationCriterion> INTERNER = Interners.newWeakInterner();

    @Nonnull
    private final Integer pageNumber;
    @Nonnull
    private final Integer pageSize;

    public static class Builder {
        private Integer pageNumber;
        private Integer pageSize;

        public Builder pageNumber(final Integer pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public Builder pageSize(final Integer pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public PaginationCriterion build() {
            return INTERNER.intern(new PaginationCriterion(this));
        }

    }

    private PaginationCriterion(final Builder builder) {
        Objects.requireNonNull(builder.pageNumber, "Page number cannot be null");
        Objects.requireNonNull(builder.pageSize, "Page size cannot be null");
        Preconditions.checkArgument(builder.pageNumber >= 0, "Page number cannot be negative");
        Preconditions.checkArgument(builder.pageSize > 0, "Page size must be at least 1");
        pageNumber = builder.pageNumber;
        pageSize = builder.pageSize;
    }

    @Nonnull
    public Integer getPageNumber() {
        return pageNumber;
    }

    @Nonnull
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public boolean equals(final Object obj) {
        return Objs.eq(this, obj, Veq.INSTANCE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pageNumber, pageSize);
    }

    @Override
    public String toString() {
        return Objs.toStringBuider().add("pageNumber", pageNumber).add("pageSize", pageSize).toString();
    }

    private enum Veq implements ValueEqEvaluator<PaginationCriterion> {
        INSTANCE;

        @Override
        public boolean evaluateLogicalEquality(final PaginationCriterion anObject,
                final PaginationCriterion anoterObject) {
            return Objects.equals(anObject.pageNumber, anoterObject.pageNumber)
                    && Objects.equals(anObject.pageSize, anoterObject.pageSize);
        }

    }

    private Object readResolve() throws ObjectStreamException {
        return INTERNER.intern(this);
    }
}
