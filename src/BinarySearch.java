import java.io.*;
import java.util.*;

/**
 * Created by d_kirsanova on 03.05.18.
 */

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length;
        int mid = (right - left) / 2;
        if (x == a[mid]) {
            return mid;
        }
        if (x > a[mid]) { //берем праву часть
            left = mid;
        } else {
            right = mid; //берем левую часть
        }
        //рекурсируем
        return binarySearch(a, x, left, right);
    }

    private static int binarySearch(int[] a, int x, int left, int right) {
        int mid = (left + right) / 2;
        if ((right - left) == 1 && x != a[mid]) {
            return -1;
        }
        if (x == a[mid]) {
            return mid;
        }
        if (x > a[mid]) {
            left = mid;
        } else {
            right = mid;
        }
        return binarySearch(a, x, left, right);
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            System.out.print(binarySearch(a, b[i]) + " ");
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