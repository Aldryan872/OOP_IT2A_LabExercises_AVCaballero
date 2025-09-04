import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * A utility class demonstrating functional programming patterns in Java
 * 
 * @author Aldryan Venth Caballero 
 * @version 1.0
 * @since 2025
 */
public class FunctionalUtils {

    /**
     * Applies a function to each element of a list and returns a new list
     * 
     * @param <T> the input type
     * @param <R> the output type
     * @param list the input list
     * @param function the mapping function
     * @return a new list with transformed elements
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        Objects.requireNonNull(list, "List cannot be null");
        Objects.requireNonNull(function, "Function cannot be null");
        
        return list.stream()
                  .map(function)
                  .collect(Collectors.toList());
    }

    /**
     * Filters a list based on a predicate
     * 
     * @param <T> the element type
     * @param list the input list
     * @param predicate the filtering condition
     * @return a new list containing only elements that satisfy the predicate
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        Objects.requireNonNull(list, "List cannot be null");
        Objects.requireNonNull(predicate, "Predicate cannot be null");
        
        return list.stream()
                  .filter(predicate)
                  .collect(Collectors.toList());
    }

    /**
     * Reduces a list to a single value using a binary operator
     * 
     * @param <T> the element type
     * @param list the input list
     * @param identity the initial value
     * @param accumulator the reduction function
     * @return the accumulated result
     */
    public static <T> T reduce(List<T> list, T identity, BinaryOperator<T> accumulator) {
        Objects.requireNonNull(list, "List cannot be null");
        Objects.requireNonNull(accumulator, "Accumulator cannot be null");
        
        T result = identity;
        for (T element : list) {
            result = accumulator.apply(result, element);
        }
        return result;
    }

    /**
     * Composes two functions: f(g(x))
     * 
     * @param <T> the input type of g
     * @param <U> the output type of g and input type of f
     * @param <V> the output type of f
     * @param f the outer function
     * @param g the inner function
     * @return the composed function
     */
    public static <T, U, V> Function<T, V> compose(Function<U, V> f, Function<T, U> g) {
        Objects.requireNonNull(f, "Function f cannot be null");
        Objects.requireNonNull(g, "Function g cannot be null");
        
        return x -> f.apply(g.apply(x));
    }

    /**
     * Curries a two-argument function
     * 
     * @param <T> the first argument type
     * @param <U> the second argument type
     * @param <R> the return type
     * @param function the function to curry
     * @return a curried function
     */
    public static <T, U, R> Function<T, Function<U, R>> curry(BiFunction<T, U, R> function) {
        Objects.requireNonNull(function, "Function cannot be null");
        
        return t -> u -> function.apply(t, u);
    }

    /**
     * Memoizes a function to cache results
     * 
     * @param <T> the input type
     * @param <R> the output type
     * @param function the function to memoize
     * @return a memoized version of the function
     */
    public static <T, R> Function<T, R> memoize(Function<T, R> function) {
        Objects.requireNonNull(function, "Function cannot be null");
        
        Map<T, R> cache = new HashMap<>();
        return input -> cache.computeIfAbsent(input, function);
    }
}
```
