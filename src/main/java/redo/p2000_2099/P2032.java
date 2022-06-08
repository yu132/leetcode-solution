package redo.p2000_2099;

import java.util.ArrayList;
import java.util.List;

public class P2032 {

    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            boolean[] set1 = new boolean[101], set2 = new boolean[101], set3 = new boolean[101];
            for (int num : nums1) {
                set1[num] = true;
            }
            for (int num : nums2) {
                set2[num] = true;
            }
            for (int num : nums3) {
                set3[num] = true;
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i < 101; ++i) {
                if ((set1[i] ? 1 : 0) + (set2[i] ? 1 : 0) + (set3[i] ? 1 : 0) > 1) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }

}
