package bookpack;

class Book {
    protected String title;
    protected String author;
    protected int pubDate;

    public Book(String t, String a, int d) {
        title = t;
        author = a;
        pubDate = d;
    }

    void show() {
        System.out.println(title);
        System.out.println(author);
        System.out.println(pubDate);
        System.out.println();
    }
}

public class BookDemo {
    public static void main(String[] args) {
        Book books[] = new Book[5];

        books[0] = new Book("Java. Przewodnik dla początkujących", "Schildt", 2019);
        books[1] = new Book("Java. Kompendium programisty", "Schildt", 2019);
        books[2] = new Book("Introducing JavaFX 8 Programming", "Schildt", 2015);
        books[3] = new Book("Stan zagrożenia", "Clancy", 2003);
        books[4] = new Book("Ogniem i mieczem", "Sienkiewicz", 1995);

        for(int i = 0; i < books.length; i++) books[i].show();
    }
}
