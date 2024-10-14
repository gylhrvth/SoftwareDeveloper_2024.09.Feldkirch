package Akif_Malik.week05;

import java.util.Scanner;

public class chatgpt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bitte gib Wort 1 ein:\n>>> ");
        String str1 = scanner.nextLine();

        System.out.print("Bitte gib Wort 2 ein:\n>>> ");
        String str2 = scanner.nextLine();

        String result = findLongestCommonSubstring(str1, str2);
        System.out.println("längster gemeinsamer Substring:\n" + result);
    }

    public static String findLongestCommonSubstring(String str1, String str2) {
        int maxLength = 0;
        int endIndex = 0;

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndex = i; // save the end index of the substring
                    }
                }
            }
        }

        return str1.substring(endIndex - maxLength, endIndex);
    }
}


