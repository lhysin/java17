package io.lhysin.java17.type;

import java.time.LocalDate;
import java.util.function.BiPredicate;

public enum LocalDateCompareType {

	AFTER((t, u) -> t.compareTo(u) > 0),
	AFTER_OR_EQUAL((t, u) -> t.compareTo(u) >= 0),
	EQUAL((t, u) -> t.compareTo(u) == 0),
	BEFORE_OR_EQUAL((t, u) -> t.compareTo(u) <= 0),
	BEFORE((t, u) -> t.compareTo(u) < 0);

	private final BiPredicate<LocalDate, LocalDate> biPredicate;

	LocalDateCompareType(BiPredicate<LocalDate, LocalDate> biPredicate) {
		this.biPredicate = biPredicate;
	}

	public boolean compare(LocalDate t, LocalDate u) {
		return this.biPredicate.test(t, u);
	}

}
