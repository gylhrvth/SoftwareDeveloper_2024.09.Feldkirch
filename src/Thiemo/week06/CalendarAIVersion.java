package Thiemo.week06;


    import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

    public class CalendarAIVersion {
        public static void main(String[] args) {
            GregorianCalendar gc = new GregorianCalendar();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM");
            System.out.println(sdf.format(gc.getTime()));

            int lastDayofMonth = gc.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
            int actualDay = gc.get(java.util.Calendar.DAY_OF_MONTH);

            // Create a calendar starting from the 1st of the current month
            GregorianCalendar test = new GregorianCalendar();
            test.setTime(gc.getTime());
            test.set(java.util.Calendar.DAY_OF_MONTH, 1);

            System.out.println("| Mo | Di | Mi | Do | Fr | Sa | So |");

            // Get the day of the week for the 1st day of the month (1 = Sunday, 2 = Monday, etc.)
            int firstDayOfWeek = test.get(java.util.Calendar.DAY_OF_WEEK);

            // Adjust for European convention where the week starts on Monday (not Sunday)
            // In Java, Sunday is considered the 1st day, but we want Monday as 1st day
            if (firstDayOfWeek == java.util.Calendar.SUNDAY) {
                firstDayOfWeek = 7; // Treat Sunday as the last day of the week
            } else {
                firstDayOfWeek--; // Shift days to make Monday the start of the week
            }

            // Print leading spaces for the first week (if the month doesn't start on Monday)
            for (int i = 1; i < firstDayOfWeek; i++) {
                System.out.print("|    ");
            }

            // Loop through all days of the month
            for (int day = 1; day <= lastDayofMonth; day++) {
                test.set(java.util.Calendar.DAY_OF_MONTH, day);
                System.out.printf("| %2d", day);

                // Mark the current day with a star
                if (day == actualDay) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

                // Move to the next line after Sunday (end of the week)
                if (test.get(java.util.Calendar.DAY_OF_WEEK) == java.util.Calendar.SUNDAY) {
                    System.out.println("|");
                }
            }

            // Print trailing spaces for the last week (if the month doesn't end on Sunday)
            int lastDayOfWeek = test.get(java.util.Calendar.DAY_OF_WEEK);
            if (lastDayOfWeek != java.util.Calendar.SUNDAY) {
                for (int i = lastDayOfWeek; i <= java.util.Calendar.SATURDAY; i++) {
                    System.out.print("|    ");
                }
                System.out.println("|");
            }
        }
    }


