package redo.p1500_1599;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1574  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月4日  
 *  
 */
public class P1574 {

    class Solution {
        public int findLengthOfShortestSubarray(int[] arr) {
            int stop1 = -1, start2 = -1;
            for (int i = 1; i < arr.length; ++i) {
                if (arr[i] < arr[i - 1]) {
                    stop1 = i - 1;
                    start2 = i;
                    break;
                }
            }
            if (stop1 == -1) {
                return 0;
            }
            for (int i = start2 + 1; i < arr.length; ++i) {
                if (arr[i] < arr[i - 1]) {
                    start2 = i;
                }
            }
            int max = 0;
            for (int i = 0; i <= stop1; ++i) {
                int index = lowerBound(arr, arr[i], start2, arr.length);
                int len = i + 1 + arr.length - index;
                max = Math.max(max, len);
            }
            max = Math.max(max, arr.length - start2);
            return arr.length - max;
        }

        public int lowerBound(int[] nums, int target, int start, int end) {
            int low = start, high = end;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.findLengthOfShortestSubarray(new int[] {1, 2, 3, 10, 4, 2, 3, 5}));
        Assert.assertEquals(4, s.findLengthOfShortestSubarray(new int[] {5, 4, 3, 2, 1}));
        Assert.assertEquals(0, s.findLengthOfShortestSubarray(new int[] {1, 2, 3}));
        Assert.assertEquals(0, s.findLengthOfShortestSubarray(new int[] {1}));
        Assert.assertEquals(8, s.findLengthOfShortestSubarray(new int[] {0, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4}));
        Assert.assertEquals(8, s.findLengthOfShortestSubarray(new int[] {16, 10, 0, 3, 22, 1, 14, 7, 1, 12, 15}));

    }

}
