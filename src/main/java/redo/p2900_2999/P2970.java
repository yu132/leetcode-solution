package redo.p2900_2999;

import java.util.ArrayList;
import java.util.List;

public class P2970 {

    class Solution {
        public int incremovableSubarrayCount(int[] nums) {
            int n = nums.length;
            int count = 0;
            for (int i = 0; i < n; ++i) {
                outer:
                for (int j = i + 1; j <= n; ++j) {
                    List<Integer> list = new ArrayList<>();
                    for (int k = 0; k < i; ++k) {
                        list.add(nums[k]);
                    }
                    for (int k = j; k < n; ++k) {
                        list.add(nums[k]);
                    }
                    for (int k = 1; k < list.size(); ++k) {
                        if (list.get(k) <= list.get(k - 1)) {
                            continue outer;
                        }
                    }
                    ++count;
                }
            }
            return count;
        }
    }

}
