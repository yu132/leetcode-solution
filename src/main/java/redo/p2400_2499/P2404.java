package redo.p2400_2499;

public class P2404 {

    class Solution {
        public int mostFrequentEven(int[] nums) {
            int[] counter = new int[100001];
            for (int num : nums) {
                ++counter[num];
            }
            int max = 0;
            for (int i = 0; i < counter.length; i += 2) {
                if (counter[i] > counter[max]) {
                    max = i;
                }
            }
            if (max == 0 && counter[max] == 0) {
                return -1;
            }
            return max;
        }
    }

}
