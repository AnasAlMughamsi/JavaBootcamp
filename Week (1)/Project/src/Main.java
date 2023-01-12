import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("-|-|-");
        System.out.println("-|-|-");
        System.out.println("-|-|-");

        Random random = new Random();
        int computerInput = random.nextInt(9);
        System.out.println("computer input: " + computerInput);
        Scanner input = new Scanner(System.in);
        int playerInput = input.nextInt();
        int[][] square = {{2,6,5,9},{20,40,10,30}};
//        System.out.println(Arrays.toString(square));
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                System.out.print(square[i][j] + ", ");
            }
        }

        // I need a player to enter an input
        // computer player randomly
        // need to check if the place is available or not
        // check the winner

    }
}