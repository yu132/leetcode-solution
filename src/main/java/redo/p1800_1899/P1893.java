package redo.p1800_1899;

/**  
 * @ClassName: P1893  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1893 {

    class Solution {
        public boolean isCovered(int[][] ranges, int left, int right) {
            int[] diff = new int[52];

            for (int[] range : ranges) {
                ++diff[range[0]];
                --diff[range[1] + 1];
            }

            int now = 0;

            for (int i = 1; i <= 50; ++i) {
                now += diff[i];
                if (now == 0 && left <= i && i <= right) {
                    return false;
                }
            }

            return true;
        }
    }

}
