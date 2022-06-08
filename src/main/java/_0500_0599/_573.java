package _0500_0599;

/**  
 * @ClassName: _573  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月13日  
 *  
 */
public class _573 {

    class Solution {
        public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
            int sum = 0;
            for (int i = 0; i < nuts.length; ++i) {
                sum += (Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1])) * 2;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nuts.length; ++i) {
                min = Math.min(min, sum - (Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1]))
                    + Math.abs(Math.abs(squirrel[0] - nuts[i][0]) + Math.abs(squirrel[1] - nuts[i][1])));
            }
            return min;
        }
    }

}
