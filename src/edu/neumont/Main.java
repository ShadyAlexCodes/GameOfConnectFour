package edu.neumont;

import edu.neumont.controller.Game;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game game = new Game(7, 6, 4);
        game.run();
    }
}
