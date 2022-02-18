package edu.neumont.interfaces;

import edu.neumont.Console;
import edu.neumont.controller.GameBoard;

public class HumanPlayer extends Player{
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void takeTurn(GameBoard gameBoard) {
        boolean open = false;
        while (!open) {
            int col = Console.getInteger(getName() + " enter column: ", 1, gameBoard.getColumnSize() - 1);

            if(gameBoard.placeSymbol(col, getSymbol())) {
                open = true;
                Console.println(getName() + " has taken a turn!", Console.GREEN);
            } else {
                Console.setColor(Console.RED);
                System.out.println("Location is not open");
                Console.setColor(Console.RESET);
                gameBoard.print();
            }
        }
    }
}