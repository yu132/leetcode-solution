package _0300_0399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import model.NestedInteger;

/**  
 * @ClassName: _364  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月12日  
 *  
 */
public class _364 {

    class Solution {
        public int depthSumInverse(List<NestedInteger> nestedList) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            int                         max = dfs(nestedList, map, 0) + 1, sum = 0;
            for (Entry<Integer, List<Integer>> entry : map.entrySet()) {
                for (int val : entry.getValue()) {
                    sum += val * (max - entry.getKey());
                }
            }
            return sum;
        }

        public int dfs(List<NestedInteger> nestedList, Map<Integer, List<Integer>> map, int deep) {
            if (nestedList.size() == 0) {
                return 0;
            }
            int max = deep;
            for (int i = 0; i < nestedList.size(); ++i) {
                NestedInteger ni = nestedList.get(i);
                if (ni.isInteger()) {
                    map.computeIfAbsent(deep, (x) -> new ArrayList<>()).add(ni.getInteger());
                } else {
                    max = Math.max(max, dfs(ni.getList(), map, deep + 1));
                }
            }
            return max;
        }
    }

}
