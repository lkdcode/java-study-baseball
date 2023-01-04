package exception;

public enum ErrorMessage {
    USER_INPUT_DUPLICATION("[ERROR] 중복값이 있습니다."),
    USER_INPUT_LENGTH("[ERROR] 입력한 숫자의 자릿수가 옳지 않습니다. 자릿수 : "),
    USER_INPUT_ONLY_NUMBER("[ERROR] 0 - 9 사이의 숫자만 입력해주세요."),
    USER_INPUT_COMMAND("[ERROR] 0 또는 1만 입력 가능합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void print(String stage) {
        System.out.printf(message, stage);
    }

}
