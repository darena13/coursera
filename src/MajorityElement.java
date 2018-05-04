import java.util.*;
import java.io.*;

/**
 * Created by d_kirsanova on 03.05.18.
 */

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        //пустой массив
        if (left == right) {
            return -1;
        }
        //массив из одного элемента
        if (left + 1 == right) {
            return a[left];
        }
        //массив из двух
        if (left + 2 == right) {
            if (a[left] == a[right - 1]) {
                return a[left];
            } else {
                return -1;
            }
        }
        //массив из трех и более
        int mid = (right - left) / 2;

        int rightMajor = getMajorityElement(a, mid, right);

        if (rightMajor != -1) {
            return rightMajor;
        }

        int leftMajor = getMajorityElement(a, left, mid);

        if (leftMajor != -1) {
            return leftMajor;
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
        if (getMajorityElement(a, 0, a.length) != -1) {
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
