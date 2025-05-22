package level3.excercise1.exceptions;

public class BadSeatNumber extends RuntimeException {
  public BadSeatNumber(String message) {
    super(message);
  }
}
