import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

/**
 * Created by Apok on 13.05.2017.
 */
public class MainFrame extends JFrame{

    private JButton openFile = new JButton("Choose file");


    public MainFrame()
    {
        super("Hello");
        setSize(700,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();

        setLayout(new GridLayout(6,1));
        JPanel jPanel = new JPanel();


        JLabel jLabel = new JLabel("Wybrana funkcja:             ");
        JLabel jLabel1 = new JLabel("Zadany przedział:          ");
        JLabel jLabel3 = new JLabel("Dokładność obliczonej wartości pierwiastka:          ");
        JLabel jLabel4 = new JLabel("Maksymalna liczba iteracji:          ");
        JLabel jLabel2 = new JLabel("Miejsce zerowe wybranej funkcji:             ");
        JButton button = new JButton("Wybierz plik z funkcją");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                jFileChooser.showSaveDialog(MainFrame.this);
                String filename = jFileChooser.getSelectedFile().getAbsolutePath();
                Scanner input = new Scanner(System.in);
                FileReader fileReader = new FileReader(filename);
                RootValueFinder rootValueFinder = new RootValueFinder(fileReader.getData());
                jLabel.setText("Wybrana funkcja: "+ rootValueFinder.getPolynomialFunction().toString());
                jLabel2.setText("Miejsce zerowe wybranej funkcji to: " + rootValueFinder.findRootValueOfFunction());
                jLabel1.setText("Zadany przedział: " + rootValueFinder.getRange());
                jLabel3.setText("Dokładność obliczonej wartości pierwiastka: " + rootValueFinder.getEps());
                jLabel4.setText("Maksymalna liczba iteracji: " + rootValueFinder.getMax());
            }
        });
        button.setSize(100,70);
      container.add(button);
        container.add(jLabel);
        container.add(jLabel1);
        container.add(jLabel4);
        container.add(jLabel3);
        container.add(jLabel2);
        setVisible(true);

    }
}
