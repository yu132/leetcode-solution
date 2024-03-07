package redo.p2800_2899;

import redo.testUtil.Arrs;

import java.util.ArrayList;
import java.util.List;

public class P2845 {

    class Solution {
        public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
            List<Integer> list = new ArrayList<>();
            int count = 0;
            for (int num : nums) {
                if (num % modulo == k) {
                    list.add(count);
                    count = 0;
                } else {
                    ++count;
                }
            }
            list.add(count);
            long ans = 0;
            long[] hash = new long[Math.min(modulo, list.size())];
            for (int i = 0; i < list.size(); ++i) {
                if (k == 0) {
                    ans += ((long) list.get(i) + 1) * list.get(i) / 2;
                }
                int idx = (i % modulo - k + modulo) % modulo;
                if (idx < hash.length) {
                    ans += hash[idx] * (list.get(i) + 1);
                }
                hash[i % modulo] += (list.get(i) + 1);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        new P2845().new Solution().countInterestingSubarrays(Arrs.buildL("[3,3]"), 5, 3);
    }

}
