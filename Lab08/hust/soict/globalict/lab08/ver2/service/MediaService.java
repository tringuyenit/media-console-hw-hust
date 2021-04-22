package hust.soict.globalict.lab08.ver2.service;

import hust.soict.globalict.lab08.ver2.model.media.Disc;
import hust.soict.globalict.lab08.ver2.model.media.Media;
import hust.soict.globalict.lab08.ver2.model.order.Order;

import java.util.List;

public interface MediaService {
    List<Media> findAll();
    Media findById(int id);
    List<Media> displayResourceByType(Class C); // allow user to choose what to add (Book, CD, DVD ? )
    List<Disc> displayResourcePlayable(Order O); // show items in user's cart that have play() method (because Book does not have)
    String displayType(Media m); // distinguishes types of media for users
    void displayResource(); // displays sample data

    void addMedia(Object O);//this method is for Admin only
    void deleteMedia(Object O);//this method is for Admin only
}
