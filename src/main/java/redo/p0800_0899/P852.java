package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P852  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P852 {

    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int low = 0, high = arr.length - 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (arr[mid] < arr[mid + 1]) {
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
        Assert.assertEquals(1, s.peakIndexInMountainArray(new int[] {0, 1, 0}));
        Assert.assertEquals(1, s.peakIndexInMountainArray(new int[] {0, 2, 1, 0}));
    }

}
