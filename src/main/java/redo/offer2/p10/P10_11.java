package redo.offer2.p10;

/**  
 * @ClassName: P10_11  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月11日  
 *  
 */
public class P10_11 {

    class Solution {
        public void wiggleSort(int[] nums) {
            for (int i = 1; i < nums.length; ++i) {
                if (!((i & 1) == 0 ^ (nums[i] < nums[i - 1]))) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }
        }
    }

}
