import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class MainFrame extends JFrame{

    private JButton openFile = new JButton("Choose file");


    public MainFrame()
    {
        super("Hello");
        setSize(900,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();

        setLayout(new GridLayout(10,1));

        JLabel jLabel5 = new JLabel("Podaj wspolczynniki oddzielając je spacją w kolejności: poczatek przedzialu, koniec przedzialu" +
                ", dokładność, maksymalna liczba iteracji, wspolczynniki funkcji.");
        JLabel jLabel = new JLabel("Wybrana funkcja:             ");
        JLabel jLabel1 = new JLabel("Zadany przedział:          ");
        JLabel jLabel3 = new JLabel("Dokładność obliczonej wartości pierwiastka:          ");
        JLabel jLabel4 = new JLabel("Maksymalna liczba iteracji:          ");
        JLabel jLabel2 = new JLabel("Miejsce zerowe wybranej funkcji:             ");
        JLabel jLabel6 = new JLabel("Komunikat: ");
        TextArea textArea = new TextArea();
        textArea.setEditable(true);
        textArea.setFont(new Font("Serif", Font.PLAIN, 20));
        JButton button = new JButton("Wybierz plik z funkcją");
        JButton button1 = new JButton("Użyj wpisanych danych");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dataString = textArea.getText();
                Scanner scanner = new Scanner(dataString);
                scanner.useLocale(Locale.US);
                ArrayList<Double> data = new ArrayList<>();
                while(scanner.hasNextDouble())
                {
                    data.add(scanner.nextDouble());
                }

                try{
                    RootValueFinder rootValueFinder = new RootValueFinder(data);
                    jLabel.setText("Wybrana funkcja: "+ rootValueFinder.getPolynomialFunction().toString());
                    jLabel1.setText("Zadany przedział: " + rootValueFinder.getRange());
                    jLabel3.setText("Dokładność obliczanej wartości pierwiastka: " + rootValueFinder.getEps());
                    jLabel4.setText("Maksymalna liczba iteracji: " + rootValueFinder.getMax());
                    jLabel2.setText("Miejsce zerowe wybranej funkcji to: " + rootValueFinder.findRootValueOfFunction());
                    jLabel6.setText("Komunikat: Miejsce zerowe znalezione z odpowiednią dokładnością");
                }
                catch(Exception exception)
                {
                    jLabel6.setText("Komunikat: "+ exception.toString());
                    jLabel2.setText("Miejsce zerowe wybranej funkcji to: NIE ZNALEZIONO");
                }

            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                jFileChooser.showSaveDialog(MainFrame.this);
                String filename = jFileChooser.getSelectedFile().getAbsolutePath();
                Scanner input = new Scanner(System.in);
                FileReader fileReader = new FileReader(filename);
                try{
                    RootValueFinder rootValueFinder = new RootValueFinder(fileReader.getData());
                    jLabel.setText("Wybrana funkcja: "+ rootValueFinder.getPolynomialFunction().toString());
                    jLabel1.setText("Zadany przedział: " + rootValueFinder.getRange());
                    jLabel3.setText("Dokładność obliczanej wartości pierwiastka: " + rootValueFinder.getEps());
                    jLabel4.setText("Maksymalna liczba iteracji: " + rootValueFinder.getMax());
                    jLabel2.setText("Miejsce zerowe wybranej funkcji to: " + rootValueFinder.findRootValueOfFunction());
                    jLabel6.setText("Komunikat: Miejsce zerowe znalezione z odpowiednią dokładnością");
                }
                catch(Exception exception)
                {
                    jLabel6.setText("Komunikat: "+ exception.toString());
                    jLabel2.setText("Miejsce zerowe wybranej funkcji to: NIE ZNALEZIONO");
                }

            }
        });
        button.setSize(100,70);
      container.add(button);
      container.add(jLabel5);
      container.add(textArea);
      container.add(button1);
        container.add(jLabel);
        container.add(jLabel1);
        container.add(jLabel4);
        container.add(jLabel3);
        container.add(jLabel2);
        container.add(jLabel6);
        setVisible(true);

    }
}
