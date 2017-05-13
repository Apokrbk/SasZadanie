import java.util.ArrayList;
import java.util.List;

public class PolynomialFunction {
    ArrayList<Double> coefficients = new ArrayList<>();

    public PolynomialFunction(List<Double> coefficients)
    {
        for (int i=4; i<coefficients.size(); i++)
        {
            this.coefficients.add(coefficients.get(i));
        }
    }

    public PolynomialFunction(double... coefficients)
    {
        for (Double coefficient : coefficients)
        {
            this.coefficients.add(coefficient);
        }
    }

    public double calculateValueOfFunctionAtTheGivenPoint(double x)
    {
        double value=0;
        int size = coefficients.size();
        for(int i=0; i<size; i++)
        {
            value += coefficients.get(i) * Math.pow(x, i);
        }
        return value;
    }
}
