package hust.soict.globalict.lab08.ver2.model.media;

import hust.soict.globalict.lab08.ver2.utils.comparator.MediaComparatorByCostTitleCategory;
import hust.soict.globalict.lab08.ver2.utils.comparator.MediaComparatorByTitleCategoryCost;

import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
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

    public static final Comparator<Media> CompareMediaType = new Comparator<Media>() {
        @Override
        public int compare(Media o1, Media o2) {
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

    public static final Comparator<Media> COMPARE_BY_TITLE_CATE_COST = new MediaComparatorByTitleCategoryCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE_CATE = new MediaComparatorByCostTitleCategory();

    public static final Comparator<Media> FULL_COMPARE_1 = CompareMediaType.thenComparing(COMPARE_BY_TITLE_CATE_COST);
    public static final Comparator<Media> FULL_COMPARE_2 = CompareMediaType.thenComparing(COMPARE_BY_COST_TITLE_CATE);

    @Override
    public boolean equals(Object o) {
        // Java is so smart that it does not need
        // to use the commented-out code, what a freak ...


//        if(o.getClass() == this.getClass()){
//            if (o.getClass() == DVD.class){
//                return ((DVD) this).equals(o);
//            }
//
//            if (o.getClass() == Book.class){
//                return ((Book) this).equals(o);
//            }
//
//            if (o.getClass() == CD.class){
//                return ((CD) this).equals(o);
//            }
//        }
//        return true;


        if(o instanceof Media){
            Media tmp = (Media) o;
            return (this.getTitle().equals(tmp.getTitle())
                && this.getCategory().equals(tmp.getCategory())
                && this.getCost() == tmp.getCost());
        }
        return false;
    }

    @Override
    public String toString() {

        return "Media{" + "\n" +
                "title='" + this.getTitle() + '\'' + "\n" +
                "category='" + this.getCategory() + '\'' + "\n" +
                "cost=" + this.getCost() + "\n" +
                '}';
    }

    @Override
    public int compareTo(Media o) {
        if (!this.getTitle().equalsIgnoreCase(o.getTitle())){
            return this.getTitle().toLowerCase().compareTo(o.getTitle().toLowerCase());
        }

        if(!this.getCategory().equalsIgnoreCase(o.getCategory())){
            return this.getCategory().toLowerCase().compareTo(o.getCategory().toLowerCase());
        }

        return 0;
    }

}
