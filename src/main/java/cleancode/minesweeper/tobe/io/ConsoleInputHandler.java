package cleancode.minesweeper.tobe.io;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {

    public static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String getUserInput() {
        return SCANNER.nextLine();
    }

}
