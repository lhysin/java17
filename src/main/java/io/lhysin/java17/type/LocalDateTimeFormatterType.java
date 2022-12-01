package io.lhysin.java17.type;

import static java.time.temporal.ChronoField.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.SignStyle;
import java.util.Optional;

public enum LocalDateTimeFormatterType {

    YYYY_MM_DD_DELIMITER_DOT(new DateTimeFormatterBuilder()
        .appendValue(YEAR, 4, 10, SignStyle.EXCEEDS_PAD)
        .appendLiteral('.')
        .appendValue(MONTH_OF_YEAR, 2)
        .appendLiteral('.')
        .appendValue(DAY_OF_MONTH, 2)
        .toFormatter()
    );

    private final DateTimeFormatter dateTimeFormatter;

    LocalDateTimeFormatterType(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    public Optional<String> format(LocalDateTime localDateTime) {
        return Optional.ofNullable(localDateTime)
            .map(dateTimeFormatter::format);
    }

}
