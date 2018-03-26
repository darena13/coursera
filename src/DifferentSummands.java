/**
 * Created by darena13 on 24.03.2018.
 */

import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();

        if (n <= 2) {
            summands.add(n);
            return summands;
        }

        summands.add(1);
        n = n - 1;
        int i = 1;
        while (n > 0) {
            summands.add(i, summands.get(i - 1) + 1);
            n = n - summands.get(i);
            if (n <= summands.get(i)) {
                summands.set(i, summands.get(i) + n);
                n = 0;
            }
            i++;
        }

        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}


