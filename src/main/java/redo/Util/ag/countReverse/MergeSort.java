package redo.Util.ag.countReverse;

import java.util.Arrays;

public class MergeSort {

    class CountReverseUseMergeSort {

        int ans;

        public int reversePairs(int[] nums) {
            ans = 0;
            mergerSort(nums, 0, nums.length);
            return ans;
        }

        void mergerSort(int[] nums, int low, int high) {
            if (low >= high - 1) {
                return;
            }

            int mid = (low + high) >>> 1;

            mergerSort(nums, low, mid);
            mergerSort(nums, mid, high);

            int[] copy = Arrays.copyOfRange(nums, low, mid);

            int index1 = 0, index2 = mid, index = low;

            while (index1 != copy.length && index2 != high) {
                if (copy[index1] <= nums[index2]) {
                    nums[index++] = copy[index1++];
                } else {
                    ans += copy.length - index1;
                    nums[index++] = nums[index2++];
                }
            }

            while (index1 != copy.length) {
                nums[index++] = copy[index1++];
            }

            return;
        }
    }

}
