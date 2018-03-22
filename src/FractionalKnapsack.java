/**
 * Created by d_kirsanova on 22.03.18.
 */

import java.util.Scanner;

public class FractionalKnapsack {

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;

        int n = values.length;
        int itemCount = values.length;

        while (capacity > 0 & itemCount > 0) {
            double maxValuePerWeight = 0;
            int maxValuePerWeightIndex = 0;
            for (int i = 0; i < n; i++) {
                if (values[i] != 0 & weights[i] != 0 && values[i] / weights[i] > maxValuePerWeight) {
                    maxValuePerWeight = (double) values[i] / (double) weights[i];
                    maxValuePerWeightIndex = i;
                }
            }

            int weight = Math.min(capacity, weights[maxValuePerWeightIndex]);
            capacity = capacity - weight;
            value = value + weight * maxValuePerWeight;
            values[maxValuePerWeightIndex] = 0;
            weights[maxValuePerWeightIndex] = 0;
            itemCount--;
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
}
