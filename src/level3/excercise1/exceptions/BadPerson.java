package level3.excercise1.exceptions;

public class BadPerson extends RuntimeException {
    public BadPerson(String message) {
        super(message);
    }
}
