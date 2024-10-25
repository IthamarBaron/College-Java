import java.util.Scanner;
//used a Minimax algorithem based on this video: https://www.youtube.com/watch?v=5y2a0Zhgq0U
//to play against you tic-tac-toe.


public class Main {

    //Does the computer turn using the minimax algorithem
    static void doComputerTurn(char turn, char[][] mat) {
        System.out.println("\tComputer's Turn!");
        System.out.println("===============================");
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;

        // Try each possible move and calculate its Minimax score
        for (int slot = 0; slot < 9; slot++) {
            int i = slot / 3;
            int j = slot % 3;

            if (!Character.isLetter(mat[i][j])) {
                mat[i][j] = turn;

                // Calculate the score for this move using Minimax
                int score = minimax(mat, 0, false, turn);
                // Undo the move
                mat[i][j] = (char) (slot + '0');

                if (score > bestScore) {
                    bestScore = score;
                    bestMove = slot;
                }
            }
        }

        // Make the best move
        if (bestMove != -1) {
            int i = bestMove / 3;
            int j = bestMove % 3;
            mat[i][j] = turn;
        }
    }

    // Minimax function to evaluate each possible move
    static int minimax(char[][] mat, int depth, boolean isMaximizing, char turn) {
        char result = checkWin(mat);
        if (result == 'O') {
            return 10 - depth; // Favorable outcome for the computer
        }
        if (result == 'X') {
            return depth - 10; // Favorable outcome for the user
        }
        if (result == 'E') {
            return 0; // Draw
        }

        // Computer's turn (maximizing)
        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int slot = 0; slot < 9; slot++) {
                int i = slot / 3;
                int j = slot % 3;
                if (!Character.isLetter(mat[i][j])) {
                    mat[i][j] = 'O';
                    int score = minimax(mat, depth + 1, false, turn);
                    mat[i][j] = (char) (slot + '0');
                    bestScore = Math.max(score, bestScore);
                }
            }
            return bestScore;
        }
        // User's turn (minimizing)
        else {
            int bestScore = Integer.MAX_VALUE;
            for (int slot = 0; slot < 9; slot++) {
                int i = slot / 3;
                int j = slot % 3;
                if (!Character.isLetter(mat[i][j])) {
                    mat[i][j] = 'X';
                    int score = minimax(mat, depth + 1, true, turn);
                    mat[i][j] = (char) (slot + '0');
                    bestScore = Math.min(score, bestScore);
                }
            }
            return bestScore;
        }
    }

    public static void main(String[] args) {
        char[][] mat = new char[3][3];
        char win = ' ';
        int turnCounter = 0;
        restartGame(mat);

        while (win != 'X' && win != 'O' && win != 'E') {
            drawBoard(mat);
            if (turnCounter % 2 == 0) { // User's turn
                selectMove('X', mat);
            } else { // Computer's turn
                doComputerTurn('O', mat);
            }
            win = checkWin(mat);
            turnCounter++;
        }
        declareWinner(mat, win);
    }

    static void drawBoard(char[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(" " + mat[i][j]);
                if (j < 2) {
                    System.out.print(" |");
                }
            }
            if (i < 2) {
                System.out.println("\n---+---+---");
            }
        }
        System.out.println("\n");
    }

    static char checkWin(char[][] mat) {
        char first;
        // Check rows
        for (int i = 0; i < mat.length; i++) {
            first = mat[i][0];
            int counter = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (first == mat[i][j]) {
                    counter++;
                }
                if (counter == 3) {
                    return mat[i][j];
                }
            }
        }

        // Check columns
        for (int i = 0; i < mat[0].length; i++) {
            first = mat[0][i];
            int counter = 0;
            for (int j = 0; j < mat.length; j++) {
                if (first == mat[j][i]) {
                    counter++;
                }
                if (counter == 3) {
                    return mat[j][i];
                }
            }
        }

        // Check diagonals
        int dCounter = 0;
        char dFirst = mat[0][0];
        for (int i = 0; i < mat.length; i++) {
            if (dFirst == mat[i][i]) {
                dCounter++;
            }
            if (dCounter == 3) {
                return dFirst;
            }
        }

        dCounter = 0;
        dFirst = mat[0][mat[0].length - 1];
        for (int i = 0; i < mat.length; i++) {
            if (dFirst == mat[i][mat.length - 1 - i]) {
                dCounter++;
            }
            if (dCounter == 3) {
                return dFirst;
            }
        }

        // Check for a draw or unfinished game
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (!Character.isLetter(mat[i][j])) {
                    return '0';
                }
            }
        }

        return 'E'; // Game ended in a draw
    }

    static void selectMove(char turn, char[][] mat) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\tIt's " + turn + "'s Turn!");
        System.out.println("===============================");
        int slot;
        int i, j;
        while (true) {
            System.out.print("Enter your move (0-8): ");
            slot = scanner.nextInt();
            j = slot % 3;
            i = slot / 3;

            if (slot < 0 || slot > 8 || Character.isLetter(mat[i][j])) {
                System.out.println("Invalid move, please try again...");
            } else {
                mat[i][j] = turn;
                break;
            }
        }
    }

    static void restartGame(char[][] mat) {
        char slot = '0';
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = slot;
                slot++;
            }
        }
    }

    static void declareWinner(char[][] mat, char winner) {
        System.out.println("===================================");
        if (winner != 'E') {
            System.out.println("\tWE HAVE A WINNER!");
            System.out.println("\t" + winner + " HAS WON THE GAME");
        } else {
            System.out.println("\tGAME ENDED IN A DRAW");
        }
        System.out.println("===================================");
        drawBoard(mat);
    }
}
