import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<Product>();
        Book book1 = new Book();
        book1.setName("Perfume: The Story of a Murderer");
        book1.setAuthor("Patrick Suskind");
        book1.setPrice(25);

        Movie movie1 = new Movie();
        movie1.setName("There will be blood");
        movie1.setPrice(35);
        movie1.setDirector("Paul Thomas Anderson");
        products.add(movie1);
        products.add(book1);

        for(Product product: products) {
            System.out.println(product.getName() + " - " + product.getPrice() + ", discount: " + product.getDiscount());
        }

        System.out.println("========================== Interface ==========================");

        MovablePoint movablePoint = new MovablePoint(3,15, 7,21);
        System.out.print("Move right: ");
        movablePoint.moveRight();
        System.out.print("Move left: ");
        movablePoint.moveLeft();
        System.out.print("Move up: ");
        movablePoint.moveUp();
        System.out.print("Move down: ");
        movablePoint.moveDown();



    }
}