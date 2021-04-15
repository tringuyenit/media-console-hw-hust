package hust.soict.globalict.lab06.aims.order;

import hust.soict.globalict.lab06.aims.media.Media;
import hust.soict.globalict.lab06.ver2.utils.MyDate;
import hust.soict.globalict.lab06.aims.media.DVD;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Order {
    final DecimalFormat format = new DecimalFormat("0.00");

    public static final int MAX_NUMBER_ORDER = 10;
    private DVD[] item_ordered = new DVD[MAX_NUMBER_ORDER];
    private int qty_ordered = 0;

    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public static final int MAX_LIMITTED_ORDER = 5;
    private static int nbOrders = 0;

    private final MyDate dateOrdered;

    private Order(){
        LocalDate current_date = java.time.LocalDate.now();
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
    // bonus code for lab06 - mainly for Menu class
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

        System.out.println("Total cost is : " + format.format(this.totalCost2()) + " $");
    }








    //---------------------------------------------------------
    // New code that are required in lab05 assignment, also used for lab06
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
    public float totalCost2(){
        float total = 0;
        for (Media m : this.itemsOrdered){
            total += m.getCost();
        }
        return total;
    }
    public Media getALuckyItem2(){
        int lucky = new Random().nextInt(this.itemsOrdered.size());
        Media media = this.itemsOrdered.get(lucky);
        this.removeMedia(media);
        return media;
    }
    public void listMedias() {

        System.out.println("Lucky Free Item :\n" + getALuckyItem2().displayInfo());

        System.out.println("Date: [" + this.dateOrdered.print() + "]");

        System.out.println(this.itemsOrdered.size() + " Ordered Items:");

        int i = 1;
        for (Media m : this.itemsOrdered) {
            System.out.println(i + ". " + m.displayInfo());
            i++;
        }

        System.out.println("Total cost is : " + format.format(this.totalCost2()) + " $");
    }










    // Preserved code for lab04 tests,
    // deleting these has no affects on lab05, lab06 but "DiskTest" class
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
