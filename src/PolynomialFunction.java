import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PolynomialFunction {
    private ArrayList<Double> coefficients = new ArrayList<>();

    PolynomialFunction(List<Double> coefficients)
    {
        for (Double coefficient : coefficients)
            this.coefficients.add(coefficient);
    }

    PolynomialFunction(Double... coefficients)
    {
        Collections.addAll(this.coefficients, coefficients);
    }

    public double calculateValueOfFunctionAtTheGivenPoint(double x)
    {
        double value=0;
        int size = coefficients.size();
        for(int i=0; i<size; i++)
            value += coefficients.get(i) * Math.pow(x, i);
        return value;
    }

    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<coefficients.size(); i++)
        {
            stringBuilder.append(coefficients.get(i));
            stringBuilder.append("*x^");
            stringBuilder.append(i);
            if(i != coefficients.size()-1)
                stringBuilder.append(" + ");
        }
        return stringBuilder.toString();
    }

}
