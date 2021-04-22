package hust.soict.globalict.lab08.ver2.service;

import hust.soict.globalict.lab08.ver2.model.media.Book;
import hust.soict.globalict.lab08.ver2.model.media.CD;
import hust.soict.globalict.lab08.ver2.model.media.DVD;
import hust.soict.globalict.lab08.ver2.model.media.Track;

import java.util.List;

public interface AdminService {
    float setupCost();

    String setupTitle();

    String setpuCategory();

    int setupLength();

    String setupDirector();

    List<String> setupAuthors();

    String setupArtist();

    Track setupTrack(int i, int num);

    Book setupBook();

    DVD setupDVD();

    CD setupCD();
}
