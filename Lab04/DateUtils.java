package Lab03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class DateUtils {
    private byte dateCompareBasic(Date date1, Date date2) {
        if (date1.after(date2)) {
            return 1;
        }
        if (date1.before(date2)) {
            return -1;
        }
        return 0;
    }

    public void print(MyDate[] dates){
        for (MyDate md : dates){
            System.out.println(md.print());
        }
    }

    public byte dateCompare(MyDate date1, MyDate date2) {
        return dateCompareBasic(date1.getDate_final(), date2.getDate_final());
    }

    public void dateSort(MyDate[] dates) {
        Arrays.sort(dates, new Comparator<MyDate>() {
            @Override
            public int compare(MyDate o1, MyDate o2) {
                return dateCompare(o1, o2);
            }
        });
    }
}
