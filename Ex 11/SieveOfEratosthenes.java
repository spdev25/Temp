import javax.swing.JOptionPane;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        boolean[] primes = new boolean[1000];
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i + i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Prime numbers between 2 and 999:\n");
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                sb.append(i + " ");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}