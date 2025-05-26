package level2.exercise1.classData;

import level2.exercise1.exceptions.ReadCharException;
import level2.exercise1.exceptions.ReadStringException;
import level2.exercise1.exceptions.ReadYesOrNotException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static byte readByte(String message, Scanner scanner) throws InputMismatchException {
        byte age = 0;
        while (true) {
            try {
                System.out.print(message);
                age = scanner.nextByte();
                if(age >= 0) {
                   break;
                }else{
                    System.out.println("Invalid input. Please enter a valid age.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid byte (-128 to 127).");
                scanner.nextLine();
            }
        }
        return  age;
    }

    public static int  readInt(String message, Scanner scanner) throws InputMismatchException {
        int number = 0;
        while (true) {
            try {
                System.out.print(message);
                number = scanner.nextInt();
                if(number >= 0) {
                    break;
                }else {
                    System.out.println("Invalid input. Please enter a positive number.");
                }

            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }

        return number;
    }

    public static float readFloat(String message, Scanner scanner) throws InputMismatchException {
        float number = 0;
        while (true) {
            try {
                System.out.print(message);
                number = scanner.nextFloat();
                if(number >= 0) {
                    break;
                }else {
                    System.out.println("Error: salary cannot be negative.");
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number float.");
                scanner.nextLine();
            }
        }
        return number;
    }
    public static double readDouble(String message, Scanner scanner) throws InputMismatchException {
        double number = 0;
        while (true) {
            try {
                System.out.print(message);
                number = scanner.nextDouble();

                if(number >= 0) {
                    break;
                }else {
                    System.out.println("Error: bonus cannot be negative.");
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number double.");
                scanner.nextLine();
            }
        }
        return number;
    }
    public static char readChar(String message, Scanner scanner) throws ReadCharException {
        char character;
        boolean flag = false;
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.next();
                if (input.length() == 1) {
                    character = input.charAt(0);
                    if(Character.isLetter(character)) {
                        break;
                    }else {
                        throw new ReadCharException("Error: Invalid character, entre a letter.");
                    }
                }else {
                    throw new ReadCharException("Invalid input. Please enter a valid character.");
                }
            }catch (ReadCharException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return character;
    }
    public static String readString(String message, Scanner scanner) throws ReadStringException {
        String input;

        while (true) {
            try {
                System.out.print(message);
                String inputRead = scanner.next();
                if (inputRead.length() > 1) {
                    input =  inputRead;

                    break;
                }else  {
                    throw new ReadStringException("Invalid input. Please enter a valid string.");
                }
            }catch (ReadStringException e){
                System.out.println("Error: " + e.getMessage());
            }
        }

        return input;
    }

    public static boolean readYesNo(String message, Scanner scanner) throws ReadYesOrNotException {
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
                    throw new ReadYesOrNotException("Invalid input. Please enter a valid Y or N.");
                }
            }catch (ReadYesOrNotException e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        return flag;
    }
}
