package io.lhysin.java17;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.lhysin.java17.entity.Customer;
import io.lhysin.java17.repository.CustomerRepoitory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
public class StreamVsForTests {

    @Test
    void speedTest() {
        // data init
        List<Map<String, BigDecimal>> dataList = LongStream.range(0, Integer.MAX_VALUE)
            .boxed()
            .map(i -> {
                return Map.of(
                    "num0", BigDecimal.valueOf(i),
                    "num1", BigDecimal.valueOf(i),
                    "num2", BigDecimal.valueOf(i),
                    "num3", BigDecimal.valueOf(i),
                    "num4", BigDecimal.valueOf(i)
                    // "num5", BigDecimal.valueOf(i),
                    // "num6", BigDecimal.valueOf(i),
                    // "num7", BigDecimal.valueOf(i),
                    // "num8", BigDecimal.valueOf(i),
                    // "num9", BigDecimal.valueOf(i)

                );
            })
            .toList();


        BigDecimal num0 = BigDecimal.ZERO;
        BigDecimal num1 = BigDecimal.ZERO;
        BigDecimal num2 = BigDecimal.ZERO;
        BigDecimal num3 = BigDecimal.ZERO;
        BigDecimal num4 = BigDecimal.ZERO;
        BigDecimal num5 = BigDecimal.ZERO;
        BigDecimal num6 = BigDecimal.ZERO;
        BigDecimal num7 = BigDecimal.ZERO;
        BigDecimal num8 = BigDecimal.ZERO;
        BigDecimal num9 = BigDecimal.ZERO;

        Instant forLoopStart = Instant.now();
        for(Map<String, BigDecimal> data : dataList){
            num0 = data.get("num0").add(num0);
            num1 = data.get("num1").add(num1);
            num2 = data.get("num2").add(num2);
            num3 = data.get("num3").add(num3);
            num4 = data.get("num4").add(num4);
            // num5 = data.get("num5").add(num5);
            // num6 = data.get("num6").add(num6);
            // num7 = data.get("num7").add(num7);
            // num8 = data.get("num8").add(num8);
            // num9 = data.get("num9").add(num9);
        }
        Instant forLoopFinish = Instant.now();

        Instant forStreamStart = Instant.now();
        BigDecimal num0_stream = dataList.stream().map(map -> map.get("num0")).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal num1_stream = dataList.stream().map(map -> map.get("num1")).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal num2_stream = dataList.stream().map(map -> map.get("num2")).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal num3_stream = dataList.stream().map(map -> map.get("num3")).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal num4_stream = dataList.stream().map(map -> map.get("num4")).reduce(BigDecimal.ZERO, BigDecimal::add);
        // BigDecimal num5_stream = dataList.stream().map(map -> map.get("num5")).reduce(BigDecimal.ZERO, BigDecimal::add);
        // BigDecimal num6_stream = dataList.stream().map(map -> map.get("num6")).reduce(BigDecimal.ZERO, BigDecimal::add);
        // BigDecimal num7_stream = dataList.stream().map(map -> map.get("num7")).reduce(BigDecimal.ZERO, BigDecimal::add);
        // BigDecimal num8_stream = dataList.stream().map(map -> map.get("num8")).reduce(BigDecimal.ZERO, BigDecimal::add);
        // BigDecimal num9_stream = dataList.stream().map(map -> map.get("num9")).reduce(BigDecimal.ZERO, BigDecimal::add);
        Instant forStreamFinish = Instant.now();

        long forLoopTimeElapsed = Duration.between(forLoopStart, forLoopFinish).toMillis();
        log.debug("forLoopTimeElapsed : {}", forLoopTimeElapsed);
        long forStreamTimeElapsed = Duration.between(forStreamStart, forStreamFinish).toMillis();
        log.debug("forStreamTimeElapsed : {}", forStreamTimeElapsed);

    }

}