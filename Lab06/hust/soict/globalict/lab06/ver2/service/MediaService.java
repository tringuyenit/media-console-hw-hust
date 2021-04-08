package hust.soict.globalict.lab06.ver2.service;

import hust.soict.globalict.lab06.ver2.model.media.Media;

import java.util.List;

public interface MediaService {
    List<Media> findAll();
    Media findById(int id);
    String displayType(Media m); // distinguishes types of media for users
    void displayResource(); // displays sample data
}
