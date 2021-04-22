package hust.soict.globalict.lab08.ver2.model.media;

public class Track implements Playable{
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Track{" +
                "title='" + title + '\'' +
                ", length=" + length +
                '}';
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Track){
            Track tmp = (Track) o;
            return (this.getTitle().equals(tmp.getTitle())
                && this.getLength() == tmp.getLength());
        }
        return false;
    }// this improves the setupCD() method of AdminService
}
