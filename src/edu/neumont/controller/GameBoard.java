package edu.neumont.controller;

import edu.neumont.Console;

public class GameBoard {

    public static final char OPEN_SYMBOL = ' ';
    private final char[][] board;
    private final int rowSize;
    private final int columnSize;

    public GameBoard(int columnSize, int rowSize) {
        this.rowSize = rowSize;
        this.columnSize = columnSize;

        board = new char[rowSize][columnSize];
    }

    public char[][] getBoard() {
        return board;
    }

    public int getRowSize() {
        return rowSize;
    }

    public int getColumnSize() {
        return columnSize;
    }


    public int count(char symbol) {
        int count = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < columnSize; col++) {
                if (board[row][col] == symbol) count++;
            }
        }
        return count;
    }

    public void print() {
        System.out.println();
        System.out.println("         1   2   3   4   5   6");
        System.out.print("     -----------------------------");
        System.out.println();
        for (int row = 0; row < rowSize; row++) {
            System.out.print("       | ");
            for (int col = 0; col < columnSize; col++) {
                System.out.print(board[row][col]);
                if (col < columnSize - 1) Console.print(" | ", Console.BLUE);
            }
            System.out.println();
            System.out.print("     -----------------------------");
            System.out.println();
        }
        System.out.println();
    }

    public void reset() {
        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < columnSize; col++) {
                board[row][col] = OPEN_SYMBOL;
            }
        }
    }

    public boolean placeSymbol(int col, char symbol) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][col - 1] == OPEN_SYMBOL) {
                board[i][col - 1] = symbol;
                return true;
            }
        }
        return false;
    }

    public boolean checkDirection(char symbol, int columnStart, int rowStart, int columnDirection, int rowDirection, int length) {
        int count = 0;

        for (int row = rowStart, col = columnStart; row >= 0 && row < rowSize & col >= 0 && col < columnSize; row += rowDirection, col += columnDirection) {
            if (board[row][col] == symbol) count++;
            else count = 0;

            if (count == length) return true;
        }
        return false;
    }

    public boolean checkWinner(char symbol, int length) {
        for (int col = 0; col < columnSize; col++) {
            for (int row = 0; row < rowSize; row++) {
                if(checkDirection(symbol, col, row, 1, 0, length)) return true;
                if(checkDirection(symbol, col, row, 0, 1, length)) return true;
                if(checkDirection(symbol, col, row, 1, 1, length)) return true;
                if(checkDirection(symbol, col, row, -1, 1, length)) return true;
                if(checkDirection(symbol, col, row, 1, -1, length)) return true;
                if(checkDirection(symbol, col, row, -1, -1, length)) return true;

            }
        }
        return false;
    }
}
