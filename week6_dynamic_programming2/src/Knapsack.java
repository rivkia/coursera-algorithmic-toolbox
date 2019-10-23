import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int result = 0;
        for (int i = 0; i < w.length; i++) {
            if (result + w[i] <= W) {
                result += w[i];
            }
        }
        return result;
    }

    static int knapsack(int W, int[] w, int[] v) {
        int value[] = new int[W+1];
        for (int i = 1; i <= W; i++) {
            value[i] = 0;
            for (int j = 0; j < w.length; j++) {
                if (w[j] <= i) {
                    int val = value[i - w[j]] + v[j];
                    if(val> value[i])
                        value[i] = val;
                }
            }
        }
        return value[W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
        }
        System.out.println(knapsack(W, w,v));
    }
}

