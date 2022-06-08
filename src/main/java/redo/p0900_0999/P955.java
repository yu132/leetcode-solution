package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P955  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P955 {

    class Solution {
        public int minDeletionSize(String[] A) {
            boolean[][] dp = new boolean[2][A.length];
            int remove = 0;
            for (int i = 0, scroll = 0; i < A[0].length(); ++i, scroll ^= 1) {
                boolean flag = true;
                for (int j = 0; j < A.length - 1; ++j) {
                    if (dp[scroll ^ 1][j] || A[j + 1].charAt(i) > A[j].charAt(i)) {
                        dp[scroll][j] = true;
                    } else if (A[j + 1].charAt(i) == A[j].charAt(i)) {
                        dp[scroll][j] = false;
                        flag = false;
                    } else {
                        ++remove;
                        System.arraycopy(dp[scroll ^ 1], 0, dp[scroll], 0, A.length);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return remove;
                }
            }
            return remove;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.minDeletionSize(new String[] {"ca", "bb", "ac"}));
        Assert.assertEquals(0, s.minDeletionSize(new String[] {"xc", "yb", "za"}));
        Assert.assertEquals(3, s.minDeletionSize(new String[] {"zyx", "wvu", "tsr"}));

        Assert.assertEquals(2, s.minDeletionSize(new String[] {"bb", "bc", "aa"}));

        Assert.assertEquals(1, s.minDeletionSize(new String[] {"xga", "xfb", "yfa"}));
    }

}
