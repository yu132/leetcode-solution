package redo.p1800_1899;

public class P1881 {

    class Solution {
        public String maxValue(String n, int x) {
            if (n.startsWith("-")) {
                for (int i = 1; i < n.length(); ++i) {
                    if (x < n.charAt(i) - '0') {
                        return n.substring(0, i) + x + n.substring(i);
                    }
                }
            } else {
                for (int i = 0; i < n.length(); ++i) {
                    if (x > n.charAt(i) - '0') {
                        return n.substring(0, i) + x + n.substring(i);
                    }
                }
            }
            return n + x;
        }
    }

}
