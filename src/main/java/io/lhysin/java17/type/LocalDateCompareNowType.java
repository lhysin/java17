package io.lhysin.java17.type;

import java.time.LocalDate;
import java.util.function.Predicate;

public enum LocalDateCompareNowType {

	FUTURE((t) -> LocalDate.now().compareTo(t) < 0),
	FUTURE_OR_PRESENT((t) -> LocalDate.now().compareTo(t) < 1),
	PAST((t) -> LocalDate.now().compareTo(t) > 0),
	PAST_OR_PRESENT((t) -> LocalDate.now().compareTo(t) > -1),
	PRESENT((t) -> LocalDate.now().compareTo(t) == 0);

	private final Predicate<LocalDate> predicate;

	LocalDateCompareNowType(Predicate<LocalDate> predicate) {
		this.predicate = predicate;
	}

	public boolean test(LocalDate t) {
		return this.predicate.test(t);
	}

}
