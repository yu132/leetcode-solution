package redo.p2100_2199;

import java.util.Arrays;

public class P2164 {

    class Solution {
        public int[] sortEvenOdd(int[] nums) {
            int[] odd = new int[nums.length / 2],
                    even = new int[(nums.length + 1) / 2];
            for (int i = 0, j = 0, k = 0; i < nums.length; ) {
                if (i % 2 == 0) {
                    even[k++] = nums[i++];
                } else {
                    odd[j++] = nums[i++];
                }
            }

            Arrays.sort(odd);
            Arrays.sort(even);

            for (int i = 0; i < odd.length; ++i) {
                nums[i * 2 + 1] = odd[odd.length - 1 - i];
            }

            for (int i = 0; i < even.length; ++i) {
                nums[i * 2] = even[i];
            }

            return nums;
        }
    }

}
