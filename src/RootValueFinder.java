import java.util.List;

/**
 * Created by Apok on 13.05.2017.
 */
public class RootValueFinder {

    double k, l, eps, max;
    PolynomialFunction polynomialFunction;

    public RootValueFinder(double k, double l, double eps, int max, List<Double> coefficients)
    {
        this.k = k;
        this.l = l;
        this.eps = eps;
        this.max = max;
        polynomialFunction = new PolynomialFunction(coefficients);
    }

    public RootValueFinder(List<Double> data)
    {
        this.k = data.get(0);
        this.l = data.get(1);
        this.eps = data.get(2);
        this.max = data.get(3);
        polynomialFunction = new PolynomialFunction(data);

    }

    public double findRootValueOfFunction()
    {
        if(areEdgesOfRangeSameSigns(k,l))
        {
            System.out.println("Funkcja nie spełnia założeń. Miejsce zerowe nie może zostać odnalezione.");
            return -1;
        }
        double leftEdge = k;
        double rightEdge = l;
        double rootValue=-1;
        for(int i=0; i<max; i++)
        {
            rootValue = (leftEdge+rightEdge)/2;
            if(Math.abs(polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(rootValue)) < eps)
                break;
            if(!areEdgesOfRangeSameSigns(leftEdge, rootValue))
            {
                rightEdge = rootValue;
            }
            else
            {
                leftEdge = rootValue;
            }
        }

        return rootValue;
    }

    private boolean areEdgesOfRangeSameSigns(double leftEdge, double rightEdge)
    {
        return ((polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(leftEdge)<0) ==
                (polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(rightEdge)<0));
    }
}
