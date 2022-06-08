package redo.p2100_2199;

public class P2114 {

    class Solution {
        public int mostWordsFound(String[] sentences) {
            int ans = 0;
            for (String sentence : sentences) {
                int space = 0;
                for (char ch : sentence.toCharArray()) {
                    if (ch == ' ') {
                        ++space;
                    }
                }
                ans = Math.max(ans, space + 1);
            }
            return ans;
        }
    }

}
