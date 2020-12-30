package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P942  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月25日  
 *  
 */
public class P942 {

    class Solution {
        public int[] diStringMatch(String S) {
            int low = 0, high = S.length();
            int[] ans = new int[S.length() + 1];
            for (int i = 0; i < S.length(); ++i) {
                ans[i] = S.charAt(i) == 'I' ? low++ : high--;
            }
            ans[S.length()] = low;
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {0, 4, 1, 3, 2}, s.diStringMatch("IDID"));
        Assert.assertArrayEquals(new int[] {0, 1, 2, 3}, s.diStringMatch("III"));
        Assert.assertArrayEquals(new int[] {3, 2, 0, 1}, s.diStringMatch("DDI"));
    }

}
