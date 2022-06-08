package lcof;

import java.util.HashSet;
import java.util.Set;

/**  
 * @ClassName: M57  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月23日  
 *  
 */
public class M57_1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Set<Integer> set = new HashSet<>();

            for (int i : nums) {
                set.add(i);
            }

            for (int i : nums) {
                if (set.contains(target - i)) {
                    return new int[] {i, target - i};
                }
            }

            return null;
        }
    }

}
