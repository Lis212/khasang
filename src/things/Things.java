package things;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Администратор on 14.01.2018.
 */
public class Things {
    ArrayList<Thing> things;
    boolean gameOver;
    Books books;
    ClothesList clothesList;
    Magnets magnets;

    Things() {
        things = new ArrayList<Thing>(); //создаю общий список вещей
        books = new Books(); //сразу создаю список книг
        clothesList = new ClothesList(); //сразу создаю список одежды
        magnets = new Magnets(); //сразу создаю список магнитов
    }

    boolean getGameOver() {
        return gameOver;
    }

    void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    //выбор взаимодействия
    void start(){
        choice();
    }

    void choice() {
        System.out.println("Что Вы хотите сделать?");
        System.out.println("1. Добавить вещь на полку");
        System.out.println("2. Убрать вещь с полки");
        System.out.println("3. Посмотреть информацию о вещи");
        System.out.println("4. Удалить все с полок");
        System.out.println("5. Показать список всех вещей на полке");
        System.out.println("6. Показать все книги");
        System.out.println("7. Показать всю одежду");
        System.out.println("8. Показать все магнитики");
        System.out.println("9. Выйти из программы");
        System.out.println("10. Поиск");
        switch (input(10)) { //принимаемый аргумент - количество возможных вариантов выбора действий
            case 1:
                System.out.println("Добавить вещь на полку");
                add();
                break;
            case 2:
                System.out.println("Убрать вещь с полки");
                remove();
                break;
            case 3:
                System.out.println("Посмотреть информацию о вещи");
                info();
                break;
            case 4:
                System.out.println("Удалить все с полок");
                things.clear();
                break;
            case 5:
                System.out.println("Показать список всех вещей на полке");
                print();
                break;
            case 6:
                System.out.println("Показать все книги");
                showBook();
                break;
            case 7:
                System.out.println("Показать всю одежду");
                showClothes();
                break;
            case 8:
                System.out.println("Показать все магнитики");
                showMagnet();
                break;
            case 9:
                System.out.println("Выйти из программы");
                setGameOver(true);
                break;
            case 10:
                System.out.println("Поиск");
                search();
                break;
        }
    }

    //добавить вещь
    void add(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Что вы хотите добавить?");
        System.out.println("1. Книгу");
        System.out.println("2. Одежду");
        System.out.println("3. Магнитик");
        int choice = 0;
        while (true) {
            if (sc.hasNextInt()){
                choice = sc.nextInt();
                sc.nextLine();
                if (choice < 1 && choice > 3){
                    continue;
                }
                break;
            } else {
                sc.nextLine();
            }
        }
        switch (choice){
            case 1:
                Book book = new Book();
                System.out.println("Введите название книги");
                book.setName(sc.nextLine());
                System.out.println("Введите автора книги");
                book.setAuthor(sc.nextLine());
                System.out.println("Введите ISBN книги");
                book.setIsbn(sc.nextInt());
                things.add(book);
                books.addBook(book);
                break;
            case 2:
                Clothes clothes = new Clothes();
                System.out.println("Введите размер");
                clothes.setSize(sc.nextInt());
                things.add(clothes);
                clothesList.addClothesList(clothes);
                break;
            case 3:
                Magnet magnet = new Magnet();
                System.out.println("Откуда привезли?");
                magnet.setOrigin(sc.nextLine());
                things.add(magnet);
                magnets.addMagnets(magnet);
                break;
        }
    }

    //удалить вещь
    void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID вещи, которую хотите убрать");
        int choice = 0;
        while (true) {
            if (sc.hasNextInt()){
                choice = sc.nextInt();
                sc.nextLine();
                if (choice < 1 && choice > things.size()){
                    continue;
                }
                break;
            } else {
                sc.nextLine();
            }
        }
        things.remove(choice - 1);
    }

    //информация о вещи
    void info() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID вещи, которую хотите посмотреть");
        int choice = 0;
        while (true) {
            if (sc.hasNextInt()){
                choice = sc.nextInt();
                sc.nextLine();
                if (things.isEmpty()){
                    System.out.println("На полках нет вещей");
                    break;
                }
                else if (choice < 1 && choice > things.size()){
                    continue;
                }
                break;
            } else {
                sc.nextLine();
            }
        }
        System.out.println(things.get(choice - 1).toString());;
    }

    //вывести список содержимого шкафа
    void print() {
        System.out.println("Список вещей на полке:");
        if (things.isEmpty()){
            System.out.println("На полках нет вещей");
        }
        for (Thing o : things) {
            System.out.println(o);
        }
    }

    //показать только книги
    void showBook() {
        books.showBooks();
    }

    //показать только одежду
    void showClothes() {
        clothesList.showClothes();
    }

    //показать только магниты
    void showMagnet() {
        magnets.showMagnets();
    }

    //поиск
    void search(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Что будем искать?");
        System.out.println("1. Книги");
        System.out.println("2. Одежду");
        System.out.println("3. Магниты");
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
        switch (choice){
            case 1:
                System.out.println("Поиск книг");
                books.searchBook();
                break;
            case 2:
                System.out.println("Поиск одежды");
                clothesList.searchClothes();
                break;
            case 3:
                System.out.println("Поиск магнитов");
                magnets.searchMagnet();
                break;
        }
    }

//    //поиск по книгам
//    void searchBook(ArrayList<Book> onlyBooks) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("По какому критерию?");
//        System.out.println("1. По названию книги");
//        System.out.println("2. По имени автора");
//        System.out.println("3. По ISBN");
//        int choice = 0;
//        while (true) {
//            if (sc.hasNextInt()) {
//                choice = sc.nextInt();
//                if (choice < 1 && choice > 3) {
//                    continue;
//                }
//                break;
//            } else {
//                sc.nextLine();
//            }
//        }
//        switch (choice) {
//            case 1:
//                System.out.println("Поиск по названию книги");
//                searchForName(onlyBooks);
//                break;
//            case 2:
//                System.out.println("Поиск по имени автора");
//                searchForAuthor(onlyBooks);
//                break;
//            case 3:
//                System.out.println("Поиск по ISBN");
//                searchForIsbn(onlyBooks); //поиск по ИСБН
//                break;
//        }
//    }
//
//    //поиск книг по названию
//    void searchForName(ArrayList<Book> books) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Введите название книги");
//        String searchName = null;
//        while (sc.hasNext()){
//            searchName = sc.nextLine();
//            if (searchName.isEmpty() && isNumber(searchName))
//            {
//                continue;
//            }
//            else {
//                break;
//            }
//        }
//        for (Book book : books) {
//            if (book.getName().toLowerCase().contains(searchName.toLowerCase())){
//                System.out.println(book.toString());
//            }
//        }
//    }
//
//    //поиск книг по имени автора
//    void searchForAuthor(ArrayList<Book> books){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Введите имя автора");
//        String searchAuthor = null;
//        while (sc.hasNext()){
//            searchAuthor = sc.nextLine();
//            if (searchAuthor.isEmpty() && isNumber(searchAuthor))
//            {
//                continue;
//            }
//            else {
//                break;
//            }
//        }
//        for (Book book : books) {
//            if (book.getAuthor().toLowerCase().contains(searchAuthor.toLowerCase())){
//                System.out.println(book.toString());
//            }
//        }
//    }
//
//    //поиск книг по ISBN (тут еще под вопросом, потому что этот код лучше выражать строкой, а не числом)
//    void searchForIsbn(ArrayList<Book> onlyBooks) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Введите ISBN");
//        int isbn = 0;
//        while (sc.hasNext()){
//            isbn = sc.nextInt();
//            if (isbn < 0)
//            {
//                continue;
//            }
//            else {
//                sc.nextLine();
//                break;
//            }
//        }
//        for (Book book : onlyBooks) {
//            if (book.getIsbn() == isbn){
//                System.out.println(book.toString());
//            }
//        }
//    }

    int input(int numberOfOptions){ //принимаемый аргумент - количество возможных вариантов выбора действий
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (true) {
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                if (choice < 1 && choice > numberOfOptions) {
                    continue;
                }
                break;
            } else {
                sc.nextLine();
            }
        }
        return choice;
    }
/*
    TODO
    вспомогательный метод для сравнения строк
    */
//boolean isNumber(String str){
//        for (int i = 0; i < str.length(); i++) {
//            if (Character.isDigit(str.charAt(i))) return false;
//        }
//        return true;
//    }
}
