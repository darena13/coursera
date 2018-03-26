/**
 * Created by darena13 on 22.03.2018.
 */

import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        long result = 0;

        List<Integer> arrA = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arrA.add(i, a[i]);
        }

        List<Integer> arrB = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arrB.add(i, b[i]);
        }

        Collections.sort(arrA);
        Collections.sort(arrB);

        for (int i = 0; i < a.length; i++) {
            result = result + (long) arrA.get(i) * (long) arrB.get(i);
        }

//        for (int j = 0; j < a.length; j++) {
//            int maxA = arrA.get(0);
//            int maxAIndex = 0;
//
//            int maxB = arrB.get(0);
//            int maxBIndex = 0;
//
//            int minB = arrB.get(0);
//            int minBIndex = 0;
//
//            for (int i = 0; i < arrA.size(); i++) {
//                if (Math.abs(arrA.get(i)) > Math.abs(maxA)) {
//                    maxA = arrA.get(i);
//                    maxAIndex = i;
//                }
//            }
//
//            if (maxA > 0) {
//                for (int i = 0; i < arrB.size(); i++) {
//                    if (arrB.get(i) > maxB) {
//                        maxB = arrB.get(i);
//                        maxBIndex = i;
//                    }
//                }
//                result = result + maxA * maxB;
//                arrA.remove(maxAIndex);
//                arrB.remove(maxBIndex);
//            } else if (maxA <= 0) {
//                for (int i = 0; i < arrB.size(); i++) {
//                    if (arrB.get(i) < minB) {
//                        minB = arrB.get(i);
//                        minBIndex = i;
//                    }
//                }
//                result = result + maxA * minB;
//                arrA.remove(maxAIndex);
//                arrB.remove(minBIndex);
//            }
//        }

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

