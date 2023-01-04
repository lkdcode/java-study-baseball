package exception;

public class InputDuplicationException extends Exception {

    public InputDuplicationException() {
        super(ErrorMessage.USER_INPUT_DUPLICATION.getMessage());
    }

}
