package redo.offer2.p08;

/**  
 * @ClassName: P08_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P08_03 {

    class Solution {
        public int findMagicIndex(int[] nums) {

            for (int i = 0; i < nums.length;) {
                if (i == nums[i]) {
                    return i;
                } else if (i > nums[i]) {
                    ++i;
                } else {
                    i = nums[i];
                }
            }

            return -1;

        }
    }

}
