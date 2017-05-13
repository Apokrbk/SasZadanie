import java.util.ArrayList;
import java.util.List;

/**
 * Created by Apok on 13.05.2017.
 */
public class PolynomialFunction {
    ArrayList<Double> coefficients = new ArrayList<>();

    public PolynomialFunction(List<Double> coefficients)
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
