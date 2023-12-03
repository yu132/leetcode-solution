package redo.p2700_2799;

public class P2749 {

    class Solution {
        public int makeTheIntegerZero(int num1, int num2) {
            for (int i = 1; i < 60; ++i) {
                long val = num1 - (long) i * num2;
                if (val < 0) {
                    return -1;
                }
                if (Long.bitCount(val) <= i && val >= i) {
                    return i;
                }
            }
            return -1;
        }
    }

}
