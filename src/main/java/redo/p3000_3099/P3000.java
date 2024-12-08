package redo.p3000_3099;

public class P3000 {

    class Solution {
        public int areaOfMaxDiagonal(int[][] dimensions) {
            int max = 0;
            int maxArea = 0;
            for (int[] item : dimensions) {
                if (item[0] * item[0] + item[1] * item[1] > max) {
                    max = item[0] * item[0] + item[1] * item[1];
                    maxArea = item[0] * item[1];
                } else if (item[0] * item[0] + item[1] * item[1] == max) {
                    maxArea = Math.max(maxArea, item[0] * item[1]);
                }
            }
            return maxArea;
        }
    }
}
