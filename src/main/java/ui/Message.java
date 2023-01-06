package ui;

public enum Message {

    WELCOME("⚾️ 야구 게임을 시작하겠습니다. ⚾%n"),
    COMPUTER_CREATE("🖥️ 컴퓨터 번호 생성 완료 ..!%n"),
    INPUT_NUMBER("%n👉번호를 입력해주세요 : "),
    INPUT_COMMAND("%n🙅게임을 종료하시려면 0, 🙆‍계속 하시려면 1번을 눌러주세요 : "),
    LEVEL_UP("%n⚠️난이도가 상승하였습니다!!%n"),
    INPUT_LENGTH("👺맞춰야할 숫자의 길이는 : "),
    WIN("%n🏆 최종 승리 하였습니다!!%n"),
    GAME_EXIT("%n⚾ 야구 게임이 종료되었습니다. ⚾%n%n");


    private final String message;

    Message(String message) {
        this.message = message;
    }

    public void print() {
        System.out.printf(message);
    }

    public void print(String addMessage) {
        System.out.printf(message, addMessage);
    }
}
