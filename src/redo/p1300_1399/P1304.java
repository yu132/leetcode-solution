package redo.p1300_1399;

/**  
 * @ClassName: P1304  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1304 {

    class Solution {
        public int[] sumZero(int n) {
            int[] nums = new int[n];
            for (int i = 0; i < n - 1; i += 2) {
                nums[i] = -(i + 1);
                nums[i + 1] = i + 1;
            }
            return nums;
        }
    }

}
