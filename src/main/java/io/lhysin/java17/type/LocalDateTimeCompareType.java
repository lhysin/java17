package io.lhysin.java17.type;

import java.time.LocalDateTime;
import java.util.function.BiPredicate;

public enum LocalDateTimeCompareType {

    AFTER((t, u) -> t.compareTo(u) > 0),
    AFTER_OR_EQUAL((t, u) -> t.compareTo(u) >= 0),
    EQUAL((t, u) -> t.compareTo(u) == 0),
    BEFORE_OR_EQUAL((t, u) -> t.compareTo(u) <= 0),
    BEFORE((t, u) -> t.compareTo(u) < 0);

    private final BiPredicate<LocalDateTime, LocalDateTime> biPredicate;

    LocalDateTimeCompareType(BiPredicate<LocalDateTime, LocalDateTime> biPredicate) {
        this.biPredicate = biPredicate;
    }

    public boolean compare(LocalDateTime t, LocalDateTime u) {
        return this.biPredicate.test(t, u);
    }

}
