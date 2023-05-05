import javax.swing.JOptionPane;

public class ZeroArrayElements {
   public static void main(String[] args) {
      int[][] sales = new int[3][5];
      for (int row = 0; row < sales.length; row++) {
         for (int col = 0; col < sales[row].length; col++) {
            sales[row][col] = 0;
            System.out.printf("sales[%d][%d] is set to zero\n", row, col);
         }
      }
      JOptionPane.showMessageDialog(null, "Array elements set to zero successfully.");      
   }
}