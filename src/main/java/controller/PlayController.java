package controller;

import controller.userinput.number.UserInputNumber;
import data.DataBase;
import data.Referee;
import data.computer.Computer;
import user.UserStatus;
import user.UserStatusHandler;

public class PlayController {
    private final String STRIKE = "스트라이크 ";
    private final String BALL = "볼";
    private UserInputNumber userInputNumber;
    private Computer computer;
    private Referee referee;

    public PlayController() {
        this.userInputNumber = new UserInputNumber();
        this.computer = new Computer();
        this.referee = new Referee();
    }

    public void playBaseball() {
        computer.makeNumbers();

        do {
            // 컴퓨터 번호
            // 추후 삭제..
            System.out.println(">>" + computer.getRandomNumbers());
            //

            userInputNumber.makeNumbers();

            referee.playBaseBall(computer.getRandomNumbers(), userInputNumber.getUserNumbers());
            // re
            // outputview 클래스
            System.out.println(referee.getStrike() + STRIKE + referee.getBall() + BALL);
            //
            if (referee.getStrike() == DataBase.getInstance().getStage()) {
                UserStatusHandler.getInstance().setUserStatus(UserStatus.QUIT);
            }

        } while (UserStatusHandler.getInstance().getUserStatus().equals(UserStatus.PLAY));
    }
}