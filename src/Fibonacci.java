import java.util.Scanner;

public class Fibonacci {
//    private static long calc_fib(int n) {
//        if (n <= 1)
//            return n;
//
//        return calc_fib(n - 1) + calc_fib(n - 2);
//    }

    private static long calcFibFast(int n) {
        if (n <= 1) {
            return n;
        }

        long[] fibNums = new long[n + 1];
        fibNums[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            fibNums[i] = fibNums[i - 1] + fibNums[i - 2];
        }

        return fibNums[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calcFibFast(n));
    }
}
