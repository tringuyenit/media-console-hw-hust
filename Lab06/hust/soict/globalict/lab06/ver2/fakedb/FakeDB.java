package hust.soict.globalict.lab06.ver2.fakedb;

import hust.soict.globalict.lab06.ver2.model.media.Book;
import hust.soict.globalict.lab06.ver2.model.media.DVD;
import hust.soict.globalict.lab06.ver2.model.media.Media;
import hust.soict.globalict.lab06.ver2.model.order.Order;

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

        FakeDB.resource.add(dvd1);
        FakeDB.resource.add(dvd2);
        FakeDB.resource.add(dvd3);
        FakeDB.resource.add(dvd4);
        FakeDB.resource.add(book1);
        FakeDB.resource.add(book2);
        FakeDB.resource.add(book3);
        FakeDB.resource.add(book4);
    }

    public static ArrayList<Order> getOrders() {
        return orders;
    }

    public static List<Media> getResource() {
        return resource;
    }
}
