package exception;

public class InputCommandException extends Exception {

    public InputCommandException() {
        super(ErrorMessage.USER_INPUT_COMMAND.getMessage());
    }

}
