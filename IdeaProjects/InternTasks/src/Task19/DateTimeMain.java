package Task19;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class DateTimeMain
{
    public static void main(String[] args)
    {
        //Using LocalDate class we can get current date using the method now()
        LocalDate today = LocalDate.ofEpochDay(9625816546545648L);
        /* we can calculate the days by adding or subtracting the number of days using
        the method minusDays(x) or plusDays(x), x --> no of days */
        LocalDate yesterday = today.minusDays(1);
        LocalDate tomorrow = today.plusDays(1);

        System.out.println("Yesterday: " + yesterday);
        System.out.println("Current date: " + today);
        System.out.println("Tomorrow: " + tomorrow);


        //Using LocalDateTime class for fetching Date and time both
        LocalDateTime currentDateWithTime = LocalDateTime.now();
        System.out.println("Current date with time: " + currentDateWithTime);

        //Printing the current date in specified formats like "yyyy-MM-dd","dd/MM/yyyy","MM/dd/yyyy","yyyy-MM-dd-HH-mm-ss-ns"
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDateWithTime.format(format1);
        System.out.println("'yyyy-MM-dd' Formatted Date :"+formattedDate);
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate2 = currentDateWithTime.format(format2);
        System.out.println("'dd/MM/yyyy' Formatted Date :"+formattedDate2);
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate3 = currentDateWithTime.format(format3);
        System.out.println("'MM/dd/yyyy' Formatted Date :"+formattedDate3);
        DateTimeFormatter format4 = DateTimeFormatter.ofPattern("yyyy-MM-dd-hh-mm-ss-ns");
        String formattedDate4 = currentDateWithTime.format(format4);
        System.out.println("'yyyy-MM-dd-hh-mm-ss' Formatted Date :"+formattedDate4);
        DateTimeFormatter format5 = DateTimeFormatter.ofPattern("MMMM-dd-yyyy");
        String formattedDate5 = currentDateWithTime.format(format5);
        System.out.println("'MMMM-dd-yyyy' Formatted Date :"+formattedDate5);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some long value to convert to date");
        long convertToDate = scanner.nextLong();
        Date longDate = new Date(convertToDate);
        System.out.println("Date from the Long value is: " + longDate);

        ZonedDateTime zonedDateTime = currentDateWithTime.atZone(ZoneId.systemDefault());
        System.out.println("Current date with default time zone : "+zonedDateTime);
        System.out.println("Default time zone is : "+zonedDateTime.getZone());
        ZonedDateTime utcFormattedDate = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("Zoned date with the UTC format : "+utcFormattedDate);
        ZonedDateTime gmtFormattedDate = zonedDateTime.withZoneSameInstant(ZoneId.of("GMT"));
        System.out.println("Zoned date with the GMT format : "+gmtFormattedDate);
        ZonedDateTime europeDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Berlin"));
        System.out.println("Europe Zoned date"+europeDateTime);
    }
}
