package bookpackext;

import bookpack.Book;

class ExtBook extends bookpack.Book {
    private String publisher;

    public ExtBook(String t, String a, int d, String p) {
        super(t, a, d);
        publisher = p;
    }

    public void show() {
        super.show();
        System.out.println(publisher);
        System.out.println();
    }

    public String getPublisher() { return publisher;}
    public void setPublisher(String p) { publisher = p;}

    public String getTitle() { return title;}
    public void setTitle(String t) { title =  t;}
    public String getAuthor() { return author;}
    public int getPubDate() { return pubDate;}
    public void setPubDate(int d) { pubDate = d;}
}

public class ProtectedDemo {
    public static void main(String[] args) {
        ExtBook books[] = new ExtBook[5];

        books[0] = new ExtBook("Java. Przewodnik dla początkujących", "Schildt", 2019, "Helion");
        books[1] = new ExtBook("Java. Kompendium programisty", "Schildt", 2019, "Helion");
        books[2] = new ExtBook("Introducing JavaFX 8 Programming", "Schildt", 2015, "Oracle Press");
        books[3] = new ExtBook("Stan zagrożenia", "Clancy", 2003, "Amber");
        books[4] = new ExtBook("Ogniem i mieczem", "Sienkiewicz", 1995, "PIW");

        for(int i = 0; i < books.length; i++) books[i].show();

        System.out.println("Wszystkie tytuły, których autorem jest Schildt:");
        for(int i = 0; i < books.length; i++) {
            if(books[i].getAuthor() == "Schildt")
                System.out.println(books[i].getTitle());
        }
    }
}
