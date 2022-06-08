package redo.p2100_2199;

import java.util.ArrayList;
import java.util.List;

public class P2150 {

    class Solution {
        public List<Integer> findLonely(int[] nums) {
            int start = -1, end = 1000002;
            int[] count = count(nums, start, end);
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < count.length - 1; ++i) {
                if (count[i - 1] == 0 && count[i] == 1 && count[i + 1] == 0) {
                    list.add(i - 1);
                }
            }
            return list;
        }

        int[] count(int[] nums, int start, int end) {
            int[] count = new int[end - start];
            for (int num : nums) {
                ++count[num - start];
            }
            return count;
        }
    }

}
