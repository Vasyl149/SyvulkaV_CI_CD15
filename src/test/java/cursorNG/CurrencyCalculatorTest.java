package cursorNG;


import org.testng.Assert;
import org.testng.annotations.*;

public class CurrencyCalculatorTest {
    private CurrencyCalculator currencyCalculator = new CurrencyCalculator();

    @BeforeClass
    public void dataSetup() {
        currencyCalculator = new CurrencyCalculator();

    }

    @Test(groups = {"smoke", "regression"}, dependsOnMethods = "verifyWrongCharacter")
    public void verifyConvertToDollar(){
        System.out.println("test - Class Currency 1");
        currencyCalculator.convertToCurrency(20, 'D');
        Assert.assertEquals(currencyCalculator.getValue(), 540);
    }

    @Test(groups = {"smoke", "regression"}, dependsOnMethods = "verifyWrongCharacter")
    public void verifyConvertToEuro() {

        System.out.println("test - Class Currency 2");
        currencyCalculator.convertToCurrency(30, 'E');
        Assert.assertEquals(currencyCalculator.getValue(), 900);
    }

    @Test(groups = "regression", dependsOnMethods = "verifyWrongCharacter")
    public void verifyConvertToZloty()  {
        System.out.println("test - Class Currency 3");
        currencyCalculator.convertToCurrency(10, 'P');
        Assert.assertEquals(currencyCalculator.getValue(), 70);
    }


    @Test(groups = "smoke", dependsOnMethods = "verifyZeroValue")
    public void verifyWrongCharacter() {
        System.out.println("test - Class Currency 4");
        currencyCalculator.convertToCurrency(20, '#');
        Assert.assertEquals(currencyCalculator.getValue(), 0);
    }

    @Test(groups = "regression")
    public void verifyZeroValue() {
        System.out.println("test - Class Currency 5");
        currencyCalculator.convertToCurrency(0, 'E');
        Assert.assertEquals(currencyCalculator.getValue(), 0);
    }

    @AfterClass
    public void clearData() {
        currencyCalculator = null;
    }
}
