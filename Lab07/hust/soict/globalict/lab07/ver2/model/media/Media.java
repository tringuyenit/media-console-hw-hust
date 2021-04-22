package hust.soict.globalict.lab08.ver2.model.media;

import java.util.Comparator;

public abstract class Media {
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

    public Media(String title, String category, float cost){
        this(title, category);
        this.cost = cost;
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

    public static Comparator<Object> CompareMediaType = new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            return type(o1.getClass()) - type(o2.getClass());
        }

        public int type(Class C){
            if (C == Book.class){
                return 1;
            } else if(C == DVD.class){
                return 2;
            } else {
                return 3;
            }
        }
    }; // this improves the addToDB(Object O) method of FakeDB

}
