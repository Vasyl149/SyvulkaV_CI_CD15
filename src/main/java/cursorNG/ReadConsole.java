package cursorNG;

import java.util.Scanner;

public class ReadConsole {
    static Scanner scanner = new Scanner(System.in);
    int num;


    public int getInt() {
        System.out.println("Enter integer:");
        num = scanner.nextInt();
        return num;
    }

    public char getOperator() {

        char operator = scanner.next().charAt(0);
        return operator;
    }
}
