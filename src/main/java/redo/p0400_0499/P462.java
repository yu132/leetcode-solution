package redo.p0400_0499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P462  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月18日  
 *  
 */
public class P462 {

    class Solution {
        public int minMoves2(int[] nums) {
            return diff(nums, minK(nums, nums.length / 2 + 1));
        }

        int diff(int[] nums, int val) {
            int sum = 0;
            for (int num : nums) {
                sum += Math.abs(num - val);
            }
            return sum;
        }

        int minK(int[] arr, int k) {

            int low = 0, high = arr.length - 1;

            int pviotIndex = partition(arr, low, high);

            while (pviotIndex != k - 1) {
                if (pviotIndex > k - 1) {
                    high = pviotIndex - 1;
                } else {
                    low = pviotIndex + 1;
                }
                pviotIndex = partition(arr, low, high);
            }

            return arr[k - 1];
        }

        int partition(int[] arr, int low, int high) {
            int pivot = arr[low];// 取最低位为主元
            while (low < high) {
                while (low < high && arr[high] >= pivot) {
                    --high;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= pivot) {
                    ++low;
                }
                arr[high] = arr[low];
            }
            arr[low] = pivot;
            return low;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.minMoves2(new int[] {1, 2, 3}));

    }

}
