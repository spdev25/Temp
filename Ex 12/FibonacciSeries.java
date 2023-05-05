import javax.swing.*;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Enter the value of n:"));
        
        // Part (a)
        int result = fibonacci(n);
        JOptionPane.showMessageDialog(null, "The " + n + "th Fibonacci number is: " + result);
        
        // Part (b)
        int i = 1, j = 1, temp = 0;
        while (i + j > 0) {
            temp = i + j;
            i = j;
            j = temp;
        }
        JOptionPane.showMessageDialog(null, "The largest Fibonacci number that can be displayed on this system is: " + i);
        
        // Part (c)
        double result_double = fibonacci_double(n);
        JOptionPane.showMessageDialog(null, "The " + n + "th Fibonacci number (calculated with double) is: " + result_double);
    }
    
    // Part (a)
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    // Part (c)
    public static double fibonacci_double(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci_double(n - 1) + fibonacci_double(n - 2);
    }
}
