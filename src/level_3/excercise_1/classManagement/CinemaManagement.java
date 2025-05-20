package level_3.excercise_1.classManagement;

import level_3.excercise_1.classData.Cinema;
import level_3.excercise_1.classData.Seat;
import level_3.excercise_1.exceptions.*;

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

    public void show_seats(){
        System.out.println("--------Reserved seats-------");
        SeatManagement seatMan = cinema.getSeatManagement();
        for (Seat seat : seatMan.getSeats()) {
            System.out.println(seat.toString());
        }
    }

    public  void show_seats_person(Scanner scanner){
        System.out.println("Enter person's name: ");
        String name = scanner.nextLine();
        SeatManagement seatMan = cinema.getSeatManagement();
        for (Seat seat : seatMan.getSeats()) {
            if (seat.getReservation_name().equals(name)) {
                System.out.println(seat.toString());
            }
        }
    }

    public void reserve_seat(Scanner scanner){
        int row_number = enterRow(scanner);
        int seat_number =  enterSeat(scanner);
        String reserved_seat = enterPerson(scanner);
        Seat seat = new Seat(row_number, seat_number, reserved_seat);

        try {
            cinema.getSeatManagement().addSeat(seat);
        }catch (Exception_Seat_Occupied e){
            System.out.println(e.getMessage());
        }
    }

    public void cancel_reservation(Scanner scanner){
        int row_number = enterRow(scanner);
        int seat_number = enterSeat(scanner);

        try{
            cinema.getSeatManagement().removeSeat(row_number, seat_number);
        }catch (Exception_Free_Seat e){
            System.out.println(e.getMessage());
        }
    }

    public void cancel_reservation_person(Scanner scanner){
        String reserved_seat = enterPerson(scanner);
        ArrayList<Seat> seats_to_remove = new ArrayList<>();
        for(Seat seat : cinema.getSeatManagement().getSeats()) {
            if(seat.getReservation_name().equals(reserved_seat)){
                  seats_to_remove.add(seat);
            }
        }

        if (seats_to_remove.isEmpty()){
            System.out.println("the person d'ont have a seats");
        }else  {
            for (Seat seat : seats_to_remove) {
                try {
                    cinema.getSeatManagement().removeSeat(seat.getRow_number(), seat.getSeat_number());
                }catch (Exception_Free_Seat e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    public int enterRow(Scanner scanner) throws Bad_Row{
        int row_number;
        while (true) {
            try {
                System.out.println("Enter row number: ");
                int input_row_number = scanner.nextInt();
                scanner.nextLine();
                if(input_row_number > 0 && input_row_number <= cinema.getRows_number()){
                    row_number =  input_row_number;
                    break;
                }else {
                    throw new Bad_Row("Invalid row number, row must be between 1 - " +  cinema.getRows_number());
                }
            }catch (Bad_Row e) {
                System.out.println("Error. " +  e.getMessage());
            }
        }
        return row_number;
    }
    public int enterSeat(Scanner scanner) throws Bad_Seat_Number {
        int seat_number;
        while (true) {
            try {
                System.out.println("Enter seat number: ");
                int input_seat_number = scanner.nextInt();
                scanner.nextLine();
                if(input_seat_number > 0 && input_seat_number <= cinema.getSeat_number_row()){
                    seat_number =  input_seat_number;
                    break;
                }else {
                    throw new Bad_Seat_Number("Invalid seat number, row must be between 1 - " +  cinema.getRows_number());
                }
            }catch (Bad_Seat_Number e) {
                System.out.println("Error. " +  e.getMessage());
            }
        }
        return seat_number;
    }

    public String enterPerson(Scanner scanner) throws Bad_Person{
        String person;
        while (true) {
            try {
                System.out.println("Enter person's name: ");
                String name = scanner.nextLine();
                if(name.length()>1){
                    person = name;
                    break;
                }else {
                    throw new Bad_Person("Invalid person's name, please enter a valid name.");
                }
            }catch (Bad_Person e) {
                System.out.println("Error. " +  e.getMessage());
            }
        }
        return person;
    }
}
