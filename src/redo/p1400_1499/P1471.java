package redo.p1400_1499;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1471  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1471 {

    class Solution {
        public int[] getStrongest(int[] arr, int k) {
            Arrays.sort(arr);

            int m = arr[(arr.length - 1) / 2];

            int low = 0, high = arr.length - 1, index = 0, ans[] = new int[k];

            while (index < k) {
                if (m - arr[low] > arr[high] - m) {
                    ans[index++] = arr[low++];
                } else {
                    ans[index++] = arr[high--];
                }
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {5, 1}, s.getStrongest(new int[] {1, 2, 3, 4, 5}, 2));
        Assert.assertArrayEquals(new int[] {5, 5}, s.getStrongest(new int[] {1, 1, 3, 5, 5}, 2));
        Assert.assertArrayEquals(new int[] {11, 8, 6, 6, 7}, s.getStrongest(new int[] {6, 7, 11, 7, 6, 8}, 5));
        Assert.assertArrayEquals(new int[] {-3, 11, 2}, s.getStrongest(new int[] {6, -3, 7, 2, 11}, 3));
        Assert.assertArrayEquals(new int[] {22, 17}, s.getStrongest(new int[] {-7, 22, 17, 3}, 2));
    }

}
