package redo.p2200_2299;

import java.util.*;

public class P2248 {

    class Solution {
        public List<Integer> intersection(int[][] nums) {

            Set<Integer>[] sets = new Set[2];
            Arrays.setAll(sets, HashSet::new);

            for (int num : nums[0]) {
                sets[0].add(num);
            }

            int roll = 1;

            for (int i = 1; i < nums.length; ++i, roll ^= 1) {
                sets[roll].clear();
                for (int num : nums[i]) {
                    if (sets[roll ^ 1].contains(num)) {
                        sets[roll].add(num);
                    }
                }
            }

            List<Integer> list = new ArrayList<>(sets[roll ^ 1]);

            Collections.sort(list);

            return list;
        }
    }

}
