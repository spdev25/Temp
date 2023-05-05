import javax.swing.JOptionPane;

public class PollingProgram {
    public static void main(String[] args) {
        String[] topics = {"Political Issues", "Global Environmental Issues", "Social Justice Issues", "Public Health Issues", "Economic Issues"};
        int[][] responses = new int[5][10];

        for (int i = 0; i < topics.length; i++) {
            for (int j = 0; j < 10; j++) {
                String input = JOptionPane.showInputDialog("Rate " + topics[i] + " from 1 (least important) to 10 (most important):");
                int rating = Integer.parseInt(input);
                responses[i][rating - 1]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-30s", "Topics"));
        for (int i = 1; i <= 10; i++) {
            sb.append(String.format("%-5s", i));
        }
        sb.append(String.format("%10s", "Average\n"));

        int highestTotal = Integer.MIN_VALUE;
        int highestIndex = -1;
        int lowestTotal = Integer.MAX_VALUE;
        int lowestIndex = -1;

        for (int i = 0; i < topics.length; i++) {
            sb.append(String.format("%-30s", topics[i]));
            int total = 0;
            int count = 0;
            for (int j = 0; j < 10; j++) {
                sb.append(String.format("%-5d", responses[i][j]));
                total += responses[i][j] * (j + 1);
                count += responses[i][j];
            }
            double average = (double) total / count;
            sb.append(String.format("%10.2f", average));
            sb.append("\n");

            if (total > highestTotal) {
                highestTotal = total;
                highestIndex = i;
            }
            if (total < lowestTotal) {
                lowestTotal = total;
                lowestIndex = i;
            }
        }

        sb.append("\n");
        sb.append("Highest point total: " + topics[highestIndex] + " (" + highestTotal + " points)\n");
        sb.append("Lowest point total: " + topics[lowestIndex] + " (" + lowestTotal + " points)");

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
