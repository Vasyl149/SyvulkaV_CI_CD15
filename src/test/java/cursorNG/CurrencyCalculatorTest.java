package cursorNG;


import org.testng.Assert;
import org.testng.annotations.*;

public class CurrencyCalculatorTest {
    private CurrencyCalculator currencyCalculator = new CurrencyCalculator();

    private final String myset = System.getProperty("myset");
   // private final String myset = "set3";

    @BeforeClass
    public void dataSetup() {
        currencyCalculator = new CurrencyCalculator();

    }

    @Test(groups = {"SmokeSuite", "RegressionSuite"}, dependsOnMethods = "verifyWrongCharacter")
    public void verifyConvertToDollar(){
        System.out.println("test - Class Currency 1");
        currencyCalculator.convertToCurrency(20, 'D');
        Assert.assertEquals(currencyCalculator.getValue(), 540);
    }

    @Test(groups = {"SmokeSuite", "RegressionSuite"}, dependsOnMethods = "verifyWrongCharacter")
    public void verifyConvertToEuro() {

        System.out.println("test - Class Currency 2");
        currencyCalculator.convertToCurrency(30, 'E');
        Assert.assertEquals(currencyCalculator.getValue(), 900);
    }

    @DataProvider(name = "values")
    public  Object[][] primeNumbers(){
        Object[][] object = new Object[0][0];
        if (myset.equals("set1")){
            object = new Object[][] {{10,70}, {100,700}};
        }if (myset.equals("set2")) {
            object = new Object[][] {{4,28}, {50,350}};
        } if (myset.equals("set3")){
            object = new Object[][] {{30,210}, {1000,700}};
        }

        return object;
    }

    @Test(groups = "RegressionSuite", dependsOnMethods = "verifyWrongCharacter", dataProvider = "values")
    public void verifyConvertToZloty(int value1, int result)  {
        System.out.println("test - Class Currency 3");
        currencyCalculator.convertToCurrency(value1, 'P');
        Assert.assertEquals(currencyCalculator.getValue(), result);
    }


    @Test(groups = "SmokeSuite")
    public void verifyWrongCharacter() {
        System.out.println("test - Class Currency 4");
        currencyCalculator.convertToCurrency(20, '#');
        Assert.assertEquals(currencyCalculator.getValue(), 0);
    }

    @Test(groups = "RegressionSuite")
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
