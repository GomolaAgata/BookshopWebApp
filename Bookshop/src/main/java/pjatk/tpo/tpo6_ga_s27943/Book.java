package pjatk.tpo.tpo6_ga_s27943;

public class Book {
    private String author;
    private int item;
    private String title;

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", item='" + item + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }

    private String publisher;
    private Double price;
    private int date;
    private int pages;

    public Book(String title, String author,String publisher, Double price, int pages, int date) {
        this.author = author;
        this.pages = pages;
        this.title = title;
        this.publisher = publisher;
        this.price = price;
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getPrice() {
        return price;
    }


    public int getDate() {
        return date;
    }

    public int getPages() {
        return pages;
    }
}
