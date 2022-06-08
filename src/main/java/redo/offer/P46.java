package redo.offer;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P46  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P46 {

    class Solution {

        int ans;

        public int translateNum(int num) {
            ans = 0;
            backtrack(num);
            return ans;
        }

        void backtrack(int num) {
            if (num == 0) {
                ++ans;
                return;
            }
            int low = num % 10;
            num /= 10;
            backtrack(num);
            if (num == 0 || num % 10 == 0) {
                return;
            }
            low += (num % 10) * 10;
            num /= 10;
            if (low < 26) {
                backtrack(num);
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(5, s.translateNum(12258));
        Assert.assertEquals(1, s.translateNum(506));
    }

}
