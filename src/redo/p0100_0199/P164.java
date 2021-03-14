package redo.p0100_0199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P164  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P164 {

    class Solution {
        public int maximumGap(int[] nums) {

            if (nums.length <= 1) {
                return 0;
            }

            long base = 1;

            int max = max(nums);

            for (; base <= max; base *= 10) {
                radixSort(nums, (int)base);
            }

            int ans = 0;

            for (int i = 1; i < nums.length; ++i) {
                ans = Math.max(ans, nums[i] - nums[i - 1]);
            }

            return ans;
        }

        int max(int[] nums) {
            int max = 0;
            for (int num : nums) {
                max = Math.max(num, max);
            }
            return max;
        }

        void radixSort(int[] nums, int base) {
            @SuppressWarnings("unchecked")
            List<Integer>[] bins = new ArrayList[10];

            Arrays.setAll(bins, (x) -> new ArrayList<>());

            for (int num : nums) {
                int index = (num / base) % 10;
                bins[index].add(num);
            }

            int index = 0;

            for (List<Integer> list : bins) {
                for (int num : list) {
                    nums[index++] = num;
                }
            }
        }
    }


}
