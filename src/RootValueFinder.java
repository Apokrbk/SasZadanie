import java.util.List;

class RootValueFinder {

    private double k; //poczatek przedzialu
    private double l; //koniec przedzialu
    private double eps; //dokladnosc z jaka obliczamy
    private double max; //maksymalna liczba iteracji
    private PolynomialFunction polynomialFunction;

    RootValueFinder(List<Double> data) throws Exception
    {
        if(data.size()<= 4)
            throw new Exception("Niepoprawny format danych lub za mało parametrów");
        this.k = data.get(0);
        this.l = data.get(1);
        this.eps = data.get(2);
        this.max = data.get(3);
        polynomialFunction = new PolynomialFunction(data.subList(4,data.size()));
    }

    RootValueFinder(double k, double l, double eps, double max, Double... data) throws Exception
    {
        if(data.length == 0)
            throw new Exception("Niepoprawny format danych lub za mało parametrów");
        this.k = k;
        this.l = l;
        this.eps = eps;
        this.max = max;
        polynomialFunction = new PolynomialFunction(data);
    }

    public double findRootValueOfFunction() throws Exception
    {
        //jeśli ten sam znak funkcji na końcach przedziału to nie można obliczyć miejsca zerowego
        if(areEdgesOfRangeSameSigns(k,l))
            throw new Exception("Funkcja nie spełnia założeń. Ten sam znak funkcji na końcach przedziału.");
        //przypisujemy wartosci przedzialu
        double leftEdge = k;
        double rightEdge = l;
        double rootValue;
        for(int i=0; i<max; i++)
        {
            rootValue = (leftEdge+rightEdge)/2;
            //sprawdzamy czy wartosc w połowie przedziału jest już wystarczającym przybliżeniem miejsca zerowego funkcji
            if(isValueCloseEnough(rootValue))
                return rootValue;
            //sprawdzamy którą połowę przedziału wybrać i zmniejszamy przeszukiwany przedział o połowę
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

    double getEps() {
        return eps;
    }

    double getMax() {
        return max;
    }

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


}
