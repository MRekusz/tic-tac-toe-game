import java.util.Scanner;

public class TicTacToe {
    public TicTacToe() {
    }

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        char playerSymbol = 'X';
        boolean nextPlay = true;
        int movesCounter = 0;

        while (nextPlay && movesCounter <= 9) {
            boardPrinter (board);
            boolean correctMove = makeAMove (board, (char) playerSymbol);
            if (correctMove) {
                ++movesCounter;
                boolean checkRows = checkRows (board, (char) playerSymbol);
                boolean checkTheCol = checkTheCol (board, (char) playerSymbol);
                boolean diagonalWin = checkAxis (board, (char) playerSymbol);
                boolean diagonalWin2 = checkAxis2 (board, (char) playerSymbol);
                if (checkRows || checkTheCol || diagonalWin || diagonalWin2) {
                    System.out.println ("Gracz " + playerSymbol + " wygrał");
                    nextPlay = false;
                }

                playerSymbol = playerSymbol == 'X' ? 'O' : 'X';
            }
        }

    }

    public static boolean checkRows(char[][] board, char playerSymbol) {
        int size = board.length;

        for (int row = 0; row < size; ++row) {
            boolean isWin = true;

            for (int col = 0; col < size; ++col) {
                if (board[row][col] != playerSymbol) {
                    isWin = false;
                    break;
                }
            }

            if (isWin) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkTheCol(char[][] board, char playerSymbol) {
        int size = board.length;

        for (int col = 0; col < size; ++col) {
            boolean isWin = true;

            for (int row = 0; row < size; ++row) {
                if (board[row][col] != playerSymbol) {
                    isWin = false;
                    break;
                }
            }

            if (isWin) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkAxis(char[][] board, char playerSymbol) {
        int size = board.length;

        for (int i = 0; i < size; ++i) {
            if (board[i][i] != playerSymbol) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkAxis2(char[][] board, char playerSymbol) {
        int size = board.length;

        for (int i = 0; i < size; ++i) {
            if (board[i][board.length - i - 1] != playerSymbol) {
                return false;
            }
        }

        return true;
    }

    public static boolean makeAMove(char[][] board, char playerSymbol) {
        System.out.println (playerSymbol + " Twój ruch");
        System.out.println ("Podaj numer wiersza");
        int row = (new Scanner (System.in)).nextInt ();
        System.out.println ("Podaj numer kolumny");
        int col = (new Scanner (System.in)).nextInt ();
        boolean correctMove = board[row][col] != 0;
        if (correctMove) {
            System.out.println ("Ruch niepoprawny");
            return false;
        } else {
            board[row][col] = playerSymbol;
            return true;
        }
    }

    public static void boardPrinter(char[][] board) {
        int size = board.length;
        System.out.println ("\t");

        int row;
        for (row = 0; row < size; ++row) {
            System.out.print ("\t\t" + row);
        }

        System.out.println ();

        for (row = 0; row < size; ++row) {
            System.out.println ("\n\n");
            System.out.print (row + " ");

            for (int col = 0; col < size; ++col) {
                System.out.print ("\t\t" + board[row][col]);
            }
        }

        System.out.println ();
    }
}
