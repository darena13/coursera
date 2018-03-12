import java.util.*;

public class GCD {
//    private static int gcd_naive(int a, int b) {
//        int current_gcd = 1;
//        for(int d = 2; d <= a && d <= b; ++d) {
//            if (a % d == 0 && b % d == 0) {
//                if (d > current_gcd) {
//                    current_gcd = d;
//                }
//            }
//        }
//
//        return current_gcd;
//    }

    private static int gcd(int big, int small) {
        if (small == 0) {
            return big;
        }
        int rest = big % small;
        return gcd(small, rest);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int big = Math.max(a, b);
        int small = Math.min(a, b);
        System.out.println(gcd(big, small));
    }
}
