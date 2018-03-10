import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by darena13 on 08.03.2018.
 */
public class MaxPairwiseProduct {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] numbers = new long[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
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
