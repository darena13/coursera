/**
 * Created by d_kirsanova on 27.03.18.
 */

import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";

        List<String> strArr = new ArrayList<>(Arrays.asList(a));
//
//        Collections.sort(strArr, Collections.reverseOrder());

        int longestNumberLength = 0;
        for (int i = 0; i < strArr.size(); i++) {
            if (strArr.get(i).length() > longestNumberLength) {
                longestNumberLength = strArr.get(i).length();
            }
        }

        int nDigit = 0;
        int maxNDigit = 0;
        for (int i = 0; i < strArr.size(); i++) {
            if (strArr.get(i).length() >= nDigit + 1 && (strArr.get(i).charAt(nDigit) - '0') > maxNDigit) {
                maxNDigit = strArr.get(i).charAt(nDigit) - '0';
            }
        }

        List<String> maxNDigitNumbers = new ArrayList<>();

        for (int i = 0; i < strArr.size(); i++) {
            if (strArr.get(i).length() >= nDigit + 1 && (strArr.get(i).charAt(nDigit) - '0') == maxNDigit) {
                maxNDigitNumbers.add(strArr.get(i));
            }
        }



//        for (String s : maxNDigitNumbers) {
//            result = new StringBuilder().append(result).append(s).toString();
//        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
