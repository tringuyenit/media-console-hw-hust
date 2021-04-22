package hust.soict.globalict.lab08.ver2.test;

import hust.soict.globalict.lab08.ver2.model.media.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMediaCompareTo {
    public static void main(String[] args) {
        DVD dvd1 = new DVD("The Lion King", "Animation",
                "Roger Allers", 87, 19.95f);
        DVD dvd2 = new DVD("Star Wars", "Science Fiction",
                "George", 87, 24.95f);
        DVD dvd3 = new DVD("Tom and Jerry", "Animation",
                "William Hanna", 100, 18.99f);
        DVD dvd4 = new DVD("Hornpub", "Action",
                "tringuyen", 69, 99.99f);

        Book book1 = new Book("Sherlock Holmes", "Adventures", 1f).addAuthor("Arthur Conan Doyle");
        book1.setContent("aaaaa");
        Book book2 = new Book("Doraemon", "Comic", 2f).addAuthor("Fujiko F. Fujio").addAuthor("Motoo Abiko");
        book2.setContent("bbbbb");
        Book book3 = new Book("Cambridge IELTS 10", "Study guide", 3f).addAuthor("Cambridge English");
        book3.setContent("ccccc");
        Book book4 = new Book("How To Read Minds", "Science", 4f).addAuthor("nigahiga");
        book4.setContent("ddddd");

        CD cd1 = new CD("Happy New Year", "Depression", 9, "Björn Stigsson", "ABBA");
        cd1.addTrack(new Track("track1", 200)).addTrack(new Track("track2", 36));
        CD cd2 = new CD("Sexy Love", "Girls", 0, "MBK Entertainment", "T-ara");
        cd2.addTrack(new Track("track1", 314));
        CD cd3 = new CD("Chung ta cua hien tai", "Mafia", 999, "Le Huy Anh", "Nguyen Thanh Tung");
        cd3.addTrack(new Track("track1", 200)).addTrack(new Track("track1", 450)).addTrack(new Track("track1", 240));
        CD cd4 = new CD("Doa Hoa Hong", "null :D", 1, "Boxamxit", "Chi Pu");
        cd4.addTrack(new Track("track1", 272));


        List<Media> media = new ArrayList<Media>();

        media.add(dvd1);
        media.add(dvd2);
        media.add(dvd3);
        media.add(dvd4);
        media.add(book1);
        media.add(book2);
        media.add(book3);
        media.add(book4);
        media.add(cd1);
        media.add(cd2);
        media.add(cd3);
        media.add(cd4);

        System.out.println("Unsorted\n");
        System.out.println("(Type)\t<Id>\t\t\t\t\t\t\t<Details>");
        int i = 1;
        for(Media m : media){
            System.out.println("("+displayType(m)+")\t<"+i+">   "+ m.displayInfo());
            i++;
        }

        Collections.sort(media);

        System.out.println("\nSorted\n");
        System.out.println("(Type)\t<Id>\t\t\t\t\t\t\t<Details>");
        i = 1;
        for(Media m : media){
            System.out.println("("+displayType(m)+")\t<"+i+">   "+ m.displayInfo());
            i++;
        }
    }

    public static String displayType(Media m){
        if (m.getClass() == DVD.class){
            return "DVD";
        } else if (m.getClass() == CD.class){
            return "CD";
        }
        return "Book";
    } // distinguishes types of media for users
}
