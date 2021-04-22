package hust.soict.globalict.lab08.ver2.dao_impl;

import hust.soict.globalict.lab08.ver2.dao.MediaDao;
import hust.soict.globalict.lab08.ver2.fakedb.FakeDB;
import hust.soict.globalict.lab08.ver2.model.media.CD;
import hust.soict.globalict.lab08.ver2.model.media.DVD;
import hust.soict.globalict.lab08.ver2.model.media.Media;

import java.util.ArrayList;
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
        } else if (m.getClass() == CD.class){
            return "CD";
        }
        return "Book";
    } // distinguishes types of media for users

    @Override
    public List<Media> displayResourceByType(Class C) {
        List<Media> itemsByType = new ArrayList<Media>();


        System.out.println("(Type)\t<Id>\t\t\t\t\t\t\t<Details>");
        int i = 1;
        for(Media m : findAll()){
            if(m.getClass() == C){
                itemsByType.add(m);
                System.out.println("("+displayType(m)+")\t<"+i+">   "+ m.displayInfo());
                i++;
            }
        }

        itemsByType.sort(Media.FULL_COMPARE_1);
        return itemsByType;
    } // allow user to choose what to add (Book, CD, DVD ? )

    @Override
    public void displayResource(){
        List<Media> get_resource = findAll();
        get_resource.sort(Media.FULL_COMPARE_1);

        System.out.println("(Type)\t<Id>\t\t\t\t\t\t\t<Details>");
        int i = 1;
        for(Media m : get_resource){
            System.out.println("("+displayType(m)+")\t<"+i+">   "+ m.displayInfo());
            i++;
        }
    } // displays sample data

    @Override
    public void addMedia(Object O) {
        FakeDB.addToDB(O);
    }//this method is for Admin only

    @Override
    public void deleteMedia(Object O) {
        FakeDB.deleteFromDB(O);
    }//this method is for Admin only


}
