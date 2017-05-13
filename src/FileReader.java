import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

class FileReader {

    ArrayList<Double> getData() {
        return data;
    }

    private ArrayList<Double> data = new ArrayList<>();
    FileReader(String nameOfFile)
    {
        try {
            Scanner scanner = new Scanner(new File(nameOfFile));
            scanner.useLocale(Locale.US);
            while(scanner.hasNextDouble())
            {
                data.add(scanner.nextDouble());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
