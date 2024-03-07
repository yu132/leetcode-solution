package redo.p2900_2999;

import java.util.HashSet;
import java.util.Set;

public class P2956 {

    class Solution {
        public int[] findIntersectionValues(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int num : nums1) {
                set1.add(num);
            }
            int[] ans = new int[2];
            for (int num : nums2) {
                set2.add(num);
                if (set1.contains(num)) {
                    ++ans[1];
                }
            }
            for (int num : nums1) {
                if (set2.contains(num)) {
                    ++ans[0];
                }
            }
            return ans;
        }
    }

}
