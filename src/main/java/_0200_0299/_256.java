package _0200_0299;

/**  
 * @ClassName: _256  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月26日  
 *  
 */
public class _256 {

    class Solution {
        public int minCost(int[][] costs) {

            if (costs.length == 0) {
                return 0;
            }

            for (int i = 1; i < costs.length; ++i) {
                costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
                costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
                costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
            }

            return Math.min(costs[costs.length - 1][0],
                Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
        }
    }

}
