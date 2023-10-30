package redo.p2600_2699;

public class P2645 {

    class Solution {
        public int addMinimum(String word) {
            String pattern = "abc";
            int index = 0;
            int ans = 0;
            for (char ch : word.toCharArray()) {
                while (ch != pattern.charAt(index % 3)) {
                    ++ans;
                    ++index;
                }
                ++index;
            }
            if (word.charAt(word.length() - 1) == 'a') {
                return ans + 2;
            } else if (word.charAt(word.length() - 1) == 'b') {
                return ans + 1;
            } else {
                return ans;
            }
        }
    }

}
