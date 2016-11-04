package romannumerals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsTest {
    private RomanNumeric romanNumerals = new RomanNumeric();

    @Test
    public void tens() {
        assertEquals("I", romanNumerals.arabicToRoman(1));
        assertEquals("II", romanNumerals.arabicToRoman(2));
        assertEquals("III", romanNumerals.arabicToRoman(3));
        assertEquals("IV", romanNumerals.arabicToRoman(4));
        assertEquals("V", romanNumerals.arabicToRoman(5));
        assertEquals("VI", romanNumerals.arabicToRoman(6));
        assertEquals("IX", romanNumerals.arabicToRoman(9));
        assertEquals("X", romanNumerals.arabicToRoman(10));
        assertEquals("XI", romanNumerals.arabicToRoman(11));
        assertEquals("XIV", romanNumerals.arabicToRoman(14));
        assertEquals("XIX", romanNumerals.arabicToRoman(19));
        assertEquals("XXIV", romanNumerals.arabicToRoman(24));
    }

    @Test
    public void fiftes() {
        assertEquals("L", romanNumerals.arabicToRoman(50));
        assertEquals("XL", romanNumerals.arabicToRoman(40));
        assertEquals("LXX", romanNumerals.arabicToRoman(70));
    }
//
//    @Test
//    public void hundreds() {
//        assertEquals("C", romanNumerals.arabicToRoman(100));
//        assertEquals("XC", romanNumerals.arabicToRoman(90));
//        assertEquals("CCCLXIX", romanNumerals.arabicToRoman(369));
//    }

}
