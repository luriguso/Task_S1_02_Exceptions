package level_3.excercise_1.classData;

public class Seat {
    private int row_number;
    private int seat_number;
    private String reservation_name;

    public Seat(int row_number, int seat_number, String reservation_name) {
        this.row_number = row_number;
        this.seat_number = seat_number;
        this.reservation_name = reservation_name;
    }

    public int getRow_number() {
        return row_number;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public String getReservation_name() {
        return reservation_name;
    }

    public static boolean equals(int row_number, int seat_number, int row_number_2, int seat_number_2) {
        return row_number == row_number_2 && seat_number == seat_number_2;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "row: " + row_number +
                ", seat: " + seat_number +
                ", person: " + reservation_name + '\'' +
                '}';
    }
}
