package hust.soict.globalict.lab07.ver2.model.media;

public class DVD extends Disc{
    // no need to implement Playable interface because I make
    // Disc implementing Playable already

    private boolean delete = false;

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

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
}
