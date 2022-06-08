package redo.p1800_1899;

/**  
 * @ClassName: P1863  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1863 {

    class Solution {
        public int subsetXORSum(int[] nums) {
            int or = 0;
            for (int num : nums) {
                or |= num;
            }
            return or << (nums.length - 1);
        }
    }

}
