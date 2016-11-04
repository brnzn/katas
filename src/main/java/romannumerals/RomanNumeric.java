package romannumerals;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The starting point of the data structure is the biggest number supported.
 *
 * For all supported values
 *      while remain >= current value from table then
 *          append the symbol
 *          deduct the value from remain
 *      end while
 * end for
 *
 *
 */
public class RomanNumeric {

    Map<Integer, String> table = new LinkedHashMap() {{
        put(50, "L");
        put(40, "XL");
        put(10, "X");
        put(9, "IX");
        put(5, "V");
        put(4,"IV");
        put(1,"I");
    }};

    public String arabicToRoman(int number) {
        StringBuilder sb = new StringBuilder();
        int remain = number;

        for(Map.Entry<Integer, String> entry : table.entrySet()) {
            while(remain >= entry.getKey()) {
                remain = append(remain, entry.getKey(), entry.getValue(), sb);
            }
        }

//        if(remain >= 10) {
//            remain = append(remain, 10, "X", sb);
//        }
//
//        if(remain >= 9) {
//            remain = append(remain, 9, "IX", sb);
//            //return "IX";
//        }
//
//        if(remain >= 5) {
//            remain = append(remain, 5, "V", sb);
////            sb.append("V");
////            remain -= 5;
//        }
//
//        if(remain >= 4) {
//            remain = append(remain, 4, "IV", sb);
//        }
//
//        while(remain > 0) {
//            remain = append(remain, 1, "I", sb);
////            sb.append("I");
////            remain--;
//        }

        return sb.toString();
//        StringBuilder sb = new StringBuilder();
//
//        int remain = number;
//
//        for(int i=0; i < VALUES.length; i++) {
//            int v = VALUES[i];
//            while(remain >= v) {
//                remain = appendIfNeeded(remain, v, SYMBOLS[i], sb);
//            }
//        }
//
//        return sb.toString();
    }

    private int append(int remain, int number, String letter, StringBuilder builder) {
        builder.append(letter);
        return remain - number;
    }
//    private int appendIfNeeded(int remain, int number, String roman, StringBuilder builder) {
//        if(remain >= number) {
//            builder.append(roman);
//            return remain - number;
//        }
//
//        return remain;
//    }
}
