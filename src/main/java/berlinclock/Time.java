package berlinclock;

public class Time {
    final String seconds;
    final String fiveHoursState;
    final String singleHourState;
    final String fiveMinutesState;
    final String singleMinuteState;

    Time(String seconds, String fiveHoursState, String singleHourState, String fiveMinutesState, String singleMinuteState) {
        this.seconds = seconds;
        this.fiveHoursState = fiveHoursState;
        this.fiveMinutesState = fiveMinutesState;
        this.singleHourState = singleHourState;
        this.singleMinuteState = singleMinuteState;
    }

}
