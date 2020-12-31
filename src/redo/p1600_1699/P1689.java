package redo.p1600_1699;

/**  
 * @ClassName: P1689  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1689 {

    class Solution {
        public int minPartitions(String n) {
            int max = 0;
            for (char ch : n.toCharArray()) {
                max = Math.max(max, ch - '0');
            }
            return max;
        }
    }

}
