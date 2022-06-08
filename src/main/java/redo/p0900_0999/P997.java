package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P997  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P997 {

    class Solution {
        public int findJudge(int N, int[][] trust) {
            int[] in = new int[N + 1], out = new int[N + 1];
            for (int[] t : trust) {
                ++in[t[1]];
                ++out[t[0]];
            }
            for (int i = 1; i <= N; ++i) {
                if (in[i] == N - 1 && out[i] == 0) {
                    return i;
                }
            }
            return -1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.findJudge(2, Arrs.build2D("[[1,2]]")));
        Assert.assertEquals(3, s.findJudge(3, Arrs.build2D("[[1,3],[2,3]]")));
        Assert.assertEquals(-1, s.findJudge(3, Arrs.build2D("[[1,3],[2,3],[3,1]]")));
        Assert.assertEquals(-1, s.findJudge(3, Arrs.build2D("[[1,2],[2,3]]")));
        Assert.assertEquals(3, s.findJudge(4, Arrs.build2D("[[1,3],[1,4],[2,3],[2,4],[4,3]]")));
    }

}
