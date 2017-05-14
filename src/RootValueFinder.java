import java.util.List;

class RootValueFinder {

    private double k;
    private double l;

    double getEps() {
        return eps;
    }

    double getMax() {
        return max;
    }

    private double eps;
    private double max;

    PolynomialFunction getPolynomialFunction() {
        return polynomialFunction;
    }

    String getRangeAsString()
    {
       if(k<=l)
           return " ( " + k + " , " + l + " ) ";
       else
           return " ( " + l + " , " + k + " ) ";
    }

    private PolynomialFunction polynomialFunction;

    RootValueFinder(List<Double> data) throws Exception
    {
        if(data.size()<= 4)
            throw new Exception("Niepoprawny format danych lub za mało parametrów");
        this.k = data.get(0);
        this.l = data.get(1);
        this.eps = data.get(2);
        this.max = data.get(3);
        polynomialFunction = new PolynomialFunction(data);

    }

    double findRootValueOfFunction() throws Exception
    {
        if(areEdgesOfRangeSameSigns(k,l))
        {
            throw new Exception("Funkcja nie spełnia założeń. Ten sam znak funkcji na końcach przedziału.");
        }
        double leftEdge = k;
        double rightEdge = l;
        double rootValue;
        for(int i=0; i<max; i++)
        {
            rootValue = (leftEdge+rightEdge)/2;
            if(isValueCloseEnough(rootValue))
                return rootValue;
            if(!areEdgesOfRangeSameSigns(leftEdge, rootValue))
                rightEdge = rootValue;
            else
                leftEdge = rootValue;
        }
        throw new Exception("Maksymalna liczba iteracji osiągnięta. Nie udało się znaleźć miejsca zerowego z zadaną dokładnością");
    }

    private boolean isValueCloseEnough(double rootValue) {
        return Math.abs(polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(rootValue))<eps;
    }

    private boolean areEdgesOfRangeSameSigns(double leftEdge, double rightEdge)
    {
        return ((polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(leftEdge)<0) ==
                (polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(rightEdge)<0));
    }
}
