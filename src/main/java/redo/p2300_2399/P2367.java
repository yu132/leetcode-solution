package redo.p2300_2399;

public class P2367 {

    class Solution {
        public int arithmeticTriplets(int[] nums, int diff) {
            int ans = 0;
            for (int i = 0; i < nums.length; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    if (nums[i] + diff != nums[j]) {
                        continue;
                    }
                    for (int k = j + 1; k < nums.length; ++k) {
                        if (nums[j] + diff != nums[k]) {
                            continue;
                        }
                        ++ans;
                    }
                }
            }
            return ans;
        }
    }

}
