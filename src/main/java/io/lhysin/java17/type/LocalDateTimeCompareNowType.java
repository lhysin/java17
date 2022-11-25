package io.lhysin.java17.type;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public enum LocalDateTimeCompareNowType {

    FUTURE((t) -> LocalDateTime.now().compareTo(t) < 0),
    PAST((t) -> LocalDateTime.now().compareTo(t) > 0);

    private final Predicate<LocalDateTime> predicate;

    LocalDateTimeCompareNowType(Predicate<LocalDateTime> predicate) {
        this.predicate = predicate;
    }

    public boolean test(LocalDateTime t) {
        return this.predicate.test(t);
    }

}
