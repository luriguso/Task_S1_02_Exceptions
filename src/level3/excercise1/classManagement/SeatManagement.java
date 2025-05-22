package level3.excercise1.classManagement;

import level3.excercise1.classData.Seat;
import level3.excercise1.exceptions.ExceptionFreeSeat;
import level3.excercise1.exceptions.ExceptionSeatOccupied;

import java.util.ArrayList;

public class SeatManagement {
    private ArrayList<Seat> seats;

    public SeatManagement() {
        this.seats = new ArrayList<>();
    }

    public ArrayList<Seat> getSeats() {
        return this.seats;
    }

    public void addSeat(Seat seat) throws ExceptionSeatOccupied {
        int index;
        index = searchSeat(seat.getRowNumber(), seat.getSeatNumber());
        if (index == -1){
            this.seats.add(seat);
        }else {
            throw new ExceptionSeatOccupied("Error: Seat is already occupied");
        }
    }

    public void removeSeat(int row_number, int seat_number) throws ExceptionFreeSeat {
        boolean isReserved = false;
        int index = 0;
        for (Seat s : this.seats) {
            if(Seat.equals(row_number, seat_number, s.getRowNumber(), s.getSeatNumber())){
                isReserved = true;
                index =  seats.indexOf(s);
            }
        }
        if(isReserved){
            this.seats.remove(index);
        }else {
            throw new ExceptionFreeSeat("Error: The seat is free");
        }
    }

    public int searchSeat(int rowNumber, int seatNumber) {
        int position = -1;
        for (Seat s : this.seats) {
            if(Seat.equals(rowNumber, seatNumber, s.getRowNumber(), s.getSeatNumber())){
                position = this.seats.indexOf(s);
            }
        }
        return position;
    }
}
