package Lab03;

import java.text.DecimalFormat;

public class Aims {
    public static void main(String[] args) {
        final DecimalFormat format = new DecimalFormat("0.00");

        Order anOrder = new Order();

        DVD dvd1 = new DVD("The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);
        anOrder.addDVD(dvd1);

        DVD dvd2 = new DVD("Star Wars", "Science Fiction",
                "George", 87, 24.95f);
        anOrder.addDVD(dvd2);

        DVD dvd3 = new DVD("Animation", "Aladin",
                18.99f);
        anOrder.addDVD(dvd3);

        System.out.println("Total cost is " + format.format(anOrder.totalCost()));

        anOrder.removeDVD(dvd1);
        System.out.println("Total cost is " + format.format(anOrder.totalCost()));
    }
}
