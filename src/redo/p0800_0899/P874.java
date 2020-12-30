package redo.p0800_0899;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P874  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月22日  
 *  
 */
public class P874 {

    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int x = 0, y = 0, dir = 0;
            Set<Integer> obstaclesSet = new HashSet<>();
            for (int[] obstacle : obstacles) {
                obstaclesSet.add(hash(obstacle[0], obstacle[1]));
            }
            int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int max = 0;
            for (int command : commands) {
                if (command == -1) {
                    dir = (dir + 1) % 4;
                } else if (command == -2) {
                    dir = (dir - 1 + 4) % 4;
                } else {
                    for (int i = 0; i < command; ++i) {
                        x += dirs[dir][0];
                        y += dirs[dir][1];
                        if (obstaclesSet.contains(hash(x, y))) {
                            x -= dirs[dir][0];
                            y -= dirs[dir][1];
                            break;
                        }
                    }
                    max = Math.max(max, x * x + y * y);
                }
            }
            return max;
        }

        private int hash(int x, int y) {
            return (x + 30000) + (y + 30000) * 60000;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(25, s.robotSim(new int[] {4, -1, 3}, new int[0][]));
        Assert.assertEquals(65, s.robotSim(new int[] {4, -1, 4, -2, 4}, new int[][] {{2, 4}}));
    }
}
