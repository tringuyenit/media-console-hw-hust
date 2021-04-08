package hust.soict.globalict.lab06.ver2.dao_impl;

import hust.soict.globalict.lab06.ver2.dao.MediaDao;
import hust.soict.globalict.lab06.ver2.fakedb.FakeDB;
import hust.soict.globalict.lab06.ver2.model.media.DVD;
import hust.soict.globalict.lab06.ver2.model.media.Media;

import java.util.List;

public class MediaDaoImpl implements MediaDao {
    @Override
    public List<Media> findAll() {
        return FakeDB.getResource();
    }

    @Override
    public Media findById(int id) {
        return FakeDB.getResource().get(id);
    }

    @Override
    public String displayType(Media m){
        if (m.getClass() == DVD.class){
            return "DVD";
        }
        return "Book";
    } // distinguishes types of media for users

    @Override
    public void displayResource(){
        System.out.println("(Type)\t<Id>\t\t\t\t\t\t\t<Details>");
        int i = 1;
        for(Media m : findAll()){
            System.out.println("("+displayType(m)+")\t<"+i+">   "+ m.displayInfo());
            i++;
        }
    } // displays sample data
}
