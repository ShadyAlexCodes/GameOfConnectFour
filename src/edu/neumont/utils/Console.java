package edu.neumont;

import java.util.Scanner;

public class Console {

    public static String BLACK = "\u001B[30m";
    public static String RED = "\u001B[31m";
    public static String GREEN = "\u001B[32m";
    public static String YELLOW = "\u001B[33m";
    public static String BLUE = "\u001B[34m";
    public static String PURPLE = "\u001B[35m";
    public static String CYAN = "\u001B[36m";
    public static String WHITE = "\u001B[37m";

    public static String BLACK_BACKGROUND = "\u001B[40m";
    public static String RED_BACKGROUND = "\u001B[41m";
    public static String GREEN_BACKGROUND = "\u001B[42m";
    public static String YELLOW_BACKGROUND = "\u001B[43m";
    public static String BLUE_BACKGROUND = "\u001B[44m";
    public static String PURPLE_BACKGROUND = "\u001B[45m";
    public static String CYAN_BACKGROUND = "\u001B[46m";
    public static String WHITE_BACKGROUND = "\u001B[47m";

    public static String RESET = "\u001B[0m";



    static Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static int getInteger(String prompt) {
        int i = 0;

        boolean valid = false;
        while (!valid) {
            String string = getString(prompt);
            try {
                i = Integer.parseInt(string);
                valid = true;
            }
            catch (NumberFormatException ex) {
                Console.setColor(RED_BACKGROUND);
                Console.setColor(WHITE);
                System.out.println("You have entered an invalid number.");
                Console.setColor(RESET);
            }
        }

        return i;
    }

    public static int getInteger(String prompt, int min, int max) {
        int i = 0;

        boolean valid = false;
        while (!valid) {
            String string = getString(prompt);
            try {
                i = Integer.parseInt(string);
                valid = (i >= min && i <= max);
                if (!valid) {
                    Console.setColor(RED_BACKGROUND);

                    System.out.println("Entered value is not between " + min + " and " + max + ".");
                    Console.setColor(RESET);
                }
            }
            catch (NumberFormatException ex) {
                System.out.println("You have entered an invalid number.");
            }
        }

        return i;
    }


    public static float getFloat(String prompt) {
        float i = 0;

        boolean valid = false;
        while (!valid) {
            String string = getString(prompt);
            try {
                i = Float.parseFloat(string);
                valid = true;
            }
            catch (NumberFormatException ex) {
                System.out.println("You have entered an invalid number.");
            }
        }

        return i;
    }

    public static void setColor(String color) {
        System.out.print(color);
    }

    public static void print(String string, String color) {
        Console.setColor(color);
        System.out.print(string);
        Console.setColor(Console.RESET);
    }

    public static void println(String string, String color) {
        Console.setColor(color);
        System.out.println(string);
        Console.setColor(Console.RESET);
    }


}
