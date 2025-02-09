package redo.p3000_3099;

public class P3001 {

    class Solution {
        public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {

            if (a == e) {
                if (a == c && between(b, f, d)) {
                    return 2;
                }
                return 1;
            }
            if (b == f) {
                if (b == d && between(a, e, c)) {
                    return 2;
                }
                return 1;
            }

            if (c - d == e - f) {
                if (c - d == a - b && between(c, e, a)) {
                    return 2;
                }
                return 1;
            }
            if (c + d == e + f) {
                if (c + d == a + b && between(c, e, a)) {
                    return 2;
                }
                return 1;
            }

            return 2;
        }

        boolean between(int a, int b, int x) {
            if (a < x && x < b) {
                return true;
            }
            if (b < x && x < a) {
                return true;
            }
            return false;
        }
    }


}
