package level3.excercise1.exceptions;

public class BadRow extends RuntimeException {
  public BadRow(String message) {
    super(message);
  }
}
