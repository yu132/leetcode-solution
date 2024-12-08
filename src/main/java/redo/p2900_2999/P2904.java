package redo.p2900_2999;

public class P2904 {

    class Solution {
        public String shortestBeautifulSubstring(String s, int k) {
            int index = 0;
            while (index < s.length() && s.charAt(index) == '0') {
                ++index;
            }
            if (index == s.length()) {
                return "";
            }
            int count = 0;
            int left = index;
            while (count < k) {
                if (index == s.length()) {
                    return "";
                }
                if (s.charAt(index) == '1') {
                    ++count;
                }
                ++index;
            }
            int right = index;
            String min = s.substring(left, right);
            if (min.length() == 1) {
                return min;
            }
            while (right < s.length()) {
                ++left;
                while (s.charAt(left) == '0') {
                    ++left;
                }
                while (right < s.length() && s.charAt(right) == '0') {
                    ++right;
                }
                if (right == s.length()) {
                    return min;
                }
                ++right;
                if (right - left < min.length()) {
                    min = s.substring(left, right);
                } else if (right - left == min.length()) {
                    String temp;
                    if ((temp = s.substring(left, right)).compareTo(min) < 0) {
                        min = temp;
                    }
                }
            }
            return min;
        }
    }

    public static void main(String[] args) {
        new P2904().new Solution().shortestBeautifulSubstring("111011110", 1);
    }

}
