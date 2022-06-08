package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1620  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1620 {

    static//

    class Solution {
        public int[] bestCoordinate(int[][] towers, int radius) {
            int minX = towers[0][0], maxX = towers[0][0], minY = towers[0][1], maxY = towers[0][1];
            for (int[] tower : towers) {
                minX = Math.min(minX, tower[0]);
                maxX = Math.max(maxX, tower[0]);

                minY = Math.min(minY, tower[1]);
                maxY = Math.max(maxY, tower[1]);
            }

            int[][] area = new int[maxX + 1 - minX][maxY + 1 - minY];

            for (int i = 0; i <= maxX - minX; ++i) {
                for (int j = 0; j <= maxY - minY; ++j) {
                    int x = i + minX, y = j + minY;
                    for (int[] tower : towers) {
                        double distance = distance(x, y, tower[0], tower[1]);
                        if (distance > radius) {
                            continue;
                        }
                        area[i][j] += tower[2] / (1 + distance);
                    }
                }
            }

            int max = 0, x = 0, y = 0;

            for (int i = 0; i <= maxX - minX; ++i) {
                for (int j = 0; j <= maxY - minY; ++j) {
                    if (area[i][j] > max) {
                        max = area[i][j];
                        x = i;
                        y = j;
                    }
                }
            }

            if (max == 0) {
                return new int[] {0, 0};
            }

            return new int[] {minX + x, minY + y};
        }

        public static double distance(int x1, int y1, int x2, int y2) {
            return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {2, 1}, s.bestCoordinate(Arrs.build2D("[[1,2,5],[2,1,7],[3,1,9]]"), 2));
        Assert.assertArrayEquals(new int[] {23, 11}, s.bestCoordinate(Arrs.build2D("[[23,11,21]]"), 9));
        Assert.assertArrayEquals(new int[] {1, 2}, s.bestCoordinate(Arrs.build2D("[[1,2,13],[2,1,7],[0,1,9]]"), 2));
        Assert.assertArrayEquals(new int[] {0, 1}, s.bestCoordinate(Arrs.build2D("[[2,1,9],[0,1,9]]"), 2));

    }

}
