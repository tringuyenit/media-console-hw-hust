package hust.soict.globalict.lab06.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    // 3 required constructors in lab06 assignments--------------------
    public Book(String title){
        super(title);
    }
    public Book(String title, String category){
        super(title, category);
    }
    public Book(String title, String category, List<String> authors){
        super(title, category);
        this.authors = authors;
    }






    // i made bonus constructor for lab06 Menu class--------------------------
    public Book(String title, String category, float cost){
        super(title, category);
        this.setCost(cost);
    }







    // required methods in lab06 assignments----------------------------
    public Book addAuthor(String authorName){
        if (!authors.contains(authorName)){
            this.authors.add(authorName);
        }
        return this;
    } // use "Book" return type instead of void for other use in Menu class
    public void removeAuthor(String authorName){
        if (authors.contains(authorName)){
            this.authors.remove(authorName);
        }
    }
    public List<String> getAuthors() {
        return authors;
    }






    // bonus method for the @Override displayInfo() method
    public String listAuthors(){
        if (this.authors.size() == 0){
            return null;
        } else if (this.authors.size() == 1){
            return this.authors.get(0);
        }

        StringBuilder tmp = new StringBuilder();
        for (int i = 1; i <= this.authors.size(); i++){
            tmp.append(this.authors.get(i - 1));
            if (i == this.authors.size()){
                break;
            }
            tmp.append(", ");
        }

        return tmp.toString();
    }

    @Override // this method needs the above method
    public String displayInfo() {
        return "[" + this.getTitle() + "] - ["
                +this.getCategory() + "] - ["
                +this.listAuthors() + "] : ["
                +this.getCost() + "] $";
    }
}
