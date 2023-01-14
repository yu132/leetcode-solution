package redo.p2400_2499;

public class P2425 {

    class Solution {
        public int xorAllNums(int[] nums1, int[] nums2) {
            int xor = 0;
            if (nums1.length % 2 == 1) {
                for (int num : nums2) {
                    xor ^= num;
                }
            }
            if (nums2.length % 2 == 1) {
                for (int num : nums1) {
                    xor ^= num;
                }
            }
            return xor;
        }
    }

}
