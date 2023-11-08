package redo.p2900_2999;

public class P2917 {

    class Solution {
        public int findKOr(int[] nums, int k) {
            int ans = 0;
            for (int i = 0; i < 31; ++i) {
                int count = 0;
                for (int num : nums) {
                    count += (num & (1 << i)) > 0 ? 1 : 0;
                }
                if (count >= k) {
                    ans |= (1 << i);
                }
            }
            return ans;
        }
    }

}
