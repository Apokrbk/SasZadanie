
public class Main {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader("data.txt");
        RootValueFinder rootValueFinder = new RootValueFinder(fileReader.getData());
        System.out.println("Wartosc funkcji w punkcie: " + 5 + "  jest rowna:  "
                + rootValueFinder.findRootValueOfFunction());
    }
}
