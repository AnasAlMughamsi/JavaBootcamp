import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<Animal>();

        animals.add(new Cat("Mesh"));
        animals.add(new Dog("Grey"));

        for (Animal animal: animals) {
            System.out.println(animal.getName() + " " + animal.makeSound());
        }

    }
}