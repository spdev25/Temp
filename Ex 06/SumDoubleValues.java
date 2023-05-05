import javax.swing.JOptionPane;

public class SumDoubleValues {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog(null, "Enter double values separated by spaces:");
        String[] inputValues = input.split("\\s+");
        double sum = 0.0;
        for (String value : inputValues) {
            sum += Double.parseDouble(value);
        }
        JOptionPane.showMessageDialog(null, "The sum of the entered values is: " + sum);
    }
}
