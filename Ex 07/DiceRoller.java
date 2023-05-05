import javax.swing.JOptionPane;
import java.util.Random;

public class DiceRoller {
    public static void main(String[] args) {
        int[][] rolls = new int[6][6];

        int numRolls = 36000000;
        if (args.length > 0) {
            numRolls = Integer.parseInt(args[0]);
        }

        Random random = new Random();
        for (int i = 0; i < numRolls; i++) {
            int roll1 = random.nextInt(6) + 1;
            int roll2 = random.nextInt(6) + 1;
            rolls[roll1 - 1][roll2 - 1]++;
        }

        StringBuilder output = new StringBuilder();
        output.append("   ");
        for (int i = 1; i <= 6; i++) {
            output.append(String.format("%5d", i));
        }
        output.append("\n");
        output.append("   --------------------------------\n");
        for (int i = 0; i < 6; i++) {
            output.append(String.format("%d |", i + 1));
            for (int j = 0; j < 6; j++) {
                output.append(String.format("%5d", rolls[i][j]));
            }
            output.append("\n");
        }
        JOptionPane.showMessageDialog(null, output.toString());
    }
}