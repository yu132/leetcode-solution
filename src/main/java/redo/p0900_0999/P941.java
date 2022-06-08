package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P941  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月25日  
 *  
 */
public class P941 {

    class Solution {
        public boolean validMountainArray(int[] arr) {
            if (arr.length < 3) {
                return false;
            }
            boolean up = true;
            if (arr[0] >= arr[1]) {
                return false;
            }
            for (int i = 2; i < arr.length; ++i) {
                if (arr[i] == arr[i - 1]) {
                    return false;
                }
                if (up) {
                    if (arr[i] > arr[i - 1]) {
                        continue;
                    } else {
                        up = false;
                    }
                } else {
                    if (arr[i] > arr[i - 1]) {
                        return false;
                    } else {
                        continue;
                    }
                }
            }
            return !up;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(false, s.validMountainArray(new int[] {2, 1}));
        Assert.assertEquals(false, s.validMountainArray(new int[] {3, 5, 5}));
        Assert.assertEquals(true, s.validMountainArray(new int[] {0, 3, 2, 1}));
        Assert.assertEquals(false, s.validMountainArray(new int[] {3, 2, 1}));
        Assert.assertEquals(false, s.validMountainArray(new int[] {1, 2, 3}));
    }

}
