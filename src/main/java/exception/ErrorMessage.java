public enum ErrorMessage {
    USER_INPUT_DUPLICATION("[ERROR] 중복값이 있습니다.%n"),
    USER_INPUT_LENGTH("[ERROR] 입력한 숫자의 자릿수가 부족합니다. 자릿수 : "),
    USER_INPUT_ONLY_NUMBER("[ERROR] 0 - 9 사이의 숫자만 입력해주세요.%n");
    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public void print() {
        System.out.printf(message);
    }

    public void print(String anotherMessage) {
        System.out.println(message + anotherMessage);
    }

}
