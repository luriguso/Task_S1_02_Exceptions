package level_3.excercise_1.classData;

import level_3.excercise_1.classManagement.CinemaManagement;
import level_3.excercise_1.classManagement.SeatManagement;

import java.util.Scanner;

public class Cinema {
    private int rows_number;
    private int seat_number_row;
    private CinemaManagement cinemaManagement;
    private SeatManagement seatManagement;

    public Cinema() {
        this.cinemaManagement = new CinemaManagement(this);
        this.seatManagement = new SeatManagement();
        this.requestInitialData();
        this.show_menu();
    }

    public int getRows_number() {
        return rows_number;
    }

    public int getSeat_number_row() {
        return seat_number_row;
    }

    public SeatManagement getSeatManagement() {
        return seatManagement;
    }

    private void requestInitialData(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter rows number: ");
            int rows_number = sc.nextInt();
            sc.nextLine();
            if(rows_number > 0){
                this.rows_number = rows_number;
                break;
            }else {
                System.out.println("Invalid rows number");
            }
        }
        while(true){
            System.out.print("Enter seat number: ");
            int seat_number_row = sc.nextInt();
            sc.nextLine();
            if(seat_number_row > 0){
                this.seat_number_row = seat_number_row;
                break;
            }else {
                System.out.println("Invalid seat number");
            }
        }
    }

    public void show_menu(){
        Scanner sc = new Scanner(System.in);
        boolean process = true;
        while(process){
            this.cinemaManagement.menu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1: cinemaManagement.show_seats();
                break;
                case 2: cinemaManagement.show_seats_person(sc);
                break;
                case 3: cinemaManagement.reserve_seat(sc);
                break;
                case 4: cinemaManagement.cancel_reservation(sc);
                break;
                case 5: cinemaManagement.cancel_reservation_person(sc);
                break;
                case 6: process = false;
                break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
