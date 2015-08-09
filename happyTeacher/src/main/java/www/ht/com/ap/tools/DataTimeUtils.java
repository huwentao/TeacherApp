package www.ht.com.ap.tools;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by mokey on 2015/8/10.
 */
public class DataTimeUtils {
    public static DateTime paserDateTimeForPattern(String timeStr, String pattern) {
//        DateTimeFormatter timeFormat = DateTimeFormat.forPattern("yyyy/MM/dd HH:mm");
        DateTimeFormatter timeFormat = DateTimeFormat.forPattern(pattern);
        DateTime dateTime = timeFormat.parseDateTime(timeStr);
        return dateTime;
    }
}
