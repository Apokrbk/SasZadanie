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
        initFrame();
        JLabel labels[] = new JLabel[7];
        initLabels(labels);
        Container container = this.getContentPane();
        TextArea textArea = initTextArea();
        JButton button = new JButton("Wybierz plik z danymi");
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
                    labels[1].setText("Wybrana funkcja: "+ rootValueFinder.getPolynomialFunction().toString());
                    labels[2].setText("Zadany przedział: " + rootValueFinder.getRange());
                    labels[3].setText("Dokładność obliczanej wartości pierwiastka: " + rootValueFinder.getEps());
                    labels[4].setText("Maksymalna liczba iteracji: " + rootValueFinder.getMax());
                    labels[5].setText("Miejsce zerowe wybranej funkcji to: " + rootValueFinder.findRootValueOfFunction());
                    labels[6].setText("Komunikat: Miejsce zerowe znalezione z odpowiednią dokładnością");
                }
                catch(Exception exception)
                {
                    labels[6].setText("Komunikat: "+ exception.toString());
                    labels[5].setText("Miejsce zerowe wybranej funkcji to: NIE ZNALEZIONO");
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
                FileReader fileReader = new FileReader(filename);
                textArea.setText("");
                try{
                    RootValueFinder rootValueFinder = new RootValueFinder(fileReader.getData());
                    labels[1].setText("Wybrana funkcja: "+ rootValueFinder.getPolynomialFunction().toString());
                    labels[2].setText("Zadany przedział: " + rootValueFinder.getRange());
                    labels[3].setText("Dokładność obliczanej wartości pierwiastka: " + rootValueFinder.getEps());
                    labels[4].setText("Maksymalna liczba iteracji: " + rootValueFinder.getMax());
                    labels[5].setText("Miejsce zerowe wybranej funkcji to: " + rootValueFinder.findRootValueOfFunction());
                    labels[6].setText("Komunikat: Miejsce zerowe znalezione z odpowiednią dokładnością");
                }
                catch(Exception exception)
                {
                    labels[6].setText("Komunikat: "+ exception.toString());
                    labels[5].setText("Miejsce zerowe wybranej funkcji to: NIE ZNALEZIONO");
                }

            }
        });
        button.setSize(100,70);
        addToContainer(labels, container, textArea, button, button1);
        setVisible(true);

    }

    private void addToContainer(JLabel[] labels, Container container, TextArea textArea, JButton button, JButton button1) {
        container.add(button);
        container.add(labels[0]);
        container.add(textArea);
        container.add(button1);
        for(int i=1; i<labels.length; i++)
            container.add(labels[i]);
    }

    private TextArea initTextArea() {
        TextArea textArea;
        textArea = new TextArea();
        textArea.setEditable(true);
        textArea.setFont(new Font("Serif", Font.PLAIN, 20));
        return textArea;
    }

    private void initFrame() {
        setSize(900,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(10,1));
    }

    private void initLabels(JLabel[] labels) {
        labels[0] = new JLabel("Podaj wspolczynniki oddzielając je spacją w kolejności: poczatek przedzialu, koniec przedzialu" +
                ", dokładność, maksymalna liczba iteracji, wspolczynniki funkcji.");
        labels[1] = new JLabel("Wybrana funkcja: ");
        labels[2] = new JLabel("Zadany przedział: ");
        labels[3] = new JLabel("Dokładność obliczanej wartości pierwiastka: ");
        labels[4] = new JLabel("Maksymalna liczba iteracji: ");
        labels[5] = new JLabel("Miejsce zerowe wybranej funkcji: ");
        labels[6] = new JLabel("Komunikat: ");
    }
}
