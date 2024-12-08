package redo.p3200_3299;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class P3264 {

    class Solution {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
            TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
            for (int i = 0; i < nums.length; ++i) {
                map.computeIfAbsent(nums[i], x -> new TreeSet<>()).add(i);
            }
            for (int i = 0; i < k; ++i) {
                Map.Entry<Integer, TreeSet<Integer>> firstEntry = map.firstEntry();
                int idx = firstEntry.getValue().first();
                nums[idx] *= multiplier;
                if (firstEntry.getValue().size() == 1) {
                    map.remove(firstEntry.getKey());
                } else {
                    firstEntry.getValue().remove(idx);
                }
                map.computeIfAbsent(nums[idx], x -> new TreeSet<>()).add(idx);
            }
            return nums;
        }
    }

}
