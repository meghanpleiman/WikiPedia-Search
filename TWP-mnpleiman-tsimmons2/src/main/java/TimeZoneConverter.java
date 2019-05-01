import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TimeZoneConverter {
    public static void main(String[] args) {
        Calendar universalTime = new GregorianCalendar(TimeZone.getTimeZone("Universal"));

        int hour = universalTime.get(Calendar.HOUR_OF_DAY);
        int minute = universalTime.get(Calendar.MINUTE);
        int second = universalTime.get(Calendar.SECOND);
        int year = universalTime.get(Calendar.YEAR);

        System.out.printf("Universal Time: %d: %d: %d %d\n", hour, minute, second, year);

        Calendar fortWayneTime = new GregorianCalendar(TimeZone.getTimeZone("America/Fort_Wayne"));

        fortWayneTime.setTimeInMillis(universalTime.getTimeInMillis());
        hour = fortWayneTime.get(Calendar.HOUR);
        minute = fortWayneTime.get(Calendar.MINUTE);
        second = fortWayneTime.get(Calendar.SECOND);
        year = fortWayneTime.get(Calendar.YEAR);

        System.out.printf("Eastern Time: %d: %d: %d %d\n", hour, minute, second, year);
    }
}
