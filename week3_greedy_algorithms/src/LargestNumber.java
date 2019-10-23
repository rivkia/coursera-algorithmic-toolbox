import java.lang.reflect.Array;
import java.util.*;

public class LargestNumber {
    private static String largestNumber(ArrayList<String> digits) {
        String result = "";
        while (digits.size() > 0) {
            int maxDigitIndex = 0;
            for (int i = 1; i < digits.size(); i++) {
                if (compareDigits( digits.get(i), digits.get(maxDigitIndex)))
                        maxDigitIndex = i;
            }
            result += digits.get(maxDigitIndex);
            digits.remove(maxDigitIndex);
        }
        return result;
    }


    private static boolean compareDigits(String a, String b) {
        if (a.length() == 0) return false;
        if (b.length() == 0) return true;
        if (a.charAt(0) > b.charAt(0))
            return true;
        return (a + b).compareTo(b + a) > 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<String> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.next());
        }
        System.out.println(largestNumber(a));
    }
}

