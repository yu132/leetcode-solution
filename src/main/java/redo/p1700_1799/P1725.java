package redo.p1700_1799;

/**  
 * @ClassName: P1725  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P1725 {

    class Solution {
        public int countGoodRectangles(int[][] rectangles) {

            int maxLen = 0, count = 0;

            for (int[] rect : rectangles) {
                int edge = Math.min(rect[0], rect[1]);
                if (edge > maxLen) {
                    maxLen = edge;
                    count = 1;
                } else if (edge == maxLen) {
                    ++count;
                }
            }

            return count;
        }
    }

}
