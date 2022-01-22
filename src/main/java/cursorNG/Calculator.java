package cursorNG;

public class Calculator {
    int result = 0;

    public int getValue() {
        return result;
    }


    public int calculate(int n1, int n2, char operator) {
        //int result = 0;
        switch (operator) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                result = n1 / n2;
                break;
            default:
                System.out.println("Incorrect input!");
        }
        return result;
    }


}
