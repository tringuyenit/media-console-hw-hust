package Lab04;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Random;

public class Order {
    final DecimalFormat format = new DecimalFormat("0.00");

    public static final int MAX_NUMBER_ORDER = 10;
    private DVD[] item_ordered = new DVD[MAX_NUMBER_ORDER];
    private int qty_ordered = 0;

    public static final int MAX_LIMITTED_ORDER = 5;
    private static int nbOrders = 0;

    private final MyDate dateOrdered;

    private Order(){
        LocalDate current_date = java.time.LocalDate.now();
        this.dateOrdered = new MyDate(String.valueOf(current_date.getDayOfMonth()),
                                        String.valueOf(current_date.getDayOfMonth()),
                                        String.valueOf(current_date.getYear()));;
    } // make constructor private instead of public

    public static synchronized Order makeOrder() {
        if (nbOrders < MAX_LIMITTED_ORDER) {
            Order newOrder = new Order();
            nbOrders++;
            return newOrder;
        }
        System.out.println("Exceed MAX_LIMITTED_ORDER = 5");
        System.exit(0);
        return null; // this line no use because exit(0)
    } // this is a public "constructor"

    public void addDVD(DVD disc){
        if(this.qty_ordered == MAX_NUMBER_ORDER){
            System.out.println(disc.displayInfo() + " - cannot be added to cart because FULL");
            return;
        }
        this.item_ordered[qty_ordered] = disc;
        this.qty_ordered ++;
    } // Normal adding method

    public void addDVD(DVD disc1, DVD disc2){
        this.addDVD(disc1);
        this.addDVD(disc2);
    } // Overloading by differing the number of parameters

    public void addDVD(DVD [] dvdList){
        for (DVD dvd : dvdList){
            this.addDVD(dvd);
        }
    } // Overloading by differing types of parameter

    public void addDVDs(DVD ... dvdList){
        // em không overload được vì chức năng y hệt addDVD(DVD [] dvdList) nên java không cho :((
        // em phải thêm 's' vào sau tên method :((
        for (DVD dvd : dvdList){
            this.addDVD(dvd);
        }
    } //  "Overloading" by pass an arbitrary number of arguments

    public void removeDVD(DVD disc){
        DVD[] new_item_ordered = new DVD[MAX_NUMBER_ORDER]; // create a new array of some length

        int j = 0; // j is for indexing the new array
        for (int i = 0; i<this.qty_ordered; i++){ // i is for indexing the new array
            if (this.item_ordered[i] == disc){
                this.item_ordered[i].setDelete(true); // set status of delete to be TRUE
                continue; // then escape
            }
            new_item_ordered[j++] = this.item_ordered[i]; // continue to add item if not escaping
        }

        this.item_ordered = new_item_ordered;
        this.qty_ordered--;
    }

    public float totalCost(){
        float total = 0;
        for (int i = 0; i<this.qty_ordered; i++){
            total += this.item_ordered[i].getCost();
        }
        return total;
    }

    public void listDVDs() {
        System.out.println("Lucky Free Item :\n" + getALuckyItem().displayInfo());

        System.out.println("Date: [" + this.dateOrdered.print() + "]");

        System.out.println(this.qty_ordered + " Ordered Items:");

        for (int i = 0; i < this.qty_ordered; i++) {
            System.out.println((i+1) + ". " + this.item_ordered[i].displayInfo());
        }

        System.out.println("Total cost is : " + format.format(this.totalCost()) + " $");
    }

    public DVD getALuckyItem(){
        int lucky = new Random().nextInt(this.qty_ordered);
        DVD dvd = this.item_ordered[lucky];
        this.removeDVD(dvd);
        return dvd;
    }

}
