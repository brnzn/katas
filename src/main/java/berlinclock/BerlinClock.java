package berlinclock;

import java.util.function.Function;

public class BerlinClock {
    public Time parse(String time) {
        String units[] = time.split(":");

        return new Time(
                LightStateParser.parseSeconds(Integer.valueOf(units[2])),
                LightStateParser.parseFiveHoursRow(Integer.valueOf(units[0])),
                LightStateParser.parseSingleHoureRow(Integer.valueOf(units[0])),
                LightStateParser.parseFiveMinutesRow(Integer.valueOf(units[1])),
                LightStateParser.parseSingleMinuteRow(Integer.valueOf(units[1]))
        );
    }

    private static class LightStateParser {

        private static String parseSingleMinuteRow(int value) {
            return parseSingleUnitRow(value, "Y");
        }

        private static String parseSingleHoureRow(int value) {
            return parseSingleUnitRow(value, "R");
        }

        private static String parseSingleUnitRow(int value, String replaceWith) {
            int numOfLights = value % 5;
            return replace(numOfLights, "OOOO", i -> replaceWith);
        }


        private static String parseFiveHoursRow(int value) {
            int numOfLights = value / 5;
            return replace(numOfLights, "OOOO", i -> "R");
        }

        private static String parseFiveMinutesRow(int value) {
            int numOfLights = value / 5;
            return replace(numOfLights, "OOOOOOOOOOO", i -> (i+1) % 3 == 0 ? "R" : "Y");
        }

        private static String replace(int count, String initial, Function<Integer, String> replaceWith) {
            String tmp = initial;
            for(int i = 0; i< count; i++) {
                tmp = tmp.replaceFirst("O", replaceWith.apply(i));
            }
            return tmp;
        }

        private static String parseSeconds(int value) {
            return (value % 2 == 0) ? "Y" : "O";
        }
    }
}
