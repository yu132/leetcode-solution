package redo.p2800_2899;

public class P2864 {

    class Solution {
        public String maximumOddBinaryNumber(String s) {
            int c1 = 0;
            char[] chs = s.toCharArray();
            for (char ch : chs) {
                if (ch == '1') {
                    ++c1;
                }
            }
            chs[chs.length - 1] = '1';
            c1--;
            for (int i = 0; i < c1; ++i) {
                chs[i] = '1';
            }
            for (int i = c1; i < s.length() - 1; ++i) {
                chs[i] = '0';
            }
            return new String(chs);
        }
    }

}
