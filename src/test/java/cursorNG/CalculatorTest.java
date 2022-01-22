package cursorNG;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.InputMismatchException;

public class CalculatorTest {


    private static Calculator calculator =new Calculator();

    @BeforeMethod
    public void dataSetup(){
        calculator = new Calculator();
    }

    @Test(groups = {"smoke","regression"})
    public void verifySum()  {
        SoftAssert softAssert = new SoftAssert();

        System.out.println("test - Class Calculator 1");

        calculator.calculate(3, 2, '+');
        softAssert.assertEquals(calculator.getValue(),5,  "expected value should be 5");

        calculator.calculate(6, 2, '+');
        softAssert.assertEquals(calculator.getValue(),8, "expected value should be 8" );
        softAssert.assertAll();
    }

    @Test(groups = {"smoke","regression"})
    @Parameters({"value1","value2","result"})
    public void verifySubtraction(int value1,int value2, int result){
        System.out.println("test - Class Calculator 2");
        calculator.calculate(value1, value2, '-');
        Assert.assertEquals(calculator.getValue(),result );
    }

    @Test(groups ="regression")
    public void verifyMult(){
        System.out.println("test - Class Calculator 3");
        calculator.calculate(6, 5, '*');
        Assert.assertEquals(calculator.getValue(),30 );
    }

    @DataProvider(name = "values")
    public static Object[][] primeNumbers(){
        return new Object[][] {{10,2,5}, {100,5,20}};
    }

    @Test(groups = "regression", dataProvider = "values")
    public void verifyDivision(int value1, int value2, int result){
        System.out.println("test - Class Calculator 4");
        calculator.calculate(value1, value2, '/');
        Assert.assertEquals(calculator.getValue(),result , "result must be "+ result);
    }



    @Test(expectedExceptions = ArithmeticException.class, groups = "regression")
    public void verifyException() {
        System.out.println("test - Class Calculator 2");
        calculator.calculate(5, 0, '/');
        //System.out.println(calculator.getValue());
    }


    @AfterMethod
    public void clearData(){
        calculator = null;
    }
}
