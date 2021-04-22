package hust.soict.globalict.lab08.ver2.model.media;

public class DVD extends Disc{
    // no need to implement Playable interface because I make
    // Disc implementing Playable already

    public DVD(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
    }

    public boolean search(String title){
        return this.getTitle().contains(title);
    }

    @Override
    public String displayInfo() {
        return "[" + this.getTitle() + "] - ["
                +this.getCategory() + "] - ["
                +this.getDirector() + "] - ["
                +this.getLength() + "] : ["
                +this.getCost() + "] $";
    }

    @Override
    public String toString() {

        return "DVD{" + "\n" +
                "title='" + this.getTitle() + '\'' + "\n" +
                "category='" + this.getCategory() + '\'' + "\n" +
                "cost=" + this.getCost() + "\n" +
                "director='" + this.getDirector() + '\'' + "\n" +
                "length=" + this.getLength() + "\n" +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if(o instanceof DVD){
            DVD tmp = (DVD) o;
            return (
               this.getTitle().equals(tmp.getTitle())
            && this.getCategory().equals(tmp.getCategory())
            && this.getCost() == tmp.getCost()
            && this.getLength() == tmp.getLength()
            && this.getDirector().equals(tmp.getDirector()));
        }
        return false;
    }
}
