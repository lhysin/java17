package io.lhysin.java17.type;

import java.math.BigDecimal;
import java.util.function.BiPredicate;

public enum BigDecimalCompareType {

	GRATER_THAN((t, u) -> t.compareTo(u) > 0),
	GRATER_THAN_OR_EQUAL((t, u) -> t.compareTo(u) >= 0),
	EQUAL((t, u) -> t.compareTo(u) == 0),
	LESS_THAN_OR_EQUAL((t, u) -> t.compareTo(u) <= 0),
	LESS_THAN((t, u) -> t.compareTo(u) < 0);

	private final BiPredicate<BigDecimal, BigDecimal> biPredicate;

	BigDecimalCompareType(BiPredicate<BigDecimal, BigDecimal> biPredicate) {
		this.biPredicate = biPredicate;
	}

	public boolean compare(BigDecimal t, BigDecimal u) {
		return this.biPredicate.test(t, u);
	}

}
