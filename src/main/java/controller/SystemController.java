package controller;

import controller.userinput.NumberController;
import data.computer.Computer;
import controller.userinput.command.UserInputCommand;
import controller.userinput.number.UserInputNumber;
import data.DataBase;
import data.Referee;
import ui.Message;
import user.UserStatus;
import user.UserStatusHandler;

public class MainController {
    private NumberController numberController;
    private UserInputCommand userInputCommand;
    private Referee referee;
    private UserInputNumber userInput;
    private Computer computer;

    public MainController() {
        this.numberController = new NumberController();

        ////////////
        // play 게임하게되면
        // NumberController 로 들어가서
        // computer 번호를 생성하고, 유저의 번호를 입력받고
        // referee 를 호출해서 사용해야되나

        this.referee = new Referee();
        this.userInput = new UserInputNumber();
        this.computer = new Computer();
        this.userInputCommand = new UserInputCommand();
        Message.WELCOME.print();
        Message.COMPUTER_CREATE.print();
    }

    public void start() {
        computer.makeNumbers();
        boolean command;
        do {
            play();
            DataBase.getInstance().setStage();
            command = command();
            if (command == true) {
                computer.makeNumbers();
            }
        } while (command);
    }

    private boolean command() {
        return userInputCommand.inputCommand();
    }

    private void play() {
        do {

            userInput.makeNumbers();

            System.out.println("user number : " + userInput.getUserNumbers());
            System.out.println("computer number : " + computer.getRandomNumbers());

            referee.playBaseBall(computer.getRandomNumbers(), userInput.getUserNumbers());
            System.out.println(referee.getStrike() + "스트라이크 " + referee.getBall() + "볼");

            if (referee.getStrike() == 3) {
                UserStatusHandler.getInstance().setUserStatus(UserStatus.QUIT);
            }

        } while (UserStatusHandler.getInstance().getUserStatus().equals(UserStatus.PLAY));
    }
}
