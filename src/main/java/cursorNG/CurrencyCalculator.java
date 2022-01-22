package cursorNG;

public class CurrencyCalculator {
    int result = 0;

    public int getValue() {
        return result;
    }

    public int convertToCurrency(int n1, char op) {
        switch (op) {
            case 'D':
                result = n1 * 27;
                break;
            case 'E':
                result = n1 * 30;
                break;
            case 'P':
                result = n1 * 7;
                break;
            default:
                System.out.println("Incorrect input!");
        }
        return result;
    }
}
