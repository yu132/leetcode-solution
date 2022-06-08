package redo.p1000_1099;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1041  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1041 {

    class Solution {
        public boolean isRobotBounded(String instructions) {
            int x = 0, y = 0, dir = 0;
            int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            for (int i = 0; i < 4; ++i) {
                for (char ch : instructions.toCharArray()) {
                    switch (ch) {
                        case 'G':
                            x += dirs[dir][0];
                            y += dirs[dir][1];
                            break;
                        case 'L':
                            dir = (dir - 1 + 4) % 4;
                            break;
                        case 'R':
                            dir = (dir + 1) % 4;
                        default:
                            break;
                    }
                }
            }
            return x == 0 && y == 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.isRobotBounded("GGLLGG"));
        Assert.assertEquals(false, s.isRobotBounded("GG"));
        Assert.assertEquals(true, s.isRobotBounded("GL"));
    }
}
