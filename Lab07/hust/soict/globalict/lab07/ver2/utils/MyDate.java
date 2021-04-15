package hust.soict.globalict.lab07.ver2.utils;

import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MyDate{
    private final String day;
    private final String month;
    private final String year;

    private final String[] date = new String[3];

    private Date date_final;
    public Date getDate_final() {
        return date_final;
    }

    public MyDate(String day, String month, String year) {
        this.day = handleDay(day);
        this.month = handleMonth(month);
        this.year = handleYear(year);
        this.validate();
    } // "day" and "year" arguments must be numbers

    public String print(){
        return this.month + " " + this.day + " " + this.year;
    }
    public String print2(){
        // Write another method in MyDate which allows users can print a date
        // with a format chosen by yourself

        return this.date[0] + "-" + this.date[1] + "-" + this.date[2]; // Choosing yyyy-MM-dd
    }

    private String handleDay(String day){
        try {
            int day_int = Integer.parseInt(day);
            String day_string = String.format("%02d", day_int);
            if(day_int < 1 || day_int > 31){
                System.out.println("illegal day : " + day);
                System.exit(0);
            }
            this.date[2] = day_string;
            if (day_int >= 11 && day_int <= 13) {
                return day_string + "th";
            }
            switch (day_int % 10) {
                case 1:  return day_string + "st";
                case 2:  return day_string + "nd";
                case 3:  return day_string + "rd";
                default: return day_string + "th";
            }

        } catch (NumberFormatException nfe) {
            System.out.println("illegal day : " + day);
            System.exit(0);
        }
        return null;
    }

    private String handleMonth(String month) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        SimpleDateFormat outputFormat = new SimpleDateFormat("MM");
        SimpleDateFormat month_date = new SimpleDateFormat("MMMM", Locale.ENGLISH);

        try {
            int month_numeric = Integer.parseInt(month);
            if (month_numeric<1 || month_numeric > 12){
                System.out.println("illegal month : " + month);
                System.exit(0);
            }

            String day_string = String.format("%02d", month_numeric);
            this.date[1] = day_string;

            try {
                Date date = sdf.parse(day_string);
                return month_date.format(date);
            } catch (ParseException ignored){
                System.out.println("illegal month : " + month);
                System.exit(0);
            }
            return null;

        } catch (NumberFormatException nfe) {
            SimpleDateFormat inputFormat = new SimpleDateFormat("MMMM");
            Calendar cal = Calendar.getInstance();
            try {
                cal.setTime(inputFormat.parse(month));
            } catch (ParseException ignored){
                System.out.println("illegal month : " + month);
                System.exit(0);
            }

            String month_string_MM = outputFormat.format(cal.getTime());
            this.date[1] = month_string_MM;

            try {
                Date date = sdf.parse(month_string_MM);
                return month_date.format(date);
            } catch (ParseException ignored){
                System.out.println("illegal month : " + month);
                System.exit(0);
            }
            return null;
        }


    } // This method allows declaring "month" in constructor
        // either as number or name.
        // It also tries to help reduce typo error when using name of month instead of number

    private String handleYear(String year){
        try {
            int year_int = Integer.parseInt(year);
            if(year_int < 0){
                System.out.println("illegal year : " + year);
                System.exit(0);
            }

        } catch (NumberFormatException nfe) {
            System.out.println("illegal year : " + year);
            System.exit(0);
        }
        this.date[0] = year;
        return year;
    }

    private void validate() {
        String mydate = this.date[0] + "-" + this.date[1] + "-" + this.date[2];
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            this.date_final = sdf.parse(mydate);
        } catch (ParseException e) {
            System.out.println("Invalid date : " + this.print());
            System.exit(0);
        }
    } // this method validates if the date exists in real calendar
}
