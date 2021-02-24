package redo.offer2.p17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**  
 * @ClassName: P17_18  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月18日  
 *  
 */
public class P17_18 {

    class Solution {
        public int[] shortestSeq(int[] big, int[] small) {
            Map<Integer, Integer> counter = new HashMap<>();

            Set<Integer> set = new HashSet<>();

            for (int num : small) {
                set.add(num);
            }

            int min = Integer.MAX_VALUE, start = 0;
            for (int left = 0, right = 0; right < big.length; ++right) {
                if (set.contains(big[right])) {
                    plus1(counter, big[right]);
                }
                if (counter.size() == small.length) {
                    while (counter.size() == small.length) {
                        int len = right - left + 1;
                        if (len < min) {
                            min = len;
                            start = left;
                        }
                        if (set.contains(big[left])) {
                            minus1(counter, big[left]);
                        }
                        ++left;
                    }
                }
            }

            if (min == Integer.MAX_VALUE) {
                return new int[0];
            }

            return new int[] {start, start + min - 1};
        }

        public void plus1(Map<Integer, Integer> counter, int val) {
            counter.put(val, counter.getOrDefault(val, 0) + 1);
        }

        public void minus1(Map<Integer, Integer> counter, int val) {
            counter.put(val, counter.getOrDefault(val, 0) - 1);
            if (counter.get(val) == 0) {
                counter.remove(val);
            }
        }
    }

}
