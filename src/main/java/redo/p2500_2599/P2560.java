package redo.p2500_2599;

import java.util.function.Function;

public class P2560 {

    class Solution {
        public int minCapability(int[] nums, int k) {
            return binarySearchMin(1, 1000000000, mid -> {
                int count = 0;
                for (int i = 0; i < nums.length; ++i) {
                    if (nums[i] <= mid) {
                        ++count;
                        ++i;
                    }
                }
                return count >= k;
            });
        }

        // 寻找符合条件的最小值
        //judgeRange = [low,high-1], returnRange = [low,high]
        public int binarySearchMin(int low, int high, Function<Integer, Boolean> judge) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (judge.apply(mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }
    }

}
