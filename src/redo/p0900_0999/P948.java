package redo.p0900_0999;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P948  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P948 {

    class Solution {
        public int bagOfTokensScore(int[] tokens, int P) {
            Arrays.sort(tokens);
            int low = 0, high = tokens.length - 1, point = 0, max = 0;
            while (low <= high) {
                if (P >= tokens[low]) {
                    ++point;
                    max = Math.max(max, point);
                    P -= tokens[low++];
                } else {
                    if (point == 0) {
                        return max;
                    }
                    --point;
                    P += tokens[high--];
                }
            }
            return max;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.bagOfTokensScore(new int[] {100}, 50));
        Assert.assertEquals(1, s.bagOfTokensScore(new int[] {100, 200}, 150));
        Assert.assertEquals(2, s.bagOfTokensScore(new int[] {100, 200, 300, 400}, 200));
        Assert.assertEquals(0, s.bagOfTokensScore(new int[] {1, 2, 3}, 0));
    }

}
