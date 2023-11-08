package redo.p2500_2599;

public class P2586 {

    class Solution {
        public int vowelStrings(String[] words, int left, int right) {
            int ans = 0;
            char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u'};
            outer:
            for (int i = left; i <= right; ++i) {
                boolean start = false, end = false;
                for (char ch : vowel) {
                    if (words[i].charAt(0) == ch) {
                        start = true;
                    }
                    if (words[i].charAt(words[i].length() - 1) == ch) {
                        end = true;
                    }
                }
                if (start && end) {
                    ++ans;
                }
            }
            return ans;
        }
    }

}
