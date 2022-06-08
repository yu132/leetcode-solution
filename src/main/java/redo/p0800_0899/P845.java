package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P845  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月29日  
 *  
 */
public class P845 {

    class Solution {
        public int longestMountain(int[] arr) {

            if (arr.length <= 2) {
                return 0;
            }

            int len, state;// 1 up 2 down

            if (arr[0] < arr[1]) {
                len = 2;
                state = 1;
            } else {
                len = 0;
                state = 2;
            }

            int ans = 0;

            for (int i = 2; i < arr.length; ++i) {
                if (state == 1) {// up
                    if (arr[i - 1] < arr[i]) {
                        ++len;
                    } else if (arr[i - 1] == arr[i]) {
                        len = 0;
                        state = 2;
                    } else {
                        ++len;
                        state = 2;
                    }
                } else {// down
                    if (arr[i - 1] < arr[i]) {
                        ans = Math.max(ans, len);
                        state = 1;
                        len = 2;
                    } else if (arr[i - 1] == arr[i]) {
                        ans = Math.max(ans, len);
                        state = 2;
                        len = 0;
                    } else {
                        if (len != 0) {
                            ++len;
                        }
                    }
                }
            }

            return state == 2 ? Math.max(ans, len) : ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.longestMountain(new int[] {2, 1, 4, 7, 3, 2, 5}));
        Assert.assertEquals(0, s.longestMountain(new int[] {2, 2, 2}));
        Assert.assertEquals(0, s.longestMountain(new int[] {1, 2, 2}));
        Assert.assertEquals(0, s.longestMountain(new int[] {2, 2, 1}));
        Assert.assertEquals(0, s.longestMountain(new int[] {1, 2, 2}));

        Assert.assertEquals(6, s.longestMountain(new int[] {1, 2, 3, 2, 4, 5, 6, 7, 5}));

        Assert.assertEquals(0, s.longestMountain(new int[] {1, 2, 3}));
    }

}
