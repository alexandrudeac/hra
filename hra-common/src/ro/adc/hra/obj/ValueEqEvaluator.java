package ro.adc.hra.obj;

import javax.annotation.Nonnull;

public interface ValueEqEvaluator<T> {
	boolean evaluateLogicalEquality(@Nonnull T anObject,@Nonnull T anoterObject);
}
