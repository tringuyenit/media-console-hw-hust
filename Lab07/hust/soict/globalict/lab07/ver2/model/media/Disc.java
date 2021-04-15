package hust.soict.globalict.lab07.ver2.model.media;

public class Disc extends Media implements Playable{
    // I make Disc implementing Playable because it's useful for menu's options

    private int length;
    private String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc(String title, String category, float cost, String director) {
        super(title, category, cost);
        this.director = director;
    } // this constructor is for CD class, since CD does not have field "length"

    public Disc(String title, String category, float cost, int length, String director) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    @Override
    public String displayInfo() {
        return null;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
