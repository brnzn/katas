package romannumerals;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by orenberenson on 28/10/2016.
 */
public class RomanToNumericTest {
    private RomanToNumeric converter = new RomanToNumeric();

    @Test
    public void one() {
        assertEquals(1, converter.convert("I"));
        assertEquals(2, converter.convert("II"));
        assertEquals(4, converter.convert("IV"));
        assertEquals(5, converter.convert("V"));
    }

    @Test
    public void ten() {
//        assertEquals(10, converter.convert("X"));
//        assertEquals(9, converter.convert("IX"));
    }

}