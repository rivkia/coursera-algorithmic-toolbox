import java.util.*;

public class GCD {
    private static int gcd_naive(int a, int b) {
        int current_gcd = 1;
        for (int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }

        return current_gcd;
    }

    private static int gcd_better(int a, int b) {
        while (b != 0 && b != 1) {
            int temp_b = b;
            b = a % b;
            a = temp_b;
        }
        return b == 0 ? a : 1;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd_better(a, b));
    }
}
