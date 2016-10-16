package fizzbuzz;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*
“fizz” if the number is dividable by 3
“buzz” if the number is dividable by 5
“fizzbuzz” if the number is dividable by 15
the same number if no other requirement is fulfilled
 */
public class FizzBuzzTest {
    FizzBuzz fizzBuzz;

    @Before
    public void setup() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void fizzIfNumberDividBy3() {
        assertEquals("fizz", fizzBuzz.translate(3));
    }

    @Test
    public void buzzIfNumberDividBy5() {
        assertEquals("buzz", fizzBuzz.translate(5));
    }

    @Test
    public void fizzbuzzIfNumberDividBy15() {
        assertEquals("fizzbuzz", fizzBuzz.translate(15));
    }

    @Test
    public void numberToStringIfNotDividedBy3or5() {
        Arrays.asList(1, 2, 4, 7, 8, 11).forEach( n -> assertEquals(String.valueOf(n), fizzBuzz.translate(n)));
    }

}
