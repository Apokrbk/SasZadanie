import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Double> wspolczynniki = new ArrayList<>();
        wspolczynniki.add(-50.0);
        wspolczynniki.add(-1.6);
        wspolczynniki.add(12.8);
        wspolczynniki.add(3.0);
        FileReader fileReader = new FileReader("data.txt");
        RootValueFinder rootValueFinder = new RootValueFinder(fileReader.getData());
        System.out.println("Wartosc funkcji w punkcie: " + 5 + "  jest rowna:  "
                + rootValueFinder.findRootValueOfFunction());
    }
}
