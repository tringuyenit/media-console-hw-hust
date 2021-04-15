package hust.soict.globalict.lab07.ver2.service_impl;

import hust.soict.globalict.lab07.ver2.dao.MediaDao;
import hust.soict.globalict.lab07.ver2.dao_impl.MediaDaoImpl;
import hust.soict.globalict.lab07.ver2.model.media.CD;
import hust.soict.globalict.lab07.ver2.model.media.DVD;
import hust.soict.globalict.lab07.ver2.model.media.Disc;
import hust.soict.globalict.lab07.ver2.model.media.Media;
import hust.soict.globalict.lab07.ver2.model.order.Order;
import hust.soict.globalict.lab07.ver2.service.MediaService;

import java.util.ArrayList;
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
    } // distinguishes types of media for users

    @Override
    public List<Media> displayResourceByType(Class C) {
        return mediaDao.displayResourceByType(C);
    } // allow user to choose what to add (Book, CD, DVD ? )

    @Override
    public List<Disc> displayResourcePlayable(Order O) {
        List<Disc> itemsPlayable = new ArrayList<Disc>();
        System.out.println("(Type)\t<Id>\t\t\t\t\t\t\t<Details>");
        int i = 1;
        for(Media m : O.getItemsOrdered()){
            if(m.getClass() == DVD.class || m.getClass() == CD.class){
                itemsPlayable.add((Disc) m);
                System.out.println("("+displayType(m)+")\t<"+i+">   "+ m.displayInfo());
                i++;
            }
        }
        return itemsPlayable;
    } // show items in user's cart that have play() method (because Book does not have)

    @Override
    public void displayResource(){
        mediaDao.displayResource();
    } // displays sample data

    @Override
    public void addMedia(Object O) {
        mediaDao.addMedia(O);
        if(O != null){
            System.out.println("New item has been added");
        }
    }//this method is for Admin only

    @Override
    public void deleteMedia(Object O) {
        mediaDao.deleteMedia(O);
        if(O != null){
            System.out.println("The item has been deleted");
        }
    }//this method is for Admin only

}
