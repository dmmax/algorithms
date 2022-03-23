package me.dmmax.algorithms.util;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

public class StopwatchUtil {

    public static <T> T trackExecutionTime(Supplier<T> supplier, String logMessageTemplate, Object... messageArgs) {
        var message = String.format(logMessageTemplate, messageArgs);
        var startTime = Instant.now();
        System.out.println(message + "...");
        var result = supplier.get();
        var endTime = Instant.now();
        System.out.println(message + " was COMPLETED for " + Duration.between(startTime, endTime));
        return result;
    }
}
