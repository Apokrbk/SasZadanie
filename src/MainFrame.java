import javax.swing.*;
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
        setSize(500,100);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();


        JLabel jLabel = new JLabel("Miejsce zerowe wybranej funkcji:             ");
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
                jLabel.setText("Miejsce zerowe wybranej funkcji to: " + rootValueFinder.findRootValueOfFunction());
                pack();
            }
        });
        button.setSize(100,70);
        jPanel.add(button);
        jPanel.add(jLabel);
        add(jPanel);
        pack();
        setVisible(true);

    }
}
