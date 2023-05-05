import javax.swing.JOptionPane;

public class SalesSummary {
    public static void main(String[] args) {
        double[][] sales = new double[5][4];
        while (true) {
            String salespersonStr = JOptionPane.showInputDialog("Enter salesperson number (1-4), or '0' to exit:");
            int salesperson = Integer.parseInt(salespersonStr);
            if (salesperson == 0) {
                break;
            }
            String productStr = JOptionPane.showInputDialog("Enter product number (1-5):");
            int product = Integer.parseInt(productStr);
            String valueStr = JOptionPane.showInputDialog("Enter total dollar value of product sold:");
            double value = Double.parseDouble(valueStr);
            sales[product-1][salesperson-1] += value;
        }

        String output = String.format("%10s%10s%10s%10s%10s%10s%n", "Product", "Salesperson 1", "Salesperson 2", "Salesperson 3", "Salesperson 4", "Total");
        for (int i = 0; i < 5; i++) {
            double rowTotal = 0;
            output += String.format("%10d", i+1);
            for (int j = 0; j < 4; j++) {
                output += String.format("%10.2f", sales[i][j]);
                rowTotal += sales[i][j];
            }
            output += String.format("%10.2f%n", rowTotal);
        }
        double[] colTotals = new double[4];
        output += String.format("%10s", "Total");
        for (int j = 0; j < 4; j++) {
            double colTotal = 0;
            for (int i = 0; i < 5; i++) {
                colTotal += sales[i][j];
            }
            colTotals[j] = colTotal;
            output += String.format("%10.2f", colTotal);
        }
        double grandTotal = colTotals[0] + colTotals[1] + colTotals[2] + colTotals[3];
        output += String.format("%10.2f", grandTotal);
        JOptionPane.showMessageDialog(null, output);
    }
}
