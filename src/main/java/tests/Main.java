package tests;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) throws ParseException {

        String input = "1150";
        SimpleDateFormat parser = new SimpleDateFormat("ss");
        Date date = parser.parse(input);
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        System.out.println(formatter.format(date));
        System.out.println(date);

        Calendar calendar = new GregorianCalendar(0,0,0,0,0, 100);
        System.out.println(calendar.getTimeInMillis());
        System.out.println(calendar.getTime());

    }

}
