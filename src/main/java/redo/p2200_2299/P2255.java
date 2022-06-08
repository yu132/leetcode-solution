package redo.p2200_2299;

public class P2255 {

    class Solution {
        public int countPrefixes(String[] words, String s) {
            int ans = 0;
            for (String word : words) {
                if (s.startsWith(word)) {
                    ++ans;
                }
            }
            return ans;
        }
    }

}
