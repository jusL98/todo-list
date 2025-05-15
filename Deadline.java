import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.Serializable;

public class Deadline implements Serializable {
    private int month;
    private int day;
    private int year;
    private Calendar calendar;
    private Date date;

    public Deadline() {
        calendar = Calendar.getInstance();

        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.year = calendar.get(Calendar.YEAR);

        calendar.set(this.year, this.month, this.day, 0, 0, 0);
    }

    public Deadline(int month, int day, int year) {
        calendar = Calendar.getInstance();

        this.month = month - 1;
        this.day = day;
        this.year = year;

        calendar.set(this.year, this.month, this.day, 0, 0, 0);
    }

    public Deadline(Date date) {
        calendar = Calendar.getInstance();

        calendar.setTime(date);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
        this.year = calendar.get(Calendar.YEAR);

        calendar.set(this.year, this.month, this.day, 0, 0, 0);
    }


    public Date getDate() {
        date = calendar.getTime();
        return date;
    }

    public static String getFormattedDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy"); // MM for number, MMM for word
        String fDate = simpleDateFormat.format(date);
        return fDate;
    }

    public static Date parseDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");
        Date date2 = new Date();

        try {
            date2 = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            //System.err.println("Error parsing date: " + e.getMessage());
            return null;
        }

        return date2;
    }

    public static void main(String[] args) {
        Deadline d1 = new Deadline();

        System.out.println(d1.getDate());
        System.out.println(getFormattedDate(d1.getDate()));

        Date test = Deadline.parseDate("Feb 15, 2025");

        System.out.println(test);
    }
}
