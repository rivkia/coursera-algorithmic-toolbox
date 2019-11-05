public class PartitionMinimum {
    // runtime is O(m*len(coins))
    private static int getPartition(int m) {
        int coins[] = {1, 3, 4};
        coins = new int[]{4, 5, 6, 7};

        // arr of count of the optimization coin number for every step until the current number of money
        // index = sum of money
        // value = optimal coin number
        int changeCount[] = new int[m + 1];


        for (int money = 1; money <= m; money++) {
            for (int i = 0; i < coins.length && coins[i] <= money; i++) {
                //if current coin choose , gets the optimal coin of money- currentcoin for this step
                int coinChangeCount = changeCount[money - coins[i]] + 1;
                if (changeCount[money] > coinChangeCount || i == 0)
                    changeCount[money] = coinChangeCount;
            }
        }
        //BTW: if we didn't have one coin, we would need to add in programing option to return nil, if we don;t have coins to return to current m
        return changeCount[m];
    }


}
