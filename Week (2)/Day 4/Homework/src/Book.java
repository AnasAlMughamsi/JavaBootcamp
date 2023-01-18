public class Book extends Product {

    private String author;

    public Book() {

    }

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }


    @Override
    public double getDiscount() {
        double discount = 0.25;
        return getPrice() * discount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
