package level_2.exercise_1.classData;

import level_2.exercise_1.exceptions.readCharException;
import level_2.exercise_1.exceptions.readStringException;
import level_2.exercise_1.exceptions.readYesOrNotException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static byte readByte(String message, Scanner scanner) throws InputMismatchException {
        byte age = 0;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print(message);
                age = scanner.nextByte();

                flag = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid byte (-128 to 127).");
                scanner.nextLine();
            }
        }
        return  age;
    }

    public static int  readInt(String message, Scanner scanner) throws InputMismatchException {
        int number = 0;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print(message);
                number = scanner.nextInt();

                flag = true;
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }

        return number;
    }

    public static float readFloat(String message, Scanner scanner) throws InputMismatchException {
        float number = 0;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print(message);
                number = scanner.nextFloat();

                flag = true;
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number float.");
                scanner.nextLine();
            }
        }
        return number;
    }
    public static double readDouble(String message, Scanner scanner) throws InputMismatchException {
        double number = 0;
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print(message);
                number = scanner.nextDouble();

                flag = true;
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number double.");
                scanner.nextLine();
            }
        }
        return number;
    }
    public static char readChar(String message, Scanner scanner) throws readCharException {
        char character;
        boolean flag = false;
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.next();
                if (input.length() == 1) {
                    character = input.charAt(0);
                    break;
                }else {
                    throw new readCharException("Invalid input. Please enter a valid character.");
                }
            }catch (readCharException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return character;
    }
    public static String readString(String message, Scanner scanner) throws readStringException {
        String input;

        while (true) {
            try {
                System.out.print(message);
                String inputRead = scanner.next();
                if (inputRead.length() > 1) {
                    input =  inputRead;

                    break;
                }else  {
                    throw new readStringException("Invalid input. Please enter a valid string.");
                }
            }catch (readStringException e){
                System.out.println("Error: " + e.getMessage());
            }
        }

        return input;
    }

    public static boolean readYesNo(String message, Scanner scanner) throws readYesOrNotException {
        boolean flag;

        while (true) {
            try {
                System.out.print(message);
                String input = scanner.next();
                if (input.equals("Y")) {
                    flag = true;
                    break;
                } else if (input.equals("N")) {

                }else {
                    throw new readYesOrNotException("Invalid input. Please enter a valid Y or N.");
                }
            }catch (readYesOrNotException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return flag;
    }
}
