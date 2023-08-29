package cpsc2150.extendedConnectX.models;


/**
 * This class is used to store information about the gameboard itself
 *
 * @author Arpeet Naik
 * @version 1.0
 * @Correspondence Board[o..MaxRow][0..MaxColumn]
 * self = Board
 * @invariant Player1 == 'X' AND Player 2 == 'O' AND [no gaps between tokens on GameBoard]
 */

    public class GameBoard extends AbsGameBoard implements IGameBoard{

        private static char [][] Board;


        /**
         *This constructor creates the 6 x 9 Board used for the game
         *
         * @pre none
         *
         * @post creates a string of characters to form a 6 x 9 Board AND <row><column> == ' '
         */

        public GameBoard() {
            Board = new char [ROW][COLUMN];
            for(int i = 0;i < ROW; i++){
                for(int j = 0; j < COLUMN; j++)
                    Board[i][j] = ' ';

            }
        }

        /**
         * This method places the token in the lowest available row in each column
         *
         * @param p - the character that takes up the spot
         * @param c - the column we would like to place the token in
         * @return none
         * @pre check checkIfFree(c) AND LOWEST_COLUMN <= c < COLUMN
         * @post ([i][j] Board = = ' X ' OR ' O ') AND token is placed in the lowest row num that == ' '
         */

        public void placeToken(char p, int c) {
            int i;
            for(i = 0; i < ROW; i++)
                if(Board[i][c] == (' '))
                    break;
                    Board[i][c] = p;

        }

        /**
         * This method checks if position on board has a marker or blank space char
         *
         * @param pos - position of the token on the board
         * @return what is at position AND iff no marker than blank space char
         * @pre [pos is within the valid bounds]
         * @post [iff pos == 'X' OR 'O' space is occupied] AND
         * [iff pos == ' ' space is open for token placement]
         */

        public char whatsAtPos(BoardPosition pos) {
            int row = pos.getRow();
            int col = pos.getColumn();
            return Board[row][col];
        }


    /**
     * @return number of rows
     * @description returns the number of rows on the GameBoard
     * @pre none
     * @post gets number of rows
     * row = #row AND getNumRows = ROW
     */

    public int getNumRows(){

        return ROW;
    }

    /**
     * @return number of columns
     * @description returns the number of columns on the GameBoard
     * @pre none
     * @post gets number of columns
     * column = #column AND getNumColumns = COLUMN
     */
    public int getNumColumns(){

        return COLUMN;
    }

    /**
     * @return number of tokens in a row needed to win the game
     * @description returns the number of tokens needed to win the game
     * @pre none
     * @post gets number of tokens to win the game
     *  getNumToWin = NUM_TO_WIN
     */
    public int getNumToWin(){

        return NUM_TO_WIN;
    }
}