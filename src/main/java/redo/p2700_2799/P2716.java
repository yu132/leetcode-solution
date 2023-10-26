package redo.p2700_2799;

public class P2716 {

    class Solution {
        public int minimizedStringLength(String s) {
            boolean[] set = new boolean[26];
            int ans = 0;
            for (char ch : s.toCharArray()) {
                if (!set[ch - 'a']) {
                    ++ans;
                    set[ch - 'a'] = true;
                }
            }
            return ans;
        }
    }

}
