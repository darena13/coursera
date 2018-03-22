/**
 * Created by d_kirsanova on 22.03.18.
 */

import java.util.Scanner;

public class Change {

    private static int getChange(int m) {
        int tens = m / 10;
        int fives = (m % 10) / 5;
        int ones = m % 5;

        return tens + fives + ones;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}