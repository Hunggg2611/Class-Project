package minesweeper.view;

import java.util.Scanner;

import minesweeper.model.exception.MineCountException;
import minesweeper.model.exception.MoveLocationException;
import minesweeper.model.location.Location;
import minesweeper.model.main.Minesweeper;

public class CLI {
    
    public static void main(String[] args) throws MineCountException, MoveLocationException { 

        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter rows, columns, and number of mines: "); 
        int rows = scanner.nextInt(); 
        int cols = scanner.nextInt(); 
        int mines = scanner.nextInt(); 
        Minesweeper game = new Minesweeper(rows, cols, mines); 
        game.start();

        System.out.println(game); 
        // game.makeSelection(new Location(4, 4));
        // scanner.close();  
        while(true) {
            System.out.println("Enter a command: ");
            String cmd = scanner.next();
            if(cmd.equals("help")) { 
                System.out.println("help: displays valid commands" + 
                                        "\npick row col: uncovers square at selected location" + 
                                        "\nhint: displays a list of available moves" + 
                                        "\nreset: ends the current game, and starts a new one with the same board size and number of mines" + 
                                        "\nquit: ends the current game"); 
            } 
            else if (cmd.equals("pick")){ 
                // scanner.next(); 
                game.makeSelection(new Location(scanner.nextInt(), scanner.nextInt()));
                System.out.println(game); 
            }
            else if (cmd.equals("hint")) { 
                //System.out.println(game.getPossibleSelections()); 
                for(Location loc : game.getPossibleSelections()) { 
                    System.out.println(loc); 
                }
                System.out.println(game); 
            }
            else if (cmd.equals("reset")) { 
                Minesweeper newGame = new Minesweeper(rows, cols, mines); 
                game = newGame; 
                System.out.println(game); 
            }
            else if(cmd.equals("quit")){
                System.out.println(game); 
                System.out.println("game over"); 
                scanner.close(); 
                break;}
                System.out.println(game);
        }
    }
}