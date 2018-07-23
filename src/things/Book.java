package things;


import java.util.ArrayList;

/**
 * Created by Администратор on 10.01.2018.
 */
public class Book extends Thing{
    private String author;
    private String name;
    private int isbn;

    Book(){
    }

//    Book(String name, String author, int isbn){
//        super();
//        this.name = name;
//        this.author = author;
//        this.isbn = isbn;
//    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString() + name + " " + author + " " + isbn;
    }



}
