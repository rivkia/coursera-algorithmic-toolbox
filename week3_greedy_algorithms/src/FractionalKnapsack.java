import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FractionalKnapsack {
    private static class Knapsack implements Comparable<Knapsack> {
        int value, weight;

        Knapsack(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        Double singleValue() {
            return (double) value / weight;
        }

        @Override
        public int compareTo(Knapsack knapsack) {
            return singleValue().compareTo(knapsack.singleValue());
        }
    }

    private static double getOptimalValue(int capacity, Knapsack[] knapsacks) {
        double value = 0;
        Arrays.sort(knapsacks, Collections.reverseOrder()); // n log n
        for (int i = 0; i < knapsacks.length && capacity > 0; i++) {
            int weight = capacity > knapsacks[i].weight ? knapsacks[i].weight : capacity;
            capacity -= weight;
            value += knapsacks[i].singleValue() * weight;
        }
        return Math.round(value * 10000.0) / 10000.0; // round 4 digits
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        Knapsack[] knapsacks = new Knapsack[n];
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            int weight = scanner.nextInt();
            knapsacks[i] = new Knapsack(value, weight);
        }
        System.out.println(getOptimalValue(capacity, knapsacks));
    }
} 
