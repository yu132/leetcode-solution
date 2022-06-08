package redo.p0300_0399;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P321  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P321 {

    class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {

            int[] maxAns = null;

            for (int i = Math.max(0, k - nums2.length);
                i <= Math.min(k, nums1.length); ++i) {
                int[] p1 = max(nums1, i), p2 = max(nums2, k - i);
                int[] p3 = merge(p1, p2);
                if (maxAns == null || compare(maxAns, p3, 0, 0, k, k) < 0) {
                    maxAns = p3;
                }
            }

            return maxAns;
        }

        int[] max(int[] nums, int k) {

            int n = nums.length;

            Deque<Integer> mstack = new LinkedList<>();

            for (int i = 0; i < nums.length; ++i) {
                while (!mstack.isEmpty() && nums[i] > mstack.peek()
                    && mstack.size() + (n - i) - 1 >= k) {
                    mstack.pop();
                }
                mstack.push(nums[i]);
            }

            int[] ans = new int[k];

            for (int i = 0; i < k; ++i) {
                ans[i] = mstack.removeLast();
            }
            return ans;
        }

        int[] merge(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;

            if (m == 0) {
                return nums2;
            } else if (n == 0) {
                return nums1;
            }

            int[] ans = new int[m + n];
            int index = 0, index1 = 0, index2 = 0;
            while (index1 != m && index2 != n) {
                if (compare(nums1, nums2, index1, index2, m, n) >= 0) {
                    ans[index++] = nums1[index1++];
                } else {
                    ans[index++] = nums2[index2++];
                }
            }
            while (index1 < m) {
                ans[index++] = nums1[index1++];
            }
            while (index2 < n) {
                ans[index++] = nums2[index2++];
            }
            return ans;
        }

        int compare(int[] nums1, int[] nums2, int x, int y, int m, int n) {
            while (x < m || y < n) {
                int n1 = nums1[Math.min(x, m - 1)];
                int n2 = nums2[Math.min(y, n - 1)];
                if (n1 < n2) {
                    return -1;
                } else if (n1 > n2) {
                    return 1;
                }
                ++x;
                ++y;
            }
            return 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {9, 8, 6, 5, 3}, s.maxNumber(
            new int[] {3, 4, 6, 5}, new int[] {9, 1, 2, 5, 8, 3}, 5));
    }

}
