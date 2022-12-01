package io.lhysin.java17;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.lhysin.java17.type.BigDecimalCompareZeroType;
import io.lhysin.java17.type.LocalDateCompareNowType;

@SpringBootTest
public class ComparatorAndPredicateTests {

    @Test
    void bigDecimalCompareTest() {

        //assertFalse(BigDecimalCompareZeroType.NEGATIVE_OR_ZERO.test(null));

        assertTrue(BigDecimalCompareZeroType.NEGATIVE_OR_ZERO.test(new BigDecimal(0)));
        assertTrue(BigDecimalCompareZeroType.NEGATIVE_OR_ZERO.test(new BigDecimal(-9999)));

        assertTrue(BigDecimalCompareZeroType.POSITIVE_OR_ZERO.test(new BigDecimal(0)));
        assertTrue(BigDecimalCompareZeroType.POSITIVE_OR_ZERO.test(new BigDecimal(1233)));

        assertTrue(BigDecimalCompareZeroType.POSITIVE.test(new BigDecimal(74989)));
        assertTrue(BigDecimalCompareZeroType.NEGATIVE.test(new BigDecimal(-12311)));

        assertTrue(BigDecimalCompareZeroType.ZERO.test(new BigDecimal(0)));
    }

    @Test
    void localDateCompareTest() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        assertTrue(LocalDateCompareNowType.FUTURE.test(LocalDate.parse("2090-11-11", dateTimeFormatter)));
        assertTrue(LocalDateCompareNowType.FUTURE_OR_PRESENT.test(LocalDate.parse("2090-11-11", dateTimeFormatter)));
        assertTrue(LocalDateCompareNowType.FUTURE_OR_PRESENT.test(LocalDate.now()));
        assertTrue(LocalDateCompareNowType.PAST.test(LocalDate.parse("1999-11-11", dateTimeFormatter)));
        assertTrue(LocalDateCompareNowType.PAST_OR_PRESENT.test(LocalDate.parse("1999-11-11", dateTimeFormatter)));
        assertTrue(LocalDateCompareNowType.PAST_OR_PRESENT.test(LocalDate.now()));
        assertTrue(LocalDateCompareNowType.PRESENT.test(LocalDate.now()));

    }

}