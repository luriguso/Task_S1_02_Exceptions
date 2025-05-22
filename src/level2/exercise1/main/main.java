package level2.exercise1.main;

import level2.exercise1.classData.Input;
import level2.exercise1.exceptions.readCharException;
import level2.exercise1.exceptions.readStringException;
import level2.exercise1.exceptions.readYesOrNotException;

import java.util.Scanner;

public class main {
    public static void main(String[] args) throws readCharException, readStringException, readYesOrNotException {
        Scanner scanner = new Scanner(System.in);

        byte age = Input.readByte("Enter your age", scanner);
        System.out.println("The age is " + age);
        System.out.println("The age is correct, bye bye...");

        int number = Input.readInt("Enter your number", scanner);
        System.out.println("The number is " + number);
        System.out.println("The number is correct, bye bye...");

        float salary = Input.readFloat("Enter your salary", scanner);
        System.out.println("The salary is " + salary);
        System.out.println("The salary is correct, bye bye...");

        double bonus = Input.readDouble("Enter your bonus", scanner);
        System.out.println("The bonus is " + bonus);
        System.out.println("The bonus is correct, bye bye...");

        char caracter = Input.readChar("enter the first letter of your name: ", scanner);
        System.out.println("The caracter is " + caracter);
        System.out.println("The caracter is correct, bye bye...");

        String name = Input.readString("Enter your favorite phrase", scanner);
        System.out.println("The phrase is " + name);
        System.out.println("The phrase is correct, bye bye...");

        boolean flag = Input.readYesNo("Entre 'Y' for true or 'S' for false", scanner);
        System.out.println("The flag is " + flag);
        System.out.println("The flag is correct, bye bye...");

    }
}
