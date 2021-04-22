package hust.soict.globalict.lab08.ver2.model.media;

import java.util.ArrayList;
import java.util.List;

public class CD extends Disc{
    // no need to implement Playable interface because I make
    // Disc implementing Playable already

    private String artist;
    private final List<Track> tracks = new ArrayList<Track>();

    public CD(String title, String category, float cost, String director, String artist) {
        super(title, category, cost, director);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public CD addTrack(Track track){
        if (!this.tracks.contains(track)){
            this.tracks.add(track);
//            System.out.println("add track successfully :D  -- " + track);
        }
//        System.out.println("this track's already added  -- " + track);
        return this;
    }// method should check if the input track is already in the list of tracks and inform users

    public CD removeTrack(Track track){
        if (this.tracks.contains(track)){
            this.tracks.remove(track);
//            System.out.println("remove track successfully :D  -- " + track);
        }
//        System.out.println("wtf track not exists to be removed ???  -- " + track);
        return this;
    }//method should check if the input track existed in the list of tracks and inform users

    // made this code to help @override equals(Object o)
    public boolean compareTrackList(CD c) {
        if(this.getTracks().size() != c.getTracks().size()){
            return false;
        }

        boolean tmp = true;
        for(Track track1 : this.getTracks()){

            for (Track track2 : c.getTracks()){
                if(track1.equals(track2)){
                    tmp = false;
                    break;
                }
            }

            if(tmp){
                return false;
            }

            tmp = true;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof CD){
            CD tmp = (CD) o;
            return (
                   this.getTitle().equals(tmp.getTitle())
                && this.getCategory().equals(tmp.getCategory())
                && this.getCost() == tmp.getCost()
                && this.getLength() == tmp.getLength()
                && this.getDirector().equals(tmp.getDirector())
                && this.getArtist().equals(tmp.getArtist())
                && this.compareTrackList(tmp));
        }
        return false;
    }

    @Override
    public void play() {
        System.out.println("=========");
        System.out.println("CD : artis = "+this.artist);
        for (Track track : this.tracks){
            track.play();
        }
        System.out.println("=========");
    }

    public int getLength(){
        int total_length = 0;
        for (Track track : this.tracks){
            total_length += track.getLength();
        }
        return total_length;
    }

    @Override
    public String displayInfo() {
        return "[" + this.getTitle() + "] - ["
                +this.getCategory() + "] - ["
                +this.getDirector() + "] - ["
                +this.getArtist() + "] - ["
                +this.getLength() + "] : ["
                +this.getCost() + "] $";
    }

    @Override
    public String toString() {

        return "CD{" + "\n" +
                "title='" + this.getTitle() + '\'' + "\n" +
                "category='" + this.getCategory() + '\'' + "\n" +
                "cost=" + this.getCost() + "\n" +
                "director='" + this.getDirector() + '\'' + "\n" +
                "artist='" + this.getArtist() + '\'' + "\n" +
                "length=" + this.getLength() + "\n" +
                '}';
    }
}
