from com.vordel.trace import Trace
from java.util import Calendar, GregorianCalendar

def invoke(msg):
    # 9 am - 5pm
    notBeforeMins = 9 * 60
    notAfterMins = 17 * 60
    # Monday - Friday 
    notBeforeDay = Calendar.MONDAY
    notAfterDay = Calendar.FRIDAY

    calNow = GregorianCalendar()
    hour = calNow.get(Calendar.HOUR_OF_DAY)
    minute = calNow.get(Calendar.MINUTE)
    minsNow = (hour * 60) + minute
    dayOfWeek = calNow.get(Calendar.DAY_OF_WEEK)

    if (dayOfWeek < notBeforeDay or dayOfWeek > notAfterDay):
        Trace.debug("Tried to access the web service at the weekend")
        return False

    if  (minsNow < notBeforeMins):
        Trace.debug("Tried to access the web service before 9am");
        return False

    if  (minsNow > notAfterMins):
        Trace.debug("Tried to access the web service after 5pm");
        return False

    return True

