package redo.p1700_1799;

/**  
 * @ClassName: P1749  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月11日  
 *  
 */
public class P1749 {

    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int sumPos = 0, sumNeg = 0, ans = 0;
            for (int num : nums) {
                sumPos = Math.max(0, sumPos + num);
                sumNeg = Math.min(0, sumNeg + num);
                ans = Math.max(ans, Math.max(sumPos, -sumNeg));
            }
            return ans;
        }
    }

}
