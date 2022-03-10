package redo.p1800_1899;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**  
 * @ClassName: P1817  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年4月11日  
 *  
 */
public class P1817 {

    class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {

            Map<Integer, Set<Integer>> setMap = new HashMap<>();

            for (int[] log : logs) {
                add(setMap, log[0], log[1]);
            }

            int[] ans = new int[k];

            for (Set<Integer> set : setMap.values()) {
                ++ans[set.size() - 1];
            }

            return ans;
        }

        void add(Map<Integer, Set<Integer>> setMap, int id, int time) {
            setMap.computeIfAbsent(id, (x) -> new HashSet<>()).add(time);
        }
    }

}
