package hust.soict.globalict.lab06.ver2.service_impl;

import hust.soict.globalict.lab06.ver2.dao.MediaDao;
import hust.soict.globalict.lab06.ver2.dao_impl.MediaDaoImpl;
import hust.soict.globalict.lab06.ver2.model.media.Media;
import hust.soict.globalict.lab06.ver2.service.MediaService;

import java.util.List;

public class MediaServiceImpl implements MediaService {

    private final MediaDao mediaDao = new MediaDaoImpl();

    @Override
    public List<Media> findAll() {
        return mediaDao.findAll();
    }

    @Override
    public Media findById(int id) {
        return mediaDao.findById(id);
    }

    @Override
    public String displayType(Media m) {
        return mediaDao.displayType(m);
    }

    @Override
    public void displayResource(){
        mediaDao.displayResource();
    } // displays sample data

}
