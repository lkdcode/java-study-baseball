package exception;

public class InputLengthException extends Exception {

    public InputLengthException(int stage) {
        super(ErrorMessage.USER_INPUT_LENGTH.getMessage() + stage);
    }
}
