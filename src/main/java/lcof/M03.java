package lcof;

import java.util.HashSet;
import java.util.Set;

/**  
 * @ClassName: M03  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月12日  
 *  
 */
public class M03 {

    class Solution {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();

            for (int each : nums) {
                if (set.contains(each)) {
                    return each;
                }
                set.add(each);
            }

            return -1;
        }
    }

}
