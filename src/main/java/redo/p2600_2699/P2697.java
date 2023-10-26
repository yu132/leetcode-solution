package redo.p2600_2699;

public class P2697 {

    class Solution {
        public String makeSmallestPalindrome(String s) {
            char[] chs = s.toCharArray();
            for (int i = 0; i < s.length() / 2; ++i) {
                chs[i] = chs[s.length() - 1 - i] = (char) Math.min(chs[i], chs[s.length() - 1 - i]);
            }
            return new String(chs);
        }
    }

}
