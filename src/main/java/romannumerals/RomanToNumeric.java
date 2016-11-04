package romannumerals;

import java.util.Hashtable;
import java.util.Map;

/**
 * Iterate over letters
 * If letter value is >= than sum
 *      add letter value to sum
 * else subtract letter value from sum
 *
 */
public class RomanToNumeric {
    Map<Character, Integer> table = new Hashtable() {{
        put('I', 1);
        put('V', 5);
//        put('X', 10);
    }};
//
//    public int convert(String roman) {
//        int size = roman.toCharArray().length;
//
//        int num = 0;
//        for(int i = size-1; i >=0; i--) {
//            int value = table.get(roman.charAt(i));
//
//            if(value >= num)
//                num += value;
//            else
//                num -= value;
//        }
//
//        return num;
//    }

    public int convert(String roman) {
        int size = roman.toCharArray().length;

        int num = 0;
        for(int i =size-1; i>=0;i--) {
            int value = table.get(roman.charAt(i));

//
//            if('I' == roman.charAt(i)) {
//                value = 1;
//            } else if('V' == roman.charAt(i)) {
//                value = 5;
//            }

            if(value < num) {
                num -=value;
            } else {
                num +=value;
            }
        }

        return num;
    }

}
