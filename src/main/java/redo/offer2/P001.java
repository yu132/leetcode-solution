package redo.offer2;

public class P001 {

    class Solution {
        public int divide(int a, int b) {
            if (a == Integer.MIN_VALUE && b == -1) {
                return Integer.MAX_VALUE;
            }
            if (b == 1) {
                return a;
            }
            if (a == 0) {
                return 0;
            }
            boolean sign = (a ^ b) >= 0;
            a = a > 0 ? -a : a;
            b = b > 0 ? -b : b;
            int ans = 0;
            while (a <= b) {
                int base = 1, div = b;
                while (a - div <= div) {
                    base <<= 1;
                    div <<= 1;
                }
                ans += base;
                a -= div;
            }
            return sign ? ans : -ans;
        }
    }

    public static void main(String[] args) {

    }


}
