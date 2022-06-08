package redo.p1700_1799;

public class P1753 {

    class Solution {
        public int maximumScore(int a, int b, int c) {
            if (a + b <= c) {
                return a + b;
            }
            if (b + c <= a) {
                return b + c;
            }
            if (a + c <= b) {
                return a + c;
            }
            return (a + b + c) / 2;
        }
    }

}
