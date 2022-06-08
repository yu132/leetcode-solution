package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P978  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P978 {

    class Solution {
        public int maxTurbulenceSize(int[] arr) {
            int len = 0, ans = 0;
            boolean up = true;
            for (int i = 1; i < arr.length; ++i) {
                if (up) {
                    if (arr[i] > arr[i - 1]) {
                        up = false;
                        ++len;
                    } else if (arr[i] < arr[i - 1]) {
                        up = true;
                        len = 1;
                    } else {
                        len = 0;
                    }
                } else {
                    if (arr[i] > arr[i - 1]) {
                        up = false;
                        len = 1;
                    } else if (arr[i] < arr[i - 1]) {
                        up = true;
                        ++len;
                    } else {
                        len = 0;
                    }
                }
                ans = Math.max(ans, len);
            }
            return ans + 1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.maxTurbulenceSize(new int[] {9, 4, 2, 10, 7, 8, 8, 1, 9}));
        Assert.assertEquals(2, s.maxTurbulenceSize(new int[] {4, 8, 12, 16}));
        Assert.assertEquals(1, s.maxTurbulenceSize(new int[] {100}));
    }

}
