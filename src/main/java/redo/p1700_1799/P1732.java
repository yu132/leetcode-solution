package redo.p1700_1799;

/**  
 * @ClassName: P1732  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P1732 {

    class Solution {
        public int largestAltitude(int[] gain) {
            int height = 0, max = 0;
            for (int diff : gain) {
                height += diff;
                max = Math.max(max, height);
            }
            return max;
        }
    }

}
