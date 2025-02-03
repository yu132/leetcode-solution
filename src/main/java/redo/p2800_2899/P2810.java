package redo.p2800_2899;

public class P2810 {

    class Solution {
        public String finalString(String s) {
            StringBuilder buf = new StringBuilder();
            for (char ch : s.toCharArray()) {
                if (ch == 'i') {
                    buf.reverse();
                } else {
                    buf.append(ch);
                }
            }
            return buf.toString();
        }
    }

}
