package hust.soict.globalict.lab08.ver2.model.media;

import java.util.*;

public class Book extends Media {
    private String content;
    private List<String> contentTokens;
    private Map<String,Integer> wordFrequency;

    private List<String> authors = new ArrayList<String>();

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
    public Book(String title, String category, float cost){
        super(title, category, cost);
    }
    public Book(String title, String category, float cost, List<String> authors){
        super(title, category, cost);
        this.authors = authors;
    }






    // bonus method for the @Override displayInfo() method below,
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


    // made this code to help @override equals(Object o)
    public boolean compareAuthorsList(Book b) {
        Collections.sort(this.getAuthors());
        Collections.sort(b.getAuthors());
        return this.getAuthors().equals(b.getAuthors());
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Book){
            Book tmp = (Book) o;
            return (
                   this.getTitle().equals(tmp.getTitle())
                && this.getCategory().equals(tmp.getCategory())
                && this.getCost() == tmp.getCost()
                && this.compareAuthorsList(tmp));
        }
        return false;
    }

    @Override
    public String displayInfo() {
        return "[" + this.getTitle() + "] - ["
                +this.getCategory() + "] - ["
                +this.listAuthors() + "] : ["
                +this.getCost() + "] $";
    }

    public void setContent(String content) {
        this.content = content;
        this.processContent();
    }

    public void processContent(){
        this.contentTokens = new ArrayList<String>();
        String reg = "[.,!?;\\s*]+";

        Collections.addAll(this.contentTokens, this.content.split(reg));
        for(String s : this.content.split(reg)){
            if (s.equals("")){
               this.contentTokens.remove(s);
            }
        }

        Collections.sort(this.contentTokens);

        this.wordFrequency = new TreeMap<>();
        for (String word : this.contentTokens) {
            if (this.wordFrequency.containsKey(word))
                this.wordFrequency.put(word, this.wordFrequency.get(word) + 1);
            else
                this.wordFrequency.put(word, 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder wordFrequency = new StringBuilder();
        if(this.wordFrequency != null){
            for (Map.Entry<String, Integer> ent : this.wordFrequency.entrySet()) {
                wordFrequency.append('\'').append(ent.getKey()).append("' : ").append(ent.getValue()).append("\n");
            }
        } else {
            wordFrequency.append("null");
        }

        int tokens_size = 0;
        if (this.contentTokens != null){
            tokens_size = this.contentTokens.size();
        }


        return "Book{" + "\n" +
                "title='" + this.getTitle() + '\'' + "\n" +
                "category='" + this.getCategory() + '\'' + "\n" +
                "authors=" + this.listAuthors() + "\n" +
                "cost=" + this.getCost() + "\n" +
                "content='" + content + '\'' + "\n" +
                "content lenght=" + tokens_size + "\n" +
                "contentTokens=" + contentTokens + "\n" +
                "wordFrequency=" + "\n" + wordFrequency + "\n" +
                '}';
    }
}
