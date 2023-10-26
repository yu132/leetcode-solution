package redo.p2600_2699;

public class P2696 {

    class Solution {
        public int minLength(String s) {
            String temp;
            while ((temp = s.replaceAll("AB", "").replaceAll("CD", "")).length() != s.length()) {
                s = temp;
            }
            return s.length();
        }
    }

    public static class P2656 {
    }
}
