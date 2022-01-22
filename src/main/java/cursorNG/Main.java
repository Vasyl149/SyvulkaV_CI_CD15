package cursorNG;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calculator calculator = new Calculator();
        ReadConsole readConsole = new ReadConsole();
        CurrencyCalculator currencyCalculator = new CurrencyCalculator();

        System.out.println("\nEnter 1 to select simple calculator, enter 2 to select currency calculator: ");
        int i = scanner.nextInt();

        switch (i) {
            case 1:
                int num1 = readConsole.getInt();
                int num2 = readConsole.getInt();

                System.out.println("Enter operator(+,-,* or /): ");
                char char1 = readConsole.getOperator();

                calculator.calculate(num1, num2, char1);

                System.out.println(calculator.result);
                break;
            case 2:
                int num3 = readConsole.getInt();

                System.out.println("Enter currency('E' - euro, 'D' - dollar, 'P' - zloty): ");
                char char3 = readConsole.getOperator();

                currencyCalculator.convertToCurrency(num3, char3);

                System.out.println(num3 + "UAH" + " = " + currencyCalculator.getValue() + "  " + char3);
                break;
        }

    }
}

