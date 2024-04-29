var imp = new JavaImporter(com.vordel.trace, java.util);
with(imp) {
    function invoke(msg) {

        var notBeforeMins = 9 * 60; // 9am
        var notAfterMins = 17 * 60; // 5pm
        var notBeforeDay = Calendar.MONDAY; // 2
        var notAfterDay = Calendar.FRIDAY; // 6
        var calNow = new GregorianCalendar();
        var hour = calNow.get(Calendar.HOUR_OF_DAY);
        var minute = calNow.get(Calendar.MINUTE);
        var minsNow = (hour * 60) + minute;
        var dayOfWeek = calNow.get(Calendar.DAY_OF_WEEK);

        if (dayOfWeek < notBeforeDay || dayOfWeek > notAfterDay) {
            Trace.debug("Tried to access the web service at the weekend");
            return false;

        }

        if (minsNow < notBeforeMins) {
            Trace.debug("Tried to access the web service before 9am");
            return false;

        }

        if (minsNow > notAfterMins) {
            Trace.debug("Tried to access the web service after 5pm");
            return false;
        }
        return true;
    }
};