public class Movie extends Product {

    private String director;

    public Movie() {

    }

    public Movie(String name, double price, String director) {
        super(name, price);
        this.director = director;
    }

    @Override
    public double getDiscount() {
//        return 0;
        double discount = 0.35;
        return getPrice() * discount;
    }




    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
