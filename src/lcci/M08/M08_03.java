package lcci.M08;

/**  
 * @ClassName: M08_03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月4日  
 *  
 */
public class M08_03 {

    class Solution {
        public int findMagicIndex(int[] nums) {

            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == i) {
                    return i;
                }
            }

            return -1;
        }
    }

}
