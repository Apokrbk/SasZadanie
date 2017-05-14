import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Apok on 14.05.2017.
 */
public class PolynomialFunctionTest {
    @org.junit.Test
    public void calculateValueOfFunctionAtTheGivenPoint() throws Exception {
        ArrayList<Double> coefficients = new ArrayList<>();
        coefficients.add(5.0);
        coefficients.add(1.0);
        PolynomialFunction polynomialFunction = new PolynomialFunction(coefficients);
        assertEquals(5, polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(0),0);
    }
}