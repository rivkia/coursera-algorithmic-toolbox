import java.util.Scanner;

public class Change {
    private int numOfCoins;

    private static int getChange(int money) {
        int coins[] = {10, 5, 1};
        int numOfCoins = 0;
        for (int i = 0; i < coins.length && money > 0; i++) {
            numOfCoins += money / coins[i];
            money = money % coins[i];
        }
        return numOfCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

