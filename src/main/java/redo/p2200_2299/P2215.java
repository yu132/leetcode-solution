package redo.p2200_2299;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P2215 {

    class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            for (int num : nums1) {
                set1.add(num);
            }
            Set<Integer> setCommon = new HashSet<>();
            for (int num : nums2) {
                if (set1.contains(num)) {
                    setCommon.add(num);
                }
            }
            Set<Integer> ans1 = new HashSet<>(), ans2 = new HashSet<>();

            for (int num : nums1) {
                if (!setCommon.contains(num)) {
                    ans1.add(num);
                }
            }

            for (int num : nums2) {
                if (!setCommon.contains(num)) {
                    ans2.add(num);
                }
            }

            return new ArrayList<List<Integer>>() {{
                add(new ArrayList<>(ans1));
                add(new ArrayList<>(ans2));
            }};
        }
    }

}
