package cpsc2150.extendedConnectX.models;
/**
 * @author Arpeet Naik
 * @version 1.0
 */

import java.util.Scanner;


public class GameScreen {

    private static IGameBoard board;
    private static char turn;

    public static final int ROW = 6;
    public static final int COLUMN = 9;
    public static final int NUM_TO_WIN = 5;

    private void changeTurn(){
        if(turn == 'X') turn = 'O';
        else turn = 'X';
    }
    /**
     * @description Main class for the blank gamescreen
     *
     * @pre [control the game with Player 1 and Player 2]
     *
     * @post [end of Game]
     *
     *
     */

    private int playerChoice(Scanner input){
        int var;
        var = input.nextInt();

        while(var < 0 || var >= COLUMN || !board.checkIfFree(var)){
            if(var < 0) System.out.println("Column cannot be less than 0");
            else  if (var >= COLUMN) System.out.println("Column cannot be greater than " + COLUMN);
            else System.out.println("Column is full");

            System.out.println("Player " + turn + ", what column do you want to place your marker in?");
            var = input.nextInt();
        }
        return var;
    }


    private void newGame() {
        turn = 'X';
        board = new GameBoard();
    }
        public static void main (String[] args){


            turn = 'X';
            board = new GameBoard();
            GameScreen screen = new GameScreen();
            Scanner scan = new Scanner(System.in);
            int choice;
            boolean keepPlaying = true;

            System.out.println(board.toString());

            while (keepPlaying) {
                System.out.println("Player " + turn +
                        ", what column do you want to place your marker in?");
                choice = screen.playerChoice(scan);
                board.placeToken(turn, choice);
                System.out.println(board.toString());

                if (board.checkTie()) {
                    System.out.println("You have Tied!");
                    System.out.println("Would you like to play again? Y/N");
                    char again = scan.next().charAt(0);
                    while (again != 'Y' && again != 'y' && again != 'N' && again != 'n') {
                        System.out.println("Would you like to play again? Y/N");
                        again = scan.next().charAt(0);
                    }
                    if (again == 'N' || again == 'n') keepPlaying = false;
                    else {
                        screen.newGame();
                        System.out.println(board.toString());
                        continue;
                    }
                }


                if (board.checkForWin(choice)) {
                    System.out.println("Player " + turn + " Won!");
                    System.out.println("Would you like to play again? Y/N");
                    char again = scan.next().charAt(0);
                    while (again != 'Y' && again != 'y' && again != 'N' && again != 'n') {
                        System.out.println("Would you like to play again? Y/N");
                        again = scan.next().charAt(0);
                    }
                    if (again == 'N' || again == 'n') keepPlaying = false;
                    else {
                        screen.newGame();
                        System.out.println(board.toString());
                        continue;
                    }
                }


                screen.changeTurn();

            }
        }
    }









