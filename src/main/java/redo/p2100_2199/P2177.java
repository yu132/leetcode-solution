package redo.p2100_2199;

public class P2177 {

    class Solution {
        public long[] sumOfThree(long num) {
            if (num % 3 != 0) {
                return new long[0];
            }
            long x = num / 3;
            return new long[]{x - 1, x, x + 1};
        }
    }

}
