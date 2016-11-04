package fizzbuzz;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FizzBuzz {
    private List<Matcher> matchers = Arrays.asList(
            new Matcher(n -> n % 3 == 0 , n -> "fizz"),
            new Matcher(n -> n % 5 == 0 , n -> "buzz"),
            new Matcher(n -> n % 3 > 0 && n % 5 > 0 , String::valueOf));

    public String translate(Integer value) {
        return matchers.stream().filter( m -> m.test(value)).
                map(function -> function.apply(value)).
                collect(Collectors.joining());
    }

    private class Matcher {
        private Predicate<Integer> predicate;
        private Function<Integer, String> transformer;

        Matcher(Predicate<Integer> predicate, Function<Integer, String> transformer) {
            this.predicate = predicate;
            this.transformer = transformer;
        }

        String apply(Integer value) {
            return transformer.apply(value);
        }

        boolean test(Integer integer) {
            return predicate.test(integer);
        }
    }
}
