package redo.p1700_1799;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: P1748  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P1748 {

    class Solution {
        public int sumOfUnique(int[] nums) {
            Map<Integer, Integer> counter = new HashMap<>();
            for (int num : nums) {
                plus1(counter, num);
            }
            int count = 0;
            for (int num : nums) {
                if (counter.get(num) == 1) {
                    count += num;
                }
            }
            return count;
        }

        void plus1(Map<Integer, Integer> counter, int num) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
    }

}
