package level3.excercise1.classData;

import level3.excercise1.classManagement.CinemaManagement;
import level3.excercise1.classManagement.SeatManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Cinema {
    private int rowsNumber;
    private int seatNumberRow;
    private CinemaManagement cinemaManagement;
    private SeatManagement seatManagement;

    public Cinema() {
        this.cinemaManagement = new CinemaManagement(this);
        this.seatManagement = new SeatManagement();
        this.requestInitialData();
        this.showMenu();
    }

    public int getRowsNumber() {
        return rowsNumber;
    }

    public int getSeatNumberRow() {
        return seatNumberRow;
    }

    public SeatManagement getSeatManagement() {
        return seatManagement;
    }

    private void requestInitialData() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        while(true){
            try {
                System.out.print("Enter rows number: ");
                int rowsNumber = sc.nextInt();
                sc.nextLine();
                if(rowsNumber > 0){
                    this.rowsNumber = rowsNumber;
                    break;
                }else {
                    System.out.println("Invalid rows number");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid rows number");
                sc.nextLine();
            }
        }
        while(true){
            try {
                System.out.print("Enter seat number: ");
                int seatNumberRow = sc.nextInt();
                sc.nextLine();
                if(seatNumberRow > 0){
                    this.seatNumberRow = seatNumberRow;
                    break;
                }else {
                    System.out.println("Invalid seat number");
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid seat number");
            }
        }
    }

    public void showMenu(){
        Scanner sc = new Scanner(System.in);
        boolean process = true;
        while(process){
            this.cinemaManagement.menu();
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1: cinemaManagement.showSeats();
                break;
                case 2: cinemaManagement.showSeatsPerson(sc);
                break;
                case 3: cinemaManagement.reserveSeat(sc);
                break;
                case 4: cinemaManagement.cancelReservation(sc);
                break;
                case 5: cinemaManagement.cancelReservationPerson(sc);
                break;
                case 0: {
                    process = false;
                    System.out.println("Thank you for using this program.");
                }

                break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
