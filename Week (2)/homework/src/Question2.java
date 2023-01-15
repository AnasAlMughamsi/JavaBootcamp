import java.util.*;

public class Question2 {

    static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    static ArrayList<Integer> computerPosition = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] gameBoard;

        char [][] board = {
                {' ','|',' ','|', ' '},
                {'-','+','-','+', '-'},
                {' ','|',' ','|', ' '},
                {'-','+','-','+', '-'},
                {' ','|',' ','|', ' '}
        };

        printBoard(board);
        // computer player randomly
        // ** computer ** //

        while (true) {
            System.out.println("Player - enter an placement [1-9]: ");
            int playerPos = input.nextInt();

            // need to check if the place is available or not

            while (playerPosition.contains(playerPos) || computerPosition.contains(playerPos)) {
                System.out.println("Position already taken, try again: ");
                playerPos = input.nextInt();
            }

            placePieces(board, playerPos, "Player");
            String winner = checkWinner();
            if(winner.length() > 0 ) {
                System.out.println(winner);
                printBoard(board);
                break;
            }
            Random random = new Random();
            int computerInput = random.nextInt(9) + 1;
            while (playerPosition.contains(computerInput) || computerPosition.contains(computerInput)) {
                computerInput = random.nextInt(9) + 1;
            }

            placePieces(board, computerInput, "Computer");
            printBoard(board);

            winner = checkWinner();
            if(winner.length() > 0 ) {
                System.out.println(winner);
                break;
            }

        }
    }

    public static void printBoard(char[][] board) {
        for(char[] row : board) {
            for(char place: row) {
                System.out.print(place);
            }
            System.out.println();
        }
    }
    public static void placePieces(char[][] board, int position, String player) {
        char symbol = ' ';
        if(player.equals("Player")) {
            symbol = 'X';
            playerPosition.add(position);
        } else if(player.equals("Computer")) {
            symbol = 'O';
            computerPosition.add(position);
        }
        switch (position) {
            case 1 -> board[0][0] = symbol;
            case 2 -> board[0][2] = symbol;
            case 3 -> board[0][4] = symbol;
            case 4 -> board[2][0] = symbol;
            case 5 -> board[2][2] = symbol;
            case 6 -> board[2][4] = symbol;
            case 7 -> board[4][0] = symbol;
            case 8 -> board[4][2] = symbol;
            case 9 -> board[4][4] = symbol;
        }
    }

    // check the winner

    public static String checkWinner() {
        List<Integer> topRow = Arrays.asList(1,2,3);
        List<Integer> midRow = Arrays.asList(4,5,6);
        List<Integer> bottomRow = Arrays.asList(7,8,9);
        List<Integer> leftColumn = Arrays.asList(1,4,7);
        List<Integer> midColumn = Arrays.asList(2,5,8);
        List<Integer> rightColumn = Arrays.asList(3,6,9);
        List<Integer> crossOne = Arrays.asList(1,5,9);
        List<Integer> crossTwo = Arrays.asList(3,5,7);

        List<List> winning = new ArrayList<List>();

        winning.add(topRow);
        winning.add(midRow);
        winning.add(bottomRow);
        winning.add(rightColumn);
        winning.add(leftColumn);
        winning.add(midColumn);
        winning.add(crossOne);
        winning.add(crossTwo);

        for (List win: winning) {
            if(playerPosition.containsAll(win)) {
                return "Player Win!";
            } else if(computerPosition.containsAll(win)) {
                return "Computer Win";
            } else if (playerPosition.size() + computerPosition.size() == 9) {
                return "Draw";
            }
        }
        return "";
    }

}