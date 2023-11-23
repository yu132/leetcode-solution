package redo.p2700_2799;

public class P2734 {

    class Solution {
        public String smallestString(String s) {
            int i = 0;
            char[] chs = s.toCharArray();
            while (i < chs.length && chs[i] == 'a') {
                ++i;
            }
            if (i == chs.length) {
                chs[i - 1] = 'z';
            }
            while (i < chs.length && chs[i] != 'a') {
                chs[i] = (char) (chs[i] - 1);
                ++i;
            }
            return String.valueOf(chs);
        }
    }

}
