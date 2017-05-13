
public class Main {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader("data.txt");
        RootValueFinder rootValueFinder = new RootValueFinder(fileReader.getData());
        System.out.println("Miejsce zerowe podanej funkcji znajduje sie w punkcie:  "
                + rootValueFinder.findRootValueOfFunction());
    }
}
