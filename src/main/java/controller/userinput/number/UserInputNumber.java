package controller.userinput.number;

import data.DataBase;
import data.RandomNumber;
import ui.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputNumber implements RandomNumber {
    private final Scanner scanner;
    private final UserInputNumberValidate userInputValidate;
    private List<Integer> userNumbers;

    public UserInputNumber() {
        this.userInputValidate = new UserInputNumberValidate();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void makeNumbers() {
        this.userNumbers = new ArrayList<>();
        String userInput = inputNumber();
        addNumbers(userInput);
    }

    private String inputNumber() {
        boolean isValidate;
        String userInput;
        do {
            Message.INPUT_NUMBER.print();
            userInput = scanner.nextLine();
            isValidate = userInputValidate.userInputNumbers(userInput);
        } while (!isValidate);
        return userInput;
    }

    private void addNumbers(String userInput) {
        for (int i = 0; i < DataBase.getInstance().getStage(); i++) {
            userNumbers.add(Integer.parseInt(String.valueOf(userInput.charAt(i))));
        }
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
