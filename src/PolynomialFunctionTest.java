import java.util.ArrayList;

import static org.junit.Assert.*;

public class PolynomialFunctionTest {
    @org.junit.Test
    public void calculateValueOfFunctionAtTheGivenPoint() throws Exception {
        ArrayList<Double> coefficients = new ArrayList<>();
        coefficients.add(5.0);
        coefficients.add(1.0);
        PolynomialFunction polynomialFunction = new PolynomialFunction(coefficients);
        assertEquals(5, polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(0),0);
    }

    @org.junit.Test
    public void calculateValueOfFunctionAtTheGivenPoint2() throws Exception {
        ArrayList<Double> coefficients = new ArrayList<>();
        coefficients.add(10.0);
        coefficients.add(-5.0);
        coefficients.add(17.2);
        coefficients.add(-10.0);
        PolynomialFunction polynomialFunction = new PolynomialFunction(coefficients);
        assertEquals(-225.55, polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(3.5),0);
    }

    @org.junit.Test
    public void calculateValueOfFunctionAtTheGivenPoint3() throws Exception {
        ArrayList<Double> coefficients = new ArrayList<>();
        coefficients.add(0.0);
        coefficients.add(0.0);
        coefficients.add(17.2);
        coefficients.add(-10.0);
        coefficients.add(-5.6);
        coefficients.add(0.0);
        coefficients.add(1.234);
        PolynomialFunction polynomialFunction = new PolynomialFunction(coefficients);
        assertEquals(498.358341, polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(3.14),0.00001);
    }

    @org.junit.Test
    public void calculateValueOfFunctionAtTheGivenPoint4() throws Exception {
        PolynomialFunction polynomialFunction = new PolynomialFunction(3.18, 9.13, -13.3, 23.222);
        assertEquals(-6821.866016389248, polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(-6.444), 0);
    }

    @org.junit.Test
    public void calculateValueOfFunctionAtTheGivenPoint5() throws Exception {
        PolynomialFunction polynomialFunction = new PolynomialFunction(0.0, 0.0, 0.0, 123.4, 1233.5, 213.2);
        assertEquals(0, polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(0), 0);
    }

    @org.junit.Test
    public void calculateValueOfFunctionAtTheGivenPoint6() throws Exception {
        PolynomialFunction polynomialFunction = new PolynomialFunction(5.0, 0.0, 0.0, 123.4, 1233.5, 213.2);
        assertEquals(5, polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(0), 0);
    }
}