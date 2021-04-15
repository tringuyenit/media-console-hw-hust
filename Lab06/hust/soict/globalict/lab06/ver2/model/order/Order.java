package hust.soict.globalict.lab06.ver2.model.order;

import hust.soict.globalict.lab06.ver2.model.media.Media;
import hust.soict.globalict.lab06.ver2.utils.MyDate;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Order {
    final DecimalFormat format = new DecimalFormat("0.00");

    public static final int MAX_NUMBER_ORDER = 10;

    private final ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public static final int MAX_LIMITTED_ORDER = 5;
    private static int nbOrders = 0;

    private final MyDate dateOrdered;

    private Order(){
        LocalDate current_date = LocalDate.now();
        this.dateOrdered = new MyDate(String.valueOf(current_date.getDayOfMonth()),
                                        String.valueOf(current_date.getMonth()),
                                        String.valueOf(current_date.getYear()));;
    } // make constructor private instead of public

    public static synchronized Order makeOrder() {
        if (nbOrders < MAX_LIMITTED_ORDER) {
            Order newOrder = new Order();
            nbOrders++;
            return newOrder;
        }
        System.out.println("Exceed MAX_LIMITTED_ORDER = 5");
        return null;
    } // this is a public "constructor"

    //---------------------------------------------------------
    // i made bonus code for lab06 - specifically for OrderController
    public int getNumberOfItem(){
        return this.itemsOrdered.size();
    }
    public void deleteOrder(){
        nbOrders--;
    }
    public void removeMediaById(int id){
        if (this.itemsOrdered.size() > 0){
            this.itemsOrdered.remove(id);
        }
    }
    public void listItemInOrder() {

        System.out.println(this.itemsOrdered.size() + " Ordered Items:");

        int i = 1;
        for (Media m : this.itemsOrdered) {
            System.out.println(i + ". " + m.displayInfo());
            i++;
        }

        System.out.println("Total cost is : " + format.format(this.totalCost()) + " $");
    }






    //---------------------------------------------------------
    // code that are required in lab05 assignment, also used for lab06
    public boolean addMedia(Media media){
        if(this.itemsOrdered.size() == MAX_NUMBER_ORDER){
            System.out.println(media.displayInfo() + " - cannot be added to cart because FULL");
            return false;
        }
        this.itemsOrdered.add(media);
        return true;
    }
    public void removeMedia(Media media){
        if (this.itemsOrdered.size() > 0){
            this.itemsOrdered.remove(media);
        }
    }
    public float totalCost(){
        float total = 0;
        for (Media m : this.itemsOrdered){
            total += m.getCost();
        }
        return total;
    }
    public Media getALuckyItem(){
        int lucky = new Random().nextInt(this.itemsOrdered.size());
        Media media = this.itemsOrdered.get(lucky);
        this.removeMedia(media);
        return media;
    }
    public void listMedias() {

        System.out.println("Lucky Free Item :\n" + getALuckyItem().displayInfo());

        System.out.println("Date: [" + this.dateOrdered.print() + "]");

        System.out.println(this.itemsOrdered.size() + " Ordered Items:");

        int i = 1;
        for (Media m : this.itemsOrdered) {
            System.out.println(i + ". " + m.displayInfo());
            i++;
        }

        System.out.println("Total cost is : " + format.format(this.totalCost()) + " $");
    }

}
