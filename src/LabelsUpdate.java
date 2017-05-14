import javax.swing.*;

class LabelsUpdate {

    void update(JLabel labels[], RootValueFinder rootValueFinder)
    {
        try{
            labels[1].setText("Wybrana funkcja: "+ rootValueFinder.getPolynomialFunction().toString());
            labels[2].setText("Zadany przedział: " + rootValueFinder.getRangeAsString());
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
}
