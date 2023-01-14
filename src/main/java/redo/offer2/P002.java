package redo.offer2;

public class P002 {

    class Solution {
        public String addBinary(String a, String b) {
            int inc = 0;
            int max = Math.max(a.length(), b.length());
            StringBuilder buf = new StringBuilder(max + 1);
            for (int i = 0; i < max; ++i) {
                int val = get(i, a) + get(i, b) + inc;
                buf.append(val % 2);
                inc = val / 2;
            }
            if (inc == 1) {
                buf.append(1);
            }
            return buf.reverse().toString();
        }

        int get(int index, String s) {
            if (index >= s.length()) {
                return 0;
            }
            return s.charAt(s.length() - 1 - index) - '0';
        }
    }

}
