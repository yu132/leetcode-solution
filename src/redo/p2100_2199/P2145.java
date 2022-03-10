package redo.p2100_2199;

public class P2145 {

    class Solution {
        public int numberOfArrays(int[] differences, int lower, int upper) {
            long val = 0, min = 0, max = 0;
            for (int diff : differences) {
                val += diff;
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
            return (int) Math.max(0, upper - lower - (max - min) + 1);
        }
    }

}
