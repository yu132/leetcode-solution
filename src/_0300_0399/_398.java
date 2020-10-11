package _0300_0399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**  
 * @ClassName: _398  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月29日  
 *  
 */
public class _398 {

    class Solution {

        Random r = new Random();

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; ++i) {
                map.computeIfAbsent(nums[i], (x) -> new ArrayList<>()).add(i);
            }
        }

        public int pick(int target) {
            ArrayList<Integer> l = map.get(target);
            return l.get(r.nextInt(l.size()));
        }
    }

}
