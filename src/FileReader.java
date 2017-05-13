import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileReader {

    public ArrayList<Double> getData() {
        return data;
    }

    ArrayList<Double> data = new ArrayList<>();
    public FileReader(String nameOfFile)
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

    public double getSpecifiedData(int i)
    {
        return data.get(i);
    }


}
