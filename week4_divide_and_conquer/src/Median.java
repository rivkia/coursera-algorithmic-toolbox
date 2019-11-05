import java.util.HashMap;

public class Median {

    static int findMedian(int[] a, int[] b, int i) {
        int j = a.length - i - 1;
        if (b[j] < a[i]) {
            i = i - (b.length - i) / 2;
            return findMedian(a, b, i);
        }
        int num1 = a[i];
        int num2 = b[j];
        if (i > 0 && i < a.length - 1 && b[j - 1] > a[i])
            num1 = b[j - 1];

        return (num1 + num2) / 2;
    }

    public static void main(String[] args) {
//        int[] ar1 = {1, 12, 15, 26, 38};
//        int[] ar2 = {2, 13, 27, 30, 45};
//        int median = findMedian(ar1, ar2, ar1.length - 1);
//        System.out.println(median);
        HashMap<Integer, String> hm = new HashMap<Integer, String>();

        /*Adding elements to HashMap*/
        hm.put(12, "geeks");
        hm.put(2, "practice");
        hm.put(7, "contribute");

        System.out.println("\nHashMap object output :\n\n" + hm);

        // store data with duplicate key
        hm.put(12, "geeks");
        hm.put(13, "geeks");
        System.out.println("\nAfter inserting duplicate key :\n\n" + hm);
    }
}
