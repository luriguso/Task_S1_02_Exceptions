package level3.excercise1.classData;

public class Seat {
    private int rowNumber;
    private int seatNumber;
    private String reservationName;

    public Seat(int rowNumber, int seatNumber, String reservationName) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.reservationName = reservationName;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getReservationName() {
        return reservationName;
    }

    public static boolean equals(int row_number, int seat_number, int row_number_2, int seat_number_2) {
        return row_number == row_number_2 && seat_number == seat_number_2;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "row: " + rowNumber +
                ", seat: " + seatNumber +
                ", person: " + reservationName + '\'' +
                '}';
    }
}
