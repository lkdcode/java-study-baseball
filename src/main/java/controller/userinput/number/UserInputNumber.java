package controller.userinput.number.user;

import controller.userinput.number.RandomNumber;
import data.DataBase;
import ui.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputNumber implements RandomNumber {
    private final Scanner scanner;
    private final UserInputNumberValidate userInputValidate;
    private List<Integer> userNumbers;
    private int stage;

    public UserInputNumber() {
        this.userInputValidate = new UserInputNumberValidate();
        this.scanner = new Scanner(System.in);
        this.stage = DataBase.getInstance().getStage();
    }

    @Override
    public void makeNumbers() {
        this.userNumbers = new ArrayList<>();
        boolean validate;
        String userInput;

        do {
            Message.INPUT_NUMBER.print();
            userInput = scanner.nextLine();
            validate = userInputValidate.userInputNumbers(userInput);
        } while (!validate);
        addNumbers(userInput);
    }

    private void addNumbers(String userInput) {
        for (int i = 0; i < stage; i++) {
            userNumbers.add(Integer.parseInt(String.valueOf(userInput.charAt(i))));
        }
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
