import java.util.*;
import java.io.*;

public class MajorityElement {

    // using recursive 2,runtime is 2T(n/2) + n = o(n log n)
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right)
            return -1;

        if (left + 1 == right)
            return a[left];

        int middleIndex = left + (right - left) / 2;
        int leftMajority = getMajorityElement(a, left, middleIndex);
        int rightMajority = getMajorityElement(a, middleIndex, right);

        if (leftMajority == -1 && rightMajority == -1)
            return -1;

        int countLeft = 0;
        int countRight = 0;
        int count = right - left;
        for (int i = left; i < right; i++) {
            if (a[i] == leftMajority)
                countLeft++;
            if (a[i] == rightMajority)
                countRight++;
        }
        if (countLeft > count / 2)
            return leftMajority;
        if (countRight > count / 2)
            return rightMajority;
        return -1;
    }

    // using quick search algorithm to sort and find the max long length
    // runtime is worse case o(n^2) , and omega of log n
    private static int getMajorityElementSort(int[] a, int left, int right) {
        if (left >= right) {
            return -1;
        }
        int[] m = partition(a, left, right);
        if (m[1] - m[0] + 1 > a.length / 2)
            return m[0];
        int leftLength = m[0] - left;
        int rightLength = right - m[1];
        if (leftLength > rightLength && leftLength > a.length / 2)
            return getMajorityElementSort(a, left, m[0] - 1);
        else if (rightLength > leftLength && rightLength > a.length / 2)
            return getMajorityElementSort(a, m[1] + 1, right);
        else
            return -1;
    }

//    private static void quickSort(int[] a, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//        int[] m = partition(a, left, right);
//        quickSort(a, left, m[0] - 1);
//        quickSort(a, m[1] + 1, right);
//    }


    private static int[] partition(int[] a, int left, int right) {
        int x = a[left];
        int m1 = left;
        int m2 = left;
        for (int i = left + 1; i <= right; i++) {
            if (a[i] < x) {
                m1++;
                m2++;
                swap(a, i, m2);
                if (m1 < m2)
                    swap(a, m1, m2);
            }
            if (a[i] == x) {
                m2++;
                swap(a, i, m2);
            }
        }
        swap(a, left, m1);
        return new int[]{m1, m2};
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        if (getMajorityElement(a, 0, a.length ) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

