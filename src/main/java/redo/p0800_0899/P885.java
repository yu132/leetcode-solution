package redo.p0800_0899;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P885  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月27日  
 *  
 */
public class P885 {

    class Solution {
        public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
            int dir = -1, step = 0, ss = 0, epoch = 0, visited = 0, all = R * C, x = r0, y = c0;
            int[][] ans = new int[R * C][2];
            while (visited < all) {
                if (!(x < 0 || x >= R || y < 0 || y >= C)) {
                    ans[visited][0] = x;
                    ans[visited][1] = y;
                    ++visited;
                }
                if (ss == step) {
                    if (epoch == 0) {
                        ++step;
                    }
                    epoch ^= 1;
                    dir = (dir + 1) & 3;
                    ss = 0;
                }
                switch (dir) {
                    case 0:
                        y += 1;
                        break;
                    case 1:
                        x += 1;
                        break;
                    case 2:
                        y -= 1;
                        break;
                    case 3:
                        x -= 1;
                        break;
                }
                ++ss;

            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[0,0],[0,1],[0,2],[0,3]]", Arrs.toStr(s.spiralMatrixIII(1, 4, 0, 0)));
        Assert.assertEquals(
            "[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]",
            Arrs.toStr(s.spiralMatrixIII(5, 6, 1, 4)));
    }

}
