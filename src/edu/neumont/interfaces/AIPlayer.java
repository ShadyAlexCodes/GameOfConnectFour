package edu.neumont.interfaces;

import edu.neumont.Console;
import edu.neumont.controller.GameBoard;

import java.util.Random;

public class AIPlayer extends Player{
    public AIPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public void takeTurn(GameBoard gameBoard) {
        boolean open = false;
        while (!open) {
            int col = new Random().nextInt(1, gameBoard.getColumnSize() - 1);
            int row = new Random().nextInt(1, gameBoard.getRowSize() + 1);

            if(gameBoard.placeSymbol(col, getSymbol())) {

                try {
                    open = true;
                    Console.println(getName() + " has taken a turn!", Console.GREEN);
                    Thread.sleep(1000);
                } catch(InterruptedException ex) {
                    System.out.println("Error!");
                }
            } else {
                try {
                    Console.setColor(Console.RED);
                    System.out.println("Location is not open");
                    Console.setColor(Console.RESET);
                    gameBoard.print();
                    Thread.sleep(2000);
                } catch(InterruptedException ex) {
                    System.out.println("Error!");
                }

            }
        }
    }
}
