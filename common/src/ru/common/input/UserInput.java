package ru.common.input;

import java.util.Scanner;

public class UserInput {
    public final Scanner scanner = new Scanner(System.in);

    public int readInt() {
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Введите целое число");
        }
    }

    public String readLine() {
        return scanner.nextLine();
    }

}
