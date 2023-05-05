import javax.swing.*;

public class ArrayOperations {
    public static void main(String[] args) {
        int[] counts = new int[10];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = 0;
        }
        JOptionPane.showMessageDialog(null, "Array counts has been set to zero.");

        int[] bonus = new int[15];
        for (int i = 0; i < bonus.length; i++) {
            bonus[i]++;
        }
        JOptionPane.showMessageDialog(null, "One has been added to each element of array bonus.");
        
        int[] bestScores = {98, 95, 92, 99, 97};
        String output = "The five values of array bestScores are:\n";
        for (int i = 0; i < bestScores.length; i++) {
            output += String.format("%d\n", bestScores[i]);
        }
        JOptionPane.showMessageDialog(null, output);
    }
}
