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

        try {
            while (true) {
                int playerPos;

//                while (playerPosition.contains(playerPos) || computerPosition.contains(playerPos)) {
//                    System.out.println("Position already taken, try again: ");
//                    playerPos = input.nextInt();
//                }
                try {
                    playerMove(board, input);
                } catch (Exception e) {
                    System.out.println("ERROR !!");
                }
                printBoard(board);
                String winner = checkWinner();
                if(winner.length() > 0 ) {
                    System.out.println(winner);
                    break;
                }

                try {
                    setComputerPosition(board);
                } catch (Exception e) {
                    System.out.println("ERROR !!");
                }
//
//                Random random = new Random();
//                int computerInput = random.nextInt(9) + 1;
//                while (playerPosition.contains(computerInput) || computerPosition.contains(computerInput)) {
//                    computerInput = random.nextInt(9) + 1;
//                }
//
//                placePieces(board, computerInput, "Computer");
//                System.out.println("Computer play at: " + computerInput);
//                printBoard(board);

                winner = checkWinner();
                if(winner.length() > 0 ) {
                    System.out.println(winner);
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter only numbers: ");
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

    public static void setComputerPosition(char[][] board) throws Exception {
        Random random = new Random();
        int computerInput;
        while (true) {
            computerInput = random.nextInt(9) + 1;
            if(isValidMove(board, computerInput)) {
                break;
            }
        }
        placePieces(board, computerInput, "Computer");
        System.out.println("Computer play at: " + computerInput);
        printBoard(board);
    }

    public static void playerMove(char[][] board, Scanner playerInput) throws Exception {
        int playerPos;
        while (true) {
            System.out.println("Where would you like to play? (1-9): ");
            playerPos = playerInput.nextInt();
            if(isValidMove(board, playerPos)) {
                break;
            } else {
                System.out.println("place is not valid move!");
            }
        }
        placePieces(board, playerPos, "Player");
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

    private static boolean isValidMove (char[][] board, int position) throws Exception {
        return switch (position) {
            case 1 -> (board[0][0] == ' ');
            case 2 -> (board[0][2] == ' ');
            case 3 -> (board[0][4] == ' ');
            case 4 -> (board[2][0] == ' ');
            case 5 -> (board[2][2] == ' ');
            case 6 -> (board[2][4] == ' ');
            case 7 -> (board[4][0] == ' ');
            case 8 -> (board[4][2] == ' ');
            case 9 -> (board[4][4] == ' ');
            default -> false;
        };
    }

}