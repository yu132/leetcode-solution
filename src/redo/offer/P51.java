package redo.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P51  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月6日  
 *  
 */
public class P51 {

    class Solution {

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

    // static//
    //
    // class Solution {
    // public int reversePairs(int[] nums) {
    // if (nums.length == 0) {
    // return 0;
    // }
    // int type = discretizationInSameIndex(nums);
    //
    // BIT bit = new BIT(type);
    //
    // int ans = 0;
    //
    // for (int i = 0; i < nums.length; ++i) {
    // ans += i - bit.get(nums[i] + 1);
    // bit.add(nums[i], 1);
    // }
    //
    // return ans;
    // }
    //
    // // 返回离散化后的种数
    // int discretizationInSameIndex(int[] val) {
    // int[] copy = Arrays.copyOf(val, val.length);
    // Arrays.sort(copy);
    // Map<Integer, Integer> map = new HashMap<>(val.length * 2);
    // map.put(copy[0], 0);
    // for (int i = 1; i < val.length; ++i) {
    // if (copy[i] != copy[i - 1]) {
    // map.put(copy[i], map.size());
    // }
    // }
    // for (int i = 0; i < val.length; ++i) {
    // val[i] = map.get(val[i]);
    // }
    // return map.size();
    // }
    //
    // static class BIT {
    // int[] c;
    //
    // public BIT(int len) {
    // this.c = new int[len + 1];
    // }
    //
    // void add(int index, int val) {
    // for (int i = index + 1; i < c.length; i += i & -i) {
    // c[i] += val;
    // }
    // }
    //
    // // exclude index
    // int get(int index) {
    // int sum = 0;
    // for (int i = index; i > 0; i -= i & -i) {
    // sum += c[i];
    // }
    // return sum;
    // }
    // }
    // }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.reversePairs(new int[] {7, 5, 6, 4}));
        Assert.assertEquals(0, s.reversePairs(new int[] {4, 5, 6, 7}));
    }

}
