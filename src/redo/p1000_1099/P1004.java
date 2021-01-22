package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1004  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P1004 {

    class Solution {
        public int longestOnes(int[] A, int K) {
            int count0 = 0, max = 0;
            for (int left = 0, right = 0; left < A.length; ++left) {
                while (right < A.length && count0 <= K) {
                    if (A[right] == 0) {
                        if (count0 == K) {
                            break;
                        } else {
                            ++count0;
                        }
                    }
                    ++right;
                }
                max = Math.max(max, right - left);
                if (A[left] == 0) {
                    --count0;
                }
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(6, s.longestOnes(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        Assert.assertEquals(10, s.longestOnes(new int[] {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
        Assert.assertEquals(4, s.longestOnes(new int[] {0, 0, 0, 1}, 3));
        Assert.assertEquals(4, s.longestOnes(new int[] {0, 0, 1, 1, 1, 1, 0, 0}, 0));
    }

}
