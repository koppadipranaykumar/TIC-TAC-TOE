import java.util.*; 
public class tictactoe {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe!");
        Scanner in = new Scanner(System.in); 
        System.out.print("Enter Player 1 name: ");
        String player1 = in.nextLine();
        System.out.print("Enter Player 2 name: ");
        String player2 = in.nextLine(); 
        System.out.println(" The game started between " + player1 + " and " + player2);
        playGame(player1, player2);
    }
    public static void printBoard(char[][] board) {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
        System.out.println();

    }
    public static boolean checkWin(char[][] board, char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;
        return false;
    }
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }
    public static void playGame(String player1, String player2) {
        char[][] board = { {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };
        Scanner in = new Scanner(System.in);
        char currentSymbol = 'X';
        String currentPlayer = player1;
        while (true) {
            printBoard(board);
            System.out.print(currentPlayer + "'s turn. Enter row and column (0, 1, or 2): ");
            int row = in.nextInt();
            int col = in.nextInt();
            System.out.println();
            if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            board[row][col] = currentSymbol;
            if (checkWin(board, currentSymbol)) {
                printBoard(board);
                System.out.println(currentPlayer + " wins!");
                break;
            }
            if (isBoardFull(board)) {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }
            if (currentSymbol == 'X') {
                currentSymbol = 'O';
                currentPlayer = player2;
            } else {
                currentSymbol = 'X';
                currentPlayer = player1;
            }
        }
    }

}
