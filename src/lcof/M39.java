package lcof;

/**  
 * @ClassName: M39  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月19日  
 *  
 */
public class M39 {

    class Solution {
        public int majorityElement(int[] nums) {

            int num   = nums[0];
            int count = 1;

            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] == num) {
                    ++count;
                } else {
                    --count;
                    if (count == 0) {
                        num   = nums[i];
                        count = 1;
                    }
                }
            }

            return num;
        }
    }

}
