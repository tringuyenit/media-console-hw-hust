package Lab04;

import java.text.DecimalFormat;

public class Aims {
    public static void main(String[] args) {
        final DecimalFormat format = new DecimalFormat("0.00");

        System.out.println();

        // initializing some DVDs with different constructors
        DVD dvd1 = new DVD("The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction",
                "George", 87, 24.95f);
        DVD dvd3 = new DVD("Animation", "Aladin",
                18.99f);

        // DO NOT RUN ALL 5 TESTS AT THE SAME TIME OWING TO THE STATUS OF FIELD "boolean delete"

//        // Test Order 1
//        Order anOrder1 = Order.makeOrder();
//        // Adding DVD using addDVD(DVD disc)
//        anOrder1.addDVD(dvd1);
//        anOrder1.addDVD(dvd2);
//        anOrder1.addDVD(dvd3);
//        anOrder1.listDVDs();


//        //Test Order 2
//        Order anOrder2 = Order.makeOrder();
//        DVD[] list = {dvd1, dvd2, dvd3};
//        // Adding DVD using addDVD(DVD [] dvdList)
//        anOrder2.addDVD(list);
//        anOrder2.listDVDs();


//        //Test Order 3
//        Order anOrder3 = Order.makeOrder();
//        // Adding DVD using addDVDs(DVD ... dvdList)
//        anOrder3.addDVDs(dvd1, dvd2, dvd3);
//        anOrder3.listDVDs();


//        //Test Order 4
//        Order anOrder4 = Order.makeOrder();
//        // Adding DVD using addDVD(DVD disc1, DVD disc2)
//        anOrder4.addDVD(dvd1, dvd3);
//        anOrder4.listDVDs();



//        //Test MyDate (test all the remaining 15 lines at the same time)
//        MyDate date1 = new MyDate("11", "FeBRuAbabcxyz", "2030"); // this tests the try-to-fix-typo-error feature of constructor
//        System.out.println("");
//        System.out.println(date1.print());
//        System.out.println(date1.print2());
//
//        MyDate date2 = new MyDate("15", "oCtoobber", "2029"); // this tests the try-to-fix-typo-error feature of constructor
//        System.out.println("");
//        System.out.println(date2.print());
//        System.out.println(date2.print2());
//
//        MyDate[] arr = {date1, date2};
//        DateUtils tool = new DateUtils();
//
//        System.out.println("");
//        System.out.println(tool.dateCompare(date1, date2));
//        System.out.println("");
//
//        tool.dateSort(arr);
//        tool.print(arr);

    }
}
