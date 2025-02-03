package redo.p2900_2999;

public class P2947 {

    class Solution {
        public int beautifulSubstrings(String s, int k) {
            int ans = 0;
            for (int i = 2; i <= s.length(); i += 2) {
                if ((i / 2) * (i / 2) % k != 0) {
                    continue;
                }
                int cV = 0;
                for (int j = 0; j < i; ++j) {
                    if (isVowel(s.charAt(j))) {
                        ++cV;
                    }
                }
                if (cV * 2 == i) {
                    ++ans;
                }
                for (int j = i; j < s.length(); ++j) {
                    if (isVowel(s.charAt(j))) {
                        ++cV;
                    }
                    if (isVowel(s.charAt(j - i))) {
                        --cV;
                    }
                    if (cV * 2 == i) {
                        ++ans;
                    }
                }
            }
            return ans;
        }

        public boolean isVowel(char ch) {
            return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                    ;
        }
    }

}
