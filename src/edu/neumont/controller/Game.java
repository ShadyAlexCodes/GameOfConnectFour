package edu.neumont.controller;

import edu.neumont.Console;
import edu.neumont.interfaces.AIPlayer;
import edu.neumont.interfaces.HumanPlayer;
import edu.neumont.interfaces.Player;

import java.util.ArrayList;

public class Game {

    private final GameBoard gameBoard;
    private final int winLength;
    private final ArrayList<Player> players = new ArrayList<>();
    private int turn;
    public Game(int columns, int rows, int winLength) {
        gameBoard = new GameBoard(columns, rows);
        this.winLength = winLength;
    }

    public void run() {
        boolean quit = false;

        while (!quit) {

            System.out.println("          CONNECT FOUR");
            System.out.println("  -----------------------------");
            System.out.println("       Choose a game type!");
            System.out.println("  1. Player versus Player (PVP)");
            System.out.println("  2. Player versus Computer (PVC)");
            System.out.println("  3. Computer versus Computer (CVC)");
            System.out.println("  4. Exit Game");
            System.out.println("  -----------------------------");
            int selection = Console.getInteger("Enter your game type: ", 1, 4);

            switch (selection) {
                case 1:
                    startGame(GameType.PVP);
                    break;
                case 2:
                    startGame(GameType.PVC);
                    break;
                case 3:
                    startGame(GameType.CVC);
                    break;
                case 4:
                    quit = true;
                    break;
            }
        }
    }

    public void startGame(GameType gameType) {
        // add players
        String name;
        switch (gameType) {
            case PVP:
                name = Console.getString("Enter the first player's name: ");
                players.add(new HumanPlayer(name, 'X'));

                name = Console.getString("Enter the second player's name: ");
                players.add(new HumanPlayer(name, 'X'));
                break;
            case PVC:
                name = Console.getString("Enter a player name: ");
                players.add(new HumanPlayer(name, 'X'));

                players.add(new AIPlayer("Chris", 'O'));
                break;
            case CVC:
                players.add(new AIPlayer("Lorem", 'X'));
                players.add(new AIPlayer("Ipsum", 'O'));
                break;
        }


        // Reset Game
        turn = 0;
        gameBoard.reset();

        Player winner = null;

        boolean gameOver = false;
        while (!gameOver) {
            Player player = players.get(turn);

            gameBoard.print();

            player.takeTurn(gameBoard);

            if (gameBoard.checkWinner(player.getSymbol(), winLength)) {
                gameOver = true;
                winner = player;
            }

            if(gameBoard.count(GameBoard.OPEN_SYMBOL) == 0) gameOver = true;

            if (++turn == players.size()) turn = 0;
        }

        if (winner != null) {
            gameBoard.print();
            Console.println(winner.getName() + " is the winner!", Console.CYAN);
            players.clear();
        } else {
            Console.println("CATS GAME", Console.RED);
        }
    }

    enum GameType {
        PVP, PVC, CVC
    }
}