package hust.soict.globalict.lab07.ver2.model.media;

import java.util.ArrayList;
import java.util.List;

public class CD extends Disc{
    // no need to implement Playable interface because I make
    // Disc implementing Playable already

    private String artis;
    private final List<Track> tracks = new ArrayList<Track>();

    public CD(String title, String category, float cost, String director, String artis) {
        super(title, category, cost, director);
        this.artis = artis;
    }

    public String getArtis() {
        return artis;
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

    @Override
    public String displayInfo() {
        return "[" + this.getTitle() + "] - ["
                +this.getCategory() + "] - ["
                +this.getDirector() + "] - ["
                +this.getLength() + "] : ["
                +this.getCost() + "] $";
    }

    @Override
    public void play() {
        System.out.println("=========");
        System.out.println("CD : artis = "+this.artis);
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
}
