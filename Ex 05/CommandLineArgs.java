import javax.swing.JOptionPane;

public class CommandLineArgs {
    public static void main(String[] args) {
        int size;
        if (args.length > 0) {
            size = Integer.parseInt(args[0]);
        } else {
            size = 10;
        }
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = 2 + 2 * i;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%8s\n", "Index", "Value"));
        for (int i = 0; i < numbers.length; i++) {
            sb.append(String.format("%5d%8d\n", i, numbers[i]));
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Array Output", JOptionPane.INFORMATION_MESSAGE);
    }   
}