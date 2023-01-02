public enum Message {

    WELCOME("⚾️ 야구 게임을 시작하겠습니다. ⚾%n"),
    COMPUTER_CREATE("........ 🖥️ 컴퓨터 번호 생성 완료 !%n"),
    INPUT_NUMBER("👉번호를 입력해주세요 : "),
    INPUT_COMMAND("게임을 종료하시려면 0, 계속 하시려면 1번을 눌러주세요 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public void print() {
        System.out.printf(message);
    }
}
