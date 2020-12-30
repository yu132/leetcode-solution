package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P944  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月25日  
 *  
 */
public class P944 {

    class Solution {
        public int minDeletionSize(String[] A) {
            if (A.length == 0) {
                return 0;
            }
            int count = 0;
            l:
            for (int j = 0; j < A[0].length(); ++j) {
                for (int i = 1; i < A.length; ++i) {
                    if (A[i - 1].charAt(j) > A[i].charAt(j)) {
                        ++count;
                        continue l;
                    }
                }
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.minDeletionSize(new String[] {"cba", "daf", "ghi"}));
        Assert.assertEquals(0, s.minDeletionSize(new String[] {"a", "b"}));
        Assert.assertEquals(3, s.minDeletionSize(new String[] {"zyx", "wvu", "tsr"}));
    }

}
