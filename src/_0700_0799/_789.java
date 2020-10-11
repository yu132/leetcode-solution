package _0700_0799;

/**  
 * @ClassName: _789  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年6月8日  
 *  
 */
public class _789 {

    class Solution {
        public boolean escapeGhosts(int[][] ghosts, int[] target) {
            int myDis = Math.abs(target[0]) + Math.abs(target[1]);
            for (int[] each : ghosts) {
                if (dis(each, target) <= myDis) {
                    return false;
                }
            }
            return true;
        }

        public int dis(int[] a, int[] b) {
            return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
        }
    }

}
