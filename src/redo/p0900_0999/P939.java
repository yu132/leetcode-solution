package redo.p0900_0999;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P939  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月22日  
 *  
 */
public class P939 {

    class Solution {
        public int minAreaRect(int[][] points) {
            Set<Integer> set = new HashSet<>(points.length * 2);
            for (int[] point : points) {
                set.add(hash(point[0], point[1]));
            }

            int minArea = Integer.MAX_VALUE;

            for (int i = 0; i < points.length; ++i) {
                for (int j = i + 1; j < points.length; ++j) {
                    int x1 = points[i][0], y1 = points[i][1], x2 = points[j][0], y2 = points[j][1];
                    if (x1 == x2 || y1 == y2) {
                        continue;
                    }
                    if (set.contains(hash(x1, y2)) && set.contains(hash(x2, y1))) {
                        minArea = Math.min(minArea, Math.abs((x1 - x2) * (y1 - y2)));
                    }
                }
            }

            return minArea == Integer.MAX_VALUE ? 0 : minArea;
        }

        public int hash(int x, int y) {
            return x + y * 40001;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.minAreaRect(Arrs.build2D("[]")));
        Assert.assertEquals(4, s.minAreaRect(Arrs.build2D("[[1,1],[1,3],[3,1],[3,3],[2,2]]")));
        Assert.assertEquals(2, s.minAreaRect(Arrs.build2D("[[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]")));
    }
}
