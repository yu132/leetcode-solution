package redo.p2400_2499;

public class P2496 {

    class Solution {
        public int maximumValue(String[] strs) {
            int max = 0;
            outer:
            for (String str : strs) {
                for (char ch : str.toCharArray()) {
                    if ('a' <= ch && ch <= 'z') {
                        max = Math.max(max, str.length());
                        continue outer;
                    }

                }
                max = Math.max(max, Integer.parseInt(str));
            }
            return max;
        }
    }

}
