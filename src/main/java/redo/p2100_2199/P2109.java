package redo.p2100_2199;

public class P2109 {

    class Solution {
        public String addSpaces(String s, int[] spaces) {
            StringBuilder buf = new StringBuilder(s.length() + spaces.length);

            int start = 0;

            for (int index : spaces) {
                buf.append(s, start, index);
                buf.append(' ');
                start = index;
            }

            buf.append(s, start, s.length());
            return buf.toString();
        }
    }

}
