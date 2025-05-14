// Parallel Stream Usage
// Use parallelStream() to process a large dataset and compare time taken with normal stream.

import java.util.*;
import java.util.stream.*;
import java.time.Duration;
import java.time.Instant;

public class ParallelStreamUsage {

    public static void main(String[] args) {
        // Generate a large list of integers (e.g., 10 million numbers)
        List<Integer> numbers = IntStream.rangeClosed(1, 10_000_000)
                                         .boxed()
                                         .collect(Collectors.toList());

        // Measure time taken with normal stream
        Instant startSequential = Instant.now();
        long sequentialSum = numbers.stream()
                                    .mapToLong(i -> i * 2)
                                    .sum();
        Instant endSequential = Instant.now();

        // Measure time taken with parallel stream
        Instant startParallel = Instant.now();
        long parallelSum = numbers.parallelStream()
                                  .mapToLong(i -> i * 2)
                                  .sum();
        Instant endParallel = Instant.now();

        // Output results
        System.out.println("Sequential Stream Sum: " + sequentialSum);
        System.out.println("Time taken (Sequential): " + Duration.between(startSequential, endSequential).toMillis() + " ms");

        System.out.println("Parallel Stream Sum: " + parallelSum);
        System.out.println("Time taken (Parallel): " + Duration.between(startParallel, endParallel).toMillis() + " ms");
    }
}
