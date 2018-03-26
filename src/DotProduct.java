/**
 * Created by darena13 on 22.03.2018.
 */

import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        int n = a.length;
        long result = 0;
//        for (int i = 0; i < a.length; i++) {
//            result += a[i] * b[i];
//        }

        List<Integer> arrA = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arrA.add(i, a[i]);
        }

        List<Integer> arrB = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arrB.add(i, b[i]);
        }

//        Collections.sort(arrA);
//        Collections.sort(arrB);

        int maxA = arrA.get(arrA.size());
        int maxB = arrB.get(arrB.size());
        int minB = arrB.get(0);

        for (int i = 0; i < n; i++) {
            if (arrA.get(i) > maxA) {
                maxA = arrA.get(i);
            }
        }

        if (maxA > 0) {
            for (int i = 0; i < n; i++) {
                if (arrB.get(i) > maxB) {
                    maxB = arrB.get(i);
                }
            }
            result = result + maxA * maxB;
            arrA.remove(maxA);
            arrB.remove(maxB);
        } else if (maxA < 0){
            for (int i = 0; i < n; i++) {
                if (arrB.get(i) < minB) {
                    minB = arrB.get(i);
                }
            }
            result = result + maxA * minB;
            arrA.remove(maxA);
            arrB.remove(minB);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}

