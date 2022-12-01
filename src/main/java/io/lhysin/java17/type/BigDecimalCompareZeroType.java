package io.lhysin.java17.type;

import java.math.BigDecimal;
import java.util.function.Predicate;

public enum BigDecimalCompareZeroType {

	POSITIVE((t) -> BigDecimal.ZERO.compareTo(t) > 0),
	NEGATIVE((t) -> BigDecimal.ZERO.compareTo(t) < 0),
	POSITIVE_OR_ZERO((t) -> BigDecimal.ZERO.compareTo(t) > -1),
	NEGATIVE_OR_ZERO((t) -> BigDecimal.ZERO.compareTo(t) < 1),
	ZERO((t) -> BigDecimal.ZERO.compareTo(t) == 0);

	private final Predicate<BigDecimal> predicate;

	BigDecimalCompareZeroType(Predicate<BigDecimal> predicate) {
		this.predicate = predicate;
	}

	public boolean test(BigDecimal t) {
		return this.predicate.test(t);
	}

}
