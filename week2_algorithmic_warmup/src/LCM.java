import java.util.*;
import java.math.BigInteger;

public class LCM {
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }

  private static BigInteger lcm_better(int a, int b) {
    int divider = gcd(a,b);
    BigInteger num1=  new BigInteger(String.valueOf(a/divider))  ;
    BigInteger num2  =new BigInteger(String.valueOf(b/divider))  ;
    BigInteger  result = new BigInteger(String.valueOf(divider))  ;
    result = result.multiply(num1).multiply(num2);
    return result;
  }

  private static int gcd(int a, int b) {
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

    System.out.println(lcm_better(a, b));
  }
}
