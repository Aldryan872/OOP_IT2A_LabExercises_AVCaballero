import java.util.Arrays;
import java.util.stream.IntStream;

public class FunctionalExample {
    public static void main(String[] args) {
        int[] numbers = IntStream.range(1, 101).toArray();

        // functional style using streams
        int sumEven = Arrays.stream(numbers)
                        .filter(n -> n % 2 == 0) // keep even numbers
                        .map(n -> n * n)         // square them
                        .sum();

        int sumOdd = Arrays.stream(numbers)
                        .filter(n -> n % 2 == 1) // keep odd numbers
                        .map(n -> n * n)         // square them
                        .sum();

        System.out.println("Sum of squares of even numbers = " + sumEven);
        System.out.println("Sum of squares of odd numbers = " + sumOdd);
    }
}
