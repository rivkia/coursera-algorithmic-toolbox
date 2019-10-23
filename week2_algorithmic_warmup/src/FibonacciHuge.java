import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }


    private static long getFibonacciHugeBetter(long n, long m) {
        if (n <= 1)
            return n;
        ArrayList<Long> mSequence = new ArrayList<Long>();

        long previous = 0;
        long current = 1;
        boolean isEndSequence = false;
        for (long i = 0; i <= n && !isEndSequence; ++i) {
            mSequence.add(previous);
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
            isEndSequence = previous == 0 && current == 1;
        }
        long mSequenceIndex = n % mSequence.size();
        return mSequence.get((int) mSequenceIndex);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeBetter(n, m));
    }
}

