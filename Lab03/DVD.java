package Lab03;

public class DVD {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private boolean delete = false;

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public DVD(String title){
        this.title = title;
    }

    public DVD(String category, String title, float cost){
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DVD(String director, String category, String title, float cost){
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DVD(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
}
