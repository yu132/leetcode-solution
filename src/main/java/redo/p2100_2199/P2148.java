package redo.p2100_2199;

public class P2148 {

    class Solution {
        public int countElements(int[] nums) {
            int min = Integer.MAX_VALUE, countMin = 0,
                    max = Integer.MIN_VALUE, countMax = 0;

            for (int num : nums) {
                if (num < min) {
                    min = num;
                    countMin = 1;
                } else if (num == min) {
                    ++countMin;
                }
                if (num > max) {
                    max = num;
                    countMax = 1;
                } else if (num == max) {
                    ++countMax;
                }
            }

            if (min == max) {
                return 0;
            }
            return nums.length - countMax - countMin;
        }
    }

}
