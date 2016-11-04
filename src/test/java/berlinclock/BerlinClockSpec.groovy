package berlinclock

import spock.lang.Specification
import spock.lang.Unroll

/*
Seconds:
The top lamp is a pump which is blinking on/off every two seconds.
Hours:
In the upper line of red lamps every lamp represents 5 hours.
In the lower line of red lamps every lamp represents 1 hour.
So if in the first line 2 lamps are lit and in the second line 3 lamps its 5+5+3=13h or 1 p.m.

Minutes:
In the third line with tall lamps every lamp represents 5 minutes. There are 11 lamps, the 3rd, 6th, and 9th are red indicating the first quarter, half, and the last quarter of the hour.
In the last line with yellow lamps every lamp represents 1 minute.
*/
class BerlinClockSpec extends Specification {
    BerlinClock clock;

    public setup() {
        clock = new BerlinClock();
    }

    @Unroll
    def "illuminated on even seconds and off on odd seconds" () {
        given:
            def result = clock.parse(time)
        expect:
            expect == result.seconds
        where:
            time | expect
            '00:00:00' | 'Y'
            '00:00:01' | 'O'
    }

    @Unroll
    def "red lamp is illuminated for every 5 hours in the upper line"() {
        given:
            def result = clock.parse(time)
        expect:
            expect == result.fiveHoursState
        where:
            time | expect
            '00:00:00' | 'OOOO'
            '05:00:00' | 'ROOO'
            '11:00:00' | 'RROO'
            '15:00:00' | 'RRRO'
            '20:00:00' | 'RRRR'
    }

    @Unroll
    def "red lamp is illuminated for every hour in the bottom line"() {
        given:
            def result = clock.parse(time)
        expect:
            expect == result.singleHourState
        where:
            time | expect
            '00:00:00' | 'OOOO'
            '01:00:00' | 'ROOO'
            '02:00:00' | 'RROO'
            '03:00:00' | 'RRRO'
            '04:00:00' | 'RRRR'
            '05:00:00' | 'OOOO'
    }

    @Unroll
    def "yello lamp is illuminated for every 5 minutes, red every 3 lights"() {
        given:
            def result = clock.parse(time)
        expect:
            expect == result.fiveMinutesState
        where:
            time | expect
            '00:00:00' | 'OOOOOOOOOOO'
            '00:05:00' | 'YOOOOOOOOOO'
            '00:11:00' | 'YYOOOOOOOOO'
            '00:15:00' | 'YYROOOOOOOO'
            '00:20:00' | 'YYRYOOOOOOO'
            '00:25:00' | 'YYRYYOOOOOO'
            '00:30:00' | 'YYRYYROOOOO'
            '00:35:00' | 'YYRYYRYOOOO'
            '00:40:00' | 'YYRYYRYYOOO'
            '00:45:00' | 'YYRYYRYYROO'
            '00:50:00' | 'YYRYYRYYRYO'
            '00:59:00' | 'YYRYYRYYRYY'
    }

    @Unroll
    def "yellow lamp every 1 minute"() {
        given:
            def result = clock.parse(time)
        expect:
            expect == result.singleMinuteState
        where:
            time | expect
            '00:00:00' | 'OOOO'
            '00:01:00' | 'YOOO'
            '00:02:00' | 'YYOO'
            '00:03:00' | 'YYYO'
            '00:04:00' | 'YYYY'
            '00:05:00' | 'OOOO'
    }

}
