package hust.soict.globalict.lab08.ver2.test;

import hust.soict.globalict.lab08.ver2.model.media.Book;

public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("Doraemon", "Comic", 2f).addAuthor("Fujiko F. Fujio").addAuthor("Motoo Abiko");
        book.setContent(" Tri   Tri, ..nguyen,, dep?? trai qua di ! ! o m g :( m m m nguyen");
        System.out.println(book);
    }
}
