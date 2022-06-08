package redo.p2100_2199;

public class P2108 {

    class Solution {
        public String firstPalindrome(String[] words) {
            for (int i = 0; i < words.length; ++i) {
                if (isPalindromic(words[i])) {
                    return words[i];
                }
            }
            return "";
        }

        boolean isPalindromic(String str) {
            for (int i = 0; i < str.length() / 2; ++i) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

}
