package sit707_tasks;

/**
 * Represents a date with day, month, and year, and provides methods to increment or decrement by one day.
 * @author Ahsan Habib
 */
public class DateUtil {

    // Months in order 0-11 maps to January-December.
    private static final String[] MONTHS = new String[] {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    };

    private int day, month, year;

    /**
     * Constructs a DateUtil object with the given day, month, and year.
     * Validates input ranges: day (1-31), month (1-12), year (1700-2024).
     * @param day   the day of the month (1-31)
     * @param month the month of the year (1-12)
     * @param year  the year (1700-2024)
     * @throws RuntimeException if the date is invalid
     */
    public DateUtil(int day, int month, int year) {
        if (day < 1 || day > 31)
            throw new RuntimeException("Invalid day: " + day + ", expected range 1-31");
        if (month < 1 || month > 12)
            throw new RuntimeException("Invalid month: " + month + ", expected range 1-12");
        if (year < 1700 || year > 2024)
            throw new RuntimeException("Invalid year: " + year + ", expected range 1700-2024");
        if (day > monthDuration(month, year))
            throw new RuntimeException("Invalid day: " + day + ", max day: " + monthDuration(month, year));
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Gets the day of the month.
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * Gets the month of the year.
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Gets the year.
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Increments the date by one day, handling month and year transitions.
     */
    public void increment() {
        if (day < monthDuration(month, year)) {
            // At least 1 day remaining in current month of year.
            day++;
        } else if (month < 12) {
            // Last day of a month AND month is less than December, so +1d is first day of next month.
            day = 1;
            month++;
        } else {
            // Month is December, so +1d is 1st January next year.
            day = 1;
            month = 1;
            year++;
            if (year > 2024) {
                throw new RuntimeException("Cannot increment beyond 31 December 2024");
            }
        }
    }

    /**
     * Decrements the date by one day, handling month and year transitions.
     */
    public void decrement() {
        if (day > 1) {
            day--;
        } else if (month > 1) {
            month--;
            day = monthDuration(month, year);
        } else {
            month = 12;
            year--;
            day = monthDuration(month, year);
            if (year < 1700) {
                throw new RuntimeException("Cannot decrement below 1 January 1700");
            }
        }
    }

    /**
     * Calculates the number of days in a given month of a year, accounting for leap years.
     * Note: Uses simple leap year rule (year % 4 == 0), which is not fully accurate for century years.
     * @param month the month (1-12)
     * @param year  the year
     * @return the number of days in the month
     */
    public static int monthDuration(int month, int year) {
        if (month == 2 && year % 4 == 0) {
            // February leap year (simplified rule)
            return 29;
        } else if (month == 2) {
            // Normal 28 days February
            return 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            // 30 days' months
            return 30;
        }
        return 31; // Rest are 31 days' months.
    }

    /**
     * Returns a user-friendly string representation of the date.
     * @return the date in "day Month year" format (e.g., "1 January 2024")
     */
    @Override
    public String toString() {
        return day + " " + MONTHS[month - 1] + " " + year;
    }
}