package redo.p2200_2299;

import java.util.ArrayList;
import java.util.List;

public class P2200 {

    class Solution {
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            List<Integer> ans = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == key) {
                    for (int j = Math.max(0, i - k); j <= i; ++j) {
                        if (visited[j]) {
                            continue;
                        }
                        visited[j] = true;
                        ans.add(j);
                    }
                    for (int j = i + 1; j <= Math.min(i + k, nums.length - 1); ++j) {
                        if (visited[j]) {
                            continue;
                        }
                        visited[j] = true;
                        ans.add(j);
                    }
                }
            }
            return ans;
        }
    }

}
