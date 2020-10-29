package noughtsandcrosses;

import java.util.Arrays;

public class Main {

    private BoardState boardState;

    public enum BoardState {
        NOUGHTS_WIN, CROSSES_WIN, DRAW, IN_PROGRESS, NOT_STARTED
    }

    /**
     * Tries to find the winner via set positions, if no winner checks draw then in progress state
     * @param boardArray - the N&C board converted to an Array
     * @return boardState - enum of what state the board is in
     */
    private static BoardState checkWinner(String[] boardArray) {

        String output = "AAA";

        /*
         * There are 8 possible ways to win in N&C, this checks if there are X's or O's in each position
         * for each possible way
         */
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0 -> output = boardArray[0] + boardArray[1] + boardArray[2];
                case 1 -> output = boardArray[3] + boardArray[4] + boardArray[5];
                case 2 -> output = boardArray[6] + boardArray[7] + boardArray[8];
                case 3 -> output = boardArray[0] + boardArray[3] + boardArray[6];
                case 4 -> output = boardArray[1] + boardArray[4] + boardArray[7];
                case 5 -> output = boardArray[2] + boardArray[5] + boardArray[8];
                case 6 -> output = boardArray[0] + boardArray[4] + boardArray[8];
                case 7 -> output = boardArray[2] + boardArray[4] + boardArray[6];
            }

            if (output.equals("XXX")) {
                return BoardState.CROSSES_WIN;
            } else if (output.equals("OOO")) {
                return BoardState.NOUGHTS_WIN;
            }
        }

        // If no '_' then it must be a draw
        // I guess technically, in some situation there can be a draw sooner, but I assume it's played to the end
        if (Arrays.stream(boardArray).noneMatch("_"::equals)) {
            return BoardState.DRAW;
        }

        // If no winners and it isn't a draw, it must be in progress
        return BoardState.IN_PROGRESS;
    }

    /**
     * Checks if the game has started, if so, moves onto the checkWinner method
     * @param board - the N&C board in string format
     * @return boardState - enum of what state the board is in
     */
    private static BoardState getStateOfBoard(String board) {

        // First check to see whether the board has started
        if (board.equals("_________")) {
            return BoardState.NOT_STARTED;
        }

        // Split the string into an array, makes it easier to manipulate
        String[] boardArray = board.split("");
        return checkWinner(boardArray);
    }

    /**
     * Gives functionality to run the board outside of the class, used for testing
     * @param input - the N&C board in string format
     */
    public void runBoard(String input) {
        boardState = getStateOfBoard(input);
    }

    /**
     * Gets the state back, used for testing
     * @return boardState - enum of what state the board is in
     */
    public BoardState getState() {
        return this.boardState;
    }

    // Do not change
    public static void main(String[] args) {
        /*
         * Suggest replacing this with modern for loop eg:
         * for (String arg : args) {
         *     System.out.println(getStateOfBoard(arg));
         */
        for (int i = 0; i < args.length; i++) {
            System.out.println(getStateOfBoard(args[i]));
        }
    }
}