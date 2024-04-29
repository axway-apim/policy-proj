import com.vordel.trace.Trace;
import java.util.Calendar;
import java.util.GregorianCalendar;

def invoke(msg)         {       
    def notBeforeMins = 9 * 60;   // 9am
    def notAfterMins = 17 * 60;   // 5pm
    def notBeforeDay = Calendar.MONDAY;   // 2
    def notAfterDay = Calendar.FRIDAY;  // 6
    def calNow = new GregorianCalendar();
    def hour = calNow.get(Calendar.HOUR_OF_DAY);
    def minute = calNow.get(Calendar.MINUTE);
    def minsNow = (hour * 60) + minute;
    def dayOfWeek = calNow.get(Calendar.DAY_OF_WEEK);

    if (dayOfWeek < notBeforeDay || dayOfWeek > notAfterDay) {
        Trace.debug("Tried to access the web service at the weekend");
        return false;

    }

    if  (minsNow < notBeforeMins) {
        Trace.debug("Tried to access the web service before 9am");
        return false;

    }

    if  (minsNow > notAfterMins) {
        Trace.debug("Tried to access the web service after 5pm");
        return false;
    }

    return true;         
}

