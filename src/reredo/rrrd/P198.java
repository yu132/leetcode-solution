package reredo.rrrd;

/**  
 * @ClassName: P198  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月24日  
 *  
 */
public class P198 {

    class Solution {
        public int rob(int[] nums) {
            int rob = 0, notRob = 0;
            for (int num : nums) {
                int r = rob, n = notRob;
                rob = n + num;
                notRob = Math.max(r, n);
            }
            return Math.max(rob, notRob);
        }
    }

}
