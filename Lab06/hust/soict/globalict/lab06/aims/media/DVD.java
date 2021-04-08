package hust.soict.globalict.lab06.aims.media;

public class DVD extends Media{
    private String director;
    private int length;
    private boolean delete = false;

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public DVD(String title){
        super(title);
    }

    public DVD(String category, String title, float cost){
        super(title, category);
        this.setCost(cost);
    }

    public DVD(String director, String category, String title, float cost){
        super(title, category);
        this.setCost(cost);
        this.director = director;
    }

    public DVD(String title, String category, String director, int length, float cost) {
        super(title, category);
        this.setCost(cost);
        this.director = director;
        this.length = length;
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
