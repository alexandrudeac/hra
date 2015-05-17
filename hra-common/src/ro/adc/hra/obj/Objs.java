package ro.adc.hra.obj;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;


public class Objs {
	public static <T> boolean eq(@Nonnull final T reference,
			@Nullable final Object anotherObject,
			@Nonnull final ValueEqEvaluator<? super T> valueEqEvaluator) {
		boolean eq;
		if (anotherObject == null) {
			eq = false;
		} else if (reference.getClass() == anotherObject.getClass()) {
			@SuppressWarnings("unchecked")
            final
			T anothoerT = (T) anotherObject;
			eq = valueEqEvaluator.evaluateLogicalEquality(reference, anothoerT);
		} else {
			eq = false;
		}
		return eq;
	}

	public static ToStringBuider toStringBuider() {
		return new GuavaToStringBuilder();
	}

	private static class GuavaToStringBuilder implements ToStringBuider {
		private final ToStringHelper helper = MoreObjects.toStringHelper("");

		@Override
		public ToStringBuider add(final String property, final Object value) {
			helper.add(property, value);
			return this;
		}

		@Override
		public ToStringBuider add(final Object value) {
			helper.addValue(value);
			return this;
		}

		@Override
		public ToStringBuider omitNull() {
			helper.omitNullValues();
			return this;
		}

		@Override
		public String toString() {
			return helper.toString();
		}

	}
}
