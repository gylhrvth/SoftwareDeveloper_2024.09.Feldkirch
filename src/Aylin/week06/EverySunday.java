package Aylin.week06;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class EverySunday {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int daysUntilNextSunday = (Calendar.SUNDAY - dayOfWeek + 7) % 7;

        if (daysUntilNextSunday == 0) {
            daysUntilNextSunday = 7;
        }
        calendar.add(Calendar.DAY_OF_MONTH, daysUntilNextSunday);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("The next Sunday is the " + sdf.format(calendar.getTime()));
    }
}
