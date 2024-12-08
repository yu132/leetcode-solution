package redo.p2300_2399;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P2363 {

    class Solution {
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            Map<Integer, Integer> ans = new TreeMap<>();
            for (int[] nums : items1) {
                ans.merge(nums[0], nums[1], Integer::sum);
            }
            for (int[] nums : items2) {
                ans.merge(nums[0], nums[1], Integer::sum);
            }
            return ans.entrySet().stream().map(entry -> Arrays.asList(entry.getKey(), entry.getValue())).collect(Collectors.toList());
        }
    }

}
