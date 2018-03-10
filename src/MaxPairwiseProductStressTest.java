import java.util.*;
import java.io.*;

public class MaxPairwiseProductStressTest {

    public static void main(String[] args) {
//        FastScanner scanner = new FastScanner(System.in);
//        int n = scanner.nextInt();
//        int[] numbers = new int[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = scanner.nextInt();
//        }

        int n = 100;
        long[] nums = new long[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = n - i;
//        }

        Random r = new Random();
        boolean notStop = true;
        while (notStop) {
            System.out.println("new array");
            for (int i = 0; i < n; i++) {
                nums[i] = r.nextInt(n);
            }
            System.out.println("test");
            long sumOne = getMaxPairwiseProduct(nums);
            System.out.println("sumOne");
            long sumTwo  = getMaxPairwiseProductSlow(nums);
            System.out.println("sumTwo");
            if (sumOne != sumTwo) {
                notStop = false;
                System.out.println("WRONG");
            }
        }

//        System.out.println(getMaxPairwiseProduct(nums));
    }

    static long getMaxPairwiseProduct(long[] numbers) {
        int n = numbers.length;
        int indexOne = 0;
        for (int i = 1; i < n; i++) {
            if (numbers[indexOne] < numbers[i]) {
                indexOne = i;
            }
        }
        int indexTwo = 0;
        if (indexOne == 0) {
           indexTwo = 1;
        }
        for (int i = 1; i < n; i++) {
            if (i != indexOne && numbers[indexTwo] < numbers[i]) {
                indexTwo = i;
            }
        }

        return numbers[indexOne]*numbers[indexTwo];
    }

    static long getMaxPairwiseProductSlow(long[] numbers) {
        long product = 0;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                product = Math.max(product, numbers[i] * numbers[j]);
            }
        }
        return product;
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
