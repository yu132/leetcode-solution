package redo.p2800_2899;

public class P2825 {

    class Solution {
        public boolean canMakeSubsequence(String str1, String str2) {
            int len = 0;
            for (int i = 0; i < str1.length() && len < str2.length(); ++i) {

                if (str1.charAt(i) == str2.charAt(len)) {
                    ++len;
                } else if ((str1.charAt(i) - 'a' + 1) % 26 == str2.charAt(len) - 'a') {
                    ++len;
                }
            }
            return len == str2.length();
        }
    }

}
