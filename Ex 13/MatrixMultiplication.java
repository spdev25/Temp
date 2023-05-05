import javax.swing.JOptionPane;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int rows1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of rows for matrix 1:"));
        int cols1 = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of columns for matrix 1:"));
        int rows2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of rows for matrix 2:"));
        int cols2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of columns for matrix 2:"));

        if (cols1 != rows2) {
            JOptionPane.showMessageDialog(null, "The number of columns in matrix 1 must match the number of rows in matrix 2.");
            return;
        }

        int[][] matrix1 = new int[rows1][cols1];
        int[][] matrix2 = new int[rows2][cols2];
        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                matrix1[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Enter matrix 1[" + i + "][" + j + "]:"));
            }
        }

        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Enter matrix 2[" + i + "][" + j + "]:"));
            }
        }

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Matrix 1:\n");
        for (int[] row : matrix1) {
            for (int num : row) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        sb.append("\nMatrix 2:\n");
        for (int[] row : matrix2) {
            for (int num : row) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        sb.append("\nResult:\n");
        for (int[] row : result) {
            for (int num : row) {
                sb.append(num + " ");
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}