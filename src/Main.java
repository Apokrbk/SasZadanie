import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Double> wspolczynniki = new ArrayList<>();
        wspolczynniki.add(-50.0);
        wspolczynniki.add(-1.6);
        wspolczynniki.add(12.8);
        wspolczynniki.add(3.0);
        PolynomialFunction polynomialFunction = new PolynomialFunction(wspolczynniki);
        RootValueFinder rootValueFinder = new RootValueFinder(-10,20,1,15,wspolczynniki);
        System.out.println("Wartosc funkcji w punkcie: " + 5 + "  jest rowna:  "
                + rootValueFinder.findRootValueOfFunction());
    }
}
