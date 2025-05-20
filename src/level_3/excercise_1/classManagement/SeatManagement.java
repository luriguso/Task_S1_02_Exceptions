package level_3.excercise_1.classManagement;

import level_3.excercise_1.classData.Seat;
import level_3.excercise_1.exceptions.Exception_Free_Seat;
import level_3.excercise_1.exceptions.Exception_Seat_Occupied;

import java.util.ArrayList;

public class SeatManagement {
    private ArrayList<Seat> seats;

    public SeatManagement() {
        this.seats = new ArrayList<>();
    }

    public ArrayList<Seat> getSeats() {
        return this.seats;
    }

    public void addSeat(Seat seat) throws Exception_Seat_Occupied {
        int index;
        index = search_seat(seat.getRow_number(), seat.getSeat_number());
        if (index == -1){
            this.seats.add(seat);
        }else {
            throw new Exception_Seat_Occupied("Error: Seat is already occupied");
        }
    }

    public void removeSeat(int row_number, int seat_number) throws Exception_Free_Seat {
        boolean isReserved = false;
        int index = 0;
        for (Seat s : this.seats) {
            if(Seat.equals(row_number, seat_number, s.getRow_number(), s.getSeat_number())){
                isReserved = true;
                index =  seats.indexOf(s);
            }
        }
        if(isReserved){
            this.seats.remove(index);
        }else {
            throw new Exception_Free_Seat("Error: The seat is free");
        }
    }

    public int search_seat(int row_number, int seat_number) {
        int position = -1;
        for (Seat s : this.seats) {
            if(Seat.equals(row_number, seat_number, s.getRow_number(), s.getSeat_number())){
                position = this.seats.indexOf(s);
            }
        }
        return position;
    }
}
