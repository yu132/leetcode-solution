package redo.p0200_0299;

import java.util.LinkedList;
import java.util.TreeMap;

/**  
 * @ClassName: P220  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P220 {

    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeMap<Integer, Integer> counter = new TreeMap<>();

            for (int i = 0; i <= Math.min(k, nums.length - 1); ++i) {
                if (check(counter, nums[i], t)) {
                    return true;
                }
                plus1(counter, nums[i]);
            }

            for (int i = k + 1; i < nums.length; ++i) {
                minus1(counter, nums[i - k - 1]);

                if (check(counter, nums[i], t)) {
                    return true;
                }

                plus1(counter, nums[i]);
            }

            return false;
        }

        boolean check(TreeMap<Integer, Integer> counter, int num, int t) {
            Integer ceil = counter.ceilingKey(num);
            if (ceil != null && (long)ceil - num <= t) {
                return true;
            }
            Integer floor = counter.lowerKey(num);
            if (floor != null && (long)num - floor <= t) {
                return true;
            }
            return false;
        }

        void plus1(TreeMap<Integer, Integer> counter, int num) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        void minus1(TreeMap<Integer, Integer> counter, int num) {
            int count = counter.get(num) - 1;
            if (count != 0) {
                counter.put(num, count);
            } else {
                counter.remove(num);
            }
        }
    }

}
