import java.util.*;

public class LCM {

    private static long lcm(int a, int b) {
//        long result = 1;
//        int bigOne = Math.max(a, b);
//        for (int i = 2; i <= bigOne; i++) {
//            int countOne = 0;
//            while (a % i == 0) {
//                a = a / i;
//                countOne++;
//            }
//            int countTwo = 0;
//            while (b % i == 0) {
//                b = b / i;
//                countTwo++;
//            }
//            if (countOne != 0 || countTwo != 0) {
//                result = result * (long) Math.pow(i, Math.max(countOne, countTwo));
//            }
//        }
//        return result;

        int bigOne = Math.max(a, b);
        int smallOne = Math.min(a, b);

        long gcd = gcd(bigOne, smallOne);

        return (a / gcd) * b;
    }

    private static long gcd(int big, int small) {
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
        System.out.println(lcm(a, b));
    }
}
