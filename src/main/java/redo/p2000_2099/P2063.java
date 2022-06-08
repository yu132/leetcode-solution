package redo.p2000_2099;

public class P2063 {

    class Solution {
        public long countVowels(String word) {
            long ans = 0;
            for (int i = 0; i < word.length(); ++i) {
                if (isLowercaseVowel(word.charAt(i))) {
                    ans += (long) (i + 1) * (word.length() - i);
                }
            }
            return ans;
        }

        public boolean isLowercaseVowel(char ch) {
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
        }

    }

}
