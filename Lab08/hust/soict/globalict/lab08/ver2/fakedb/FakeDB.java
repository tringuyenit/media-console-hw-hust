package hust.soict.globalict.lab08.ver2.fakedb;

import hust.soict.globalict.lab08.ver2.model.media.*;
import hust.soict.globalict.lab08.ver2.model.order.Order;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {
    private static final ArrayList<Order> orders = new ArrayList<Order>(); // maximum 5 orders
    private static List<Media> resource; // sample data

    // generates sample data,
    // đại ca Châu bảo mỗi loại 4 cái
    static {
        FakeDB.resource = new ArrayList<>();

        DVD dvd1 = new DVD("The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction",
                "George", 87, 24.95f);
        DVD dvd3 = new DVD("Tom and Jerry", "Animation",
                "William Hanna", 100, 18.99f);
        DVD dvd4 = new DVD("Hornpub", "Action",
                "tringuyen", 69, 99.99f);

        Book book1 = new Book("Sherlock Holmes", "Adventures", 1f).addAuthor("Arthur Conan Doyle");
        Book book2 = new Book("Doraemon", "Comic", 2f).addAuthor("Fujiko F. Fujio").addAuthor("Motoo Abiko");
        Book book3 = new Book("Cambridge IELTS 10", "Study guide", 3f).addAuthor("Cambridge English");
        Book book4 = new Book("How To Read Minds", "Science", 4f).addAuthor("nigahiga");

        CD cd1 = new CD("Happy New Year", "Depression", 9, "Björn Stigsson", "ABBA");
        cd1.addTrack(new Track("track1", 200)).addTrack(new Track("track2", 36));
        CD cd2 = new CD("Sexy Love", "Girls", 0, "MBK Entertainment", "T-ara");
        cd2.addTrack(new Track("track1", 314));
        CD cd3 = new CD("Chung ta cua hien tai", "Mafia", 999, "Le Huy Anh", "Nguyen Thanh Tung");
        cd3.addTrack(new Track("track1", 200)).addTrack(new Track("track1", 450)).addTrack(new Track("track1", 240));
        CD cd4 = new CD("Doa Hoa Hong", "null :D", 1, "Boxamxit", "Chi Pu");
        cd4.addTrack(new Track("track1", 272));

        FakeDB.resource.add(dvd1);
        FakeDB.resource.add(dvd2);
        FakeDB.resource.add(dvd3);
        FakeDB.resource.add(dvd4);
        FakeDB.resource.add(book1);
        FakeDB.resource.add(book2);
        FakeDB.resource.add(book3);
        FakeDB.resource.add(book4);
        FakeDB.resource.add(cd1);
        FakeDB.resource.add(cd2);
        FakeDB.resource.add(cd3);
        FakeDB.resource.add(cd4);

        resource.sort(Media.FULL_COMPARE_1); // sort item by Type
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static List<Media> getResource() {
        return resource;
    }

    public static int getResourceSize(){
        return resource.size();
    }

    public static void addToDB(Object O){
        if (O == null){
            return;
        }

        if (O.getClass() == DVD.class){
            resource.add((DVD) O);
        }else if (O.getClass() == Book.class){
            resource.add((Book) O);
        } else {
            resource.add((CD) O);
        }
        resource.sort(Media.FULL_COMPARE_1); // sort item by Type after adding into resource
    }//this method is for Admin only

    public static void deleteFromDB(Object O){
        if (O == null){
            return;
        }

        if (O.getClass() == DVD.class){
            resource.remove((DVD) O);
        }else if (O.getClass() == Book.class){
            resource.remove((Book) O);
        } else {
            resource.remove((CD) O);
        }
        resource.sort(Media.FULL_COMPARE_1); // sort item by Type after delete from resource
    }//this method is for Admin only
}
