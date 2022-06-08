package redo.LCP;

import java.util.HashSet;
import java.util.Set;

/**  
 * @ClassName: LCP11  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class LCP11 {

    static//

    class Solution {
        public int expectNumber(int[] scores) {
            return toSet(scores).size();
        }

        public static Set<Integer> toSet(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            return set;
        }
    }

}
