package things;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Администратор on 14.01.2018.
 */
public class Books {
    ArrayList<Book> books;

    Books(){
        books = new ArrayList<Book>();
    }

    void addBook(Book book){
        books.add(book);
    }

    void showBooks(){
        for (Book book : books) {
            System.out.println(book);
        }
    }
    //поиск по книгам
    void searchBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("По какому критерию?");
        System.out.println("1. По названию книги");
        System.out.println("2. По имени автора");
        System.out.println("3. По ISBN");
        int choice = 0;
        while (true) {
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice < 1 && choice > 3) {
                    continue;
                }
                break;
            } else {
                sc.nextLine();
            }
        }
        switch (choice) {
            case 1:
                System.out.println("Поиск по названию книги");
                searchForName();
                break;
            case 2:
                System.out.println("Поиск по имени автора");
                searchForAuthor();
                break;
            case 3:
                System.out.println("Поиск по ISBN");
                searchForIsbn(); //поиск по ИСБН
                break;
        }
    }

    //поиск книг по названию
    void searchForName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название книги");
        String searchName = null;
        while (sc.hasNext()){
            searchName = sc.nextLine();
            if (searchName.isEmpty() && isNumber(searchName))
            {
                continue;
            } else {
                break;
            }
        }
        for (Book book : books) {
            if (book.getName().toLowerCase().contains(searchName.toLowerCase())){
                System.out.println(book.toString());
            }
        }
    }

    //поиск книг по имени автора
    void searchForAuthor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя автора");
        String searchAuthor = null;
        while (sc.hasNext()){
            searchAuthor = sc.nextLine();
            if (searchAuthor.isEmpty() && isNumber(searchAuthor))
            {
                continue;
            } else {
                break;
            }
        }
        for (Book book : books) {
            if (book.getAuthor().toLowerCase().contains(searchAuthor.toLowerCase())){
                System.out.println(book.toString());
            }
        }
    }

    //поиск книг по ISBN (тут еще под вопросом, потому что этот код лучше выражать строкой, а не числом)
    void searchForIsbn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ISBN");
        int isbn = 0;
        while (sc.hasNext()){
            isbn = sc.nextInt();
            if (isbn < 0)
            {
                continue;
            } else {
                sc.nextLine();
                break;
            }
        }
        for (Book book : books) {
            if (book.getIsbn() == isbn){
                System.out.println(book.toString());
            }
        }
    }

    boolean isNumber(String str){
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

}
