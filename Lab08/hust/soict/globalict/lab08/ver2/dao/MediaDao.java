package hust.soict.globalict.lab08.ver2.dao;

import hust.soict.globalict.lab08.ver2.model.media.Media;

import java.util.List;

public interface MediaDao extends BaseDao<Media> {
    void displayResource(); // displays sample data
    List<Media> displayResourceByType(Class C); // allow user to choose what to add (Book, CD, DVD ? )
    String displayType(Media m); // distinguishes types of media for users

    void addMedia(Object O);//this method is for Admin only
    void deleteMedia(Object O);//this method is for Admin only
}
