import java.util.List;

class RootValueFinder {

    private double k, l, eps, max;
    private PolynomialFunction polynomialFunction;

    RootValueFinder(List<Double> data)
    {
        this.k = data.get(0);
        this.l = data.get(1);
        this.eps = data.get(2);
        this.max = data.get(3);
        polynomialFunction = new PolynomialFunction(data);

    }

    double findRootValueOfFunction()
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
