package level3.excercise1.classManagement;

import level3.excercise1.classData.Cinema;
import level3.excercise1.classData.Seat;
import level3.excercise1.exceptions.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CinemaManagement {
    private Cinema cinema;

    public CinemaManagement(Cinema cinema) {
        this.cinema = cinema;
    }

    public void menu(){
        System.out.println("-----------MENU-----------");
        System.out.println("1. Show all reserved seats.");
        System.out.println("2. Show seats reserved by one person.");
        System.out.println("3. Reserve a seat.");
        System.out.println("4. Cancel a seat reservation.");
        System.out.println("5. Cancel all reservations for one person.");
        System.out.println("0. Exit.");
        System.out.println("Choose an option...");
    }

    public void showSeats(){
        Scanner sc = new Scanner(System.in);
        SeatManagement seatMan = cinema.getSeatManagement();
        if(!seatMan.getSeats().isEmpty()){
            System.out.println("--------Reserved seats-------");

            for (Seat seat : seatMan.getSeats()) {
                System.out.println(seat.toString());
            }
            System.out.println("----------------------------");
            System.out.println("Press Enter to continue.");
            sc.nextLine();
        }else {
            System.out.println("There are no reservations . Press Enter to continue.");

            sc.nextLine();
        }
    }

    public  void showSeatsPerson(Scanner scanner){
        Scanner sc = new Scanner(System.in);
        SeatManagement seatMan = cinema.getSeatManagement();
        if (seatMan.getSeats().isEmpty()){
            System.out.println("There are no reservations . Press Enter to continue.");
            sc.nextLine();
            return;
        }
        System.out.println("Enter person's name: ");
        String name = scanner.nextLine();
        ArrayList<Seat> seatsToPerson = new  ArrayList<>();
        for (Seat seat : seatMan.getSeats()) {
            if (seat.getReservationName().equals(name)) {
                seatsToPerson.add(seat);
            }
        }

        if(!seatsToPerson.isEmpty()){
            System.out.println("--------Reserved seats-------");
            for (Seat seat : seatsToPerson) {
                System.out.println(seat.toString());
            }
            System.out.println("----------------------------");
            System.out.println("Press Enter to continue.");
            sc.nextLine();
        }else{
            System.out.println("There are no reservations for "+name+". Press Enter to continue.");
            sc.nextLine();
        }
    }

    public void reserveSeat(Scanner scanner){
        Scanner sc = new Scanner(System.in);
        int rowNumber = enterRow(scanner);
        int seatNumber =  enterSeat(scanner);
        String reservedSeat = enterPerson(scanner);
        Seat seat = new Seat(rowNumber, seatNumber, reservedSeat);

        try {
            cinema.getSeatManagement().addSeat(seat);
            System.out.println("Reserved seat successfully for "+reservedSeat);
            System.out.println("Press Enter to continue.");
            sc.nextLine();
        }catch (ExceptionSeatOccupied e){
            System.out.println(e.getMessage());
            System.out.println("Press Enter to continue.");
            sc.nextLine();
        }
    }

    public void cancelReservation(Scanner scanner){
        Scanner sc = new Scanner(System.in);
        if(cinema.getSeatManagement().getSeats().isEmpty()){
            System.out.println("There are no reservations . Press Enter to continue.");
            sc.nextLine();
            return;
        }
        int rowNumber = enterRow(scanner);
        int seatNumber = enterSeat(scanner);

        try{
            cinema.getSeatManagement().removeSeat(rowNumber, seatNumber);
            System.out.println("The reservation was canceled, Press Enter to continue.");;
            sc.nextLine();
        }catch (ExceptionFreeSeat e){
            System.out.println(e.getMessage());
            System.out.println("Press Enter to continue.");
            sc.nextLine();
        }
    }

    public void cancelReservationPerson(Scanner scanner){
        if(cinema.getSeatManagement().getSeats().isEmpty()){
            System.out.println("There are no reservations . Press Enter to continue.");
            scanner.nextLine();
            return;
        }
        String reservedSeat = enterPerson(scanner);
        ArrayList<Seat> seatsToRemove = new ArrayList<>();
        for(Seat seat : cinema.getSeatManagement().getSeats()) {
            if(seat.getReservationName().equals(reservedSeat)){
                  seatsToRemove.add(seat);
            }
        }

        if (seatsToRemove.isEmpty()){
            System.out.println("the person d'ont have a seats");
            System.out.println("Press Enter to continue.");
            scanner.nextLine();
        }else  {
            for (Seat seat : seatsToRemove) {
                try {
                    cinema.getSeatManagement().removeSeat(seat.getRowNumber(), seat.getSeatNumber());
                }catch (ExceptionFreeSeat e){
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("The person's reserved seats have been successfully removed.");
            System.out.println("Press Enter to continue.");
            scanner.nextLine();
        }
    }
    public int enterRow(Scanner scanner) throws BadRow {
        int rowNumber;
        while (true) {
            try {
                System.out.println("Enter row number: ");
                int inputRowNumber = scanner.nextInt();
                scanner.nextLine();
                if(inputRowNumber > 0 && inputRowNumber <= cinema.getRowsNumber()){
                    rowNumber =  inputRowNumber;
                    break;
                }else {
                    throw new BadRow("Invalid row number, row must be between 1 - " +  cinema.getRowsNumber());
                }
            }catch (BadRow e) {
                System.out.println("Error. " +  e.getMessage());
            }
        }
        return rowNumber;
    }
    public int enterSeat(Scanner scanner) throws BadSeatNumber {
        int seatNumber;
        while (true) {
            try {
                System.out.println("Enter seat number: ");
                int inputSeatNumber = scanner.nextInt();
                scanner.nextLine();
                if(inputSeatNumber > 0 && inputSeatNumber <= cinema.getSeatNumberRow()){
                    seatNumber =  inputSeatNumber;
                    break;
                }else {
                    throw new BadSeatNumber("Invalid seat number, row must be between 1 - " +  cinema.getRowsNumber());
                }
            }catch (BadSeatNumber e) {
                System.out.println("Error. " +  e.getMessage());
            }
        }
        return seatNumber;
    }

    public String enterPerson(Scanner scanner) throws BadPerson {
        String person;
        while (true) {
            try {
                System.out.println("Enter person's name: ");
                String name = scanner.nextLine();
                if(name.length()>1){
                    person = name;
                    break;
                }else {
                    throw new BadPerson("Invalid person's name, please enter a valid name.");
                }
            }catch (BadPerson e) {
                System.out.println("Error. " +  e.getMessage());
            }
        }
        return person;
    }
}
