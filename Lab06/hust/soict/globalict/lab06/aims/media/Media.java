package hust.soict.globalict.lab06.aims.media;

public abstract class Media { // this class is absstract :D
    private String title;
    private String category;
    private float cost;

    public Media(String title){
        this.title = title;
    }

    public Media(String title, String category){
        this(title);
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Media setCost(float cost) {
        this.cost = cost;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public abstract String displayInfo();

}
