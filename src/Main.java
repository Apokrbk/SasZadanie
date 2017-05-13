import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Double> wspolczynniki = new ArrayList<>();
        wspolczynniki.add(1.6);
        wspolczynniki.add(-1.6);
        wspolczynniki.add(5.8);
        wspolczynniki.add(1.2);
        PolynomialFunction polynomialFunction = new PolynomialFunction(wspolczynniki);
        System.out.println("Wartosc funkcji w punkcie: " + 5 + "  jest rowna:  "
                + polynomialFunction.calculateValueOfFunctionAtTheGivenPoint(5));
    }
}
