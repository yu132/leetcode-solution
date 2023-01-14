package redo.p2400_2499;

public class P2455 {

    class Solution {
        public int averageValue(int[] nums) {
            int sum = 0, count = 0;
            for (int num : nums) {
                if (num % 3 == 0 && num % 2 == 0) {
                    sum += num;
                    ++count;
                }
            }
            return count == 0 ? 0 : sum / count;
        }
    }

}
