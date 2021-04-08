package hust.soict.globalict.lab06.ver2.dao;

import hust.soict.globalict.lab06.ver2.model.media.Media;

public interface MediaDao extends BaseDao<Media> {
    void displayResource(); // displays sample data
    String displayType(Media m); // distinguishes types of media for users
}
