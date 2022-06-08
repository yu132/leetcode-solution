package redo.LCP;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: LCP01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class LCP01 {

    class Solution {
        public int game(int[] guess, int[] answer) {
            int count = 0;
            for (int i = 0; i < 3; ++i) {
                if (guess[i] == answer[i]) {
                    ++count;
                }
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.game(new int[] {1, 2, 3}, new int[] {1, 2, 3}));
        Assert.assertEquals(1, s.game(new int[] {2, 2, 3}, new int[] {3, 2, 1}));
    }

}
