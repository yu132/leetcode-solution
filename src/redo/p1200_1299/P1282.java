package redo.p1200_1299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1282  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class P1282 {

    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            List<List<Integer>> ans = new ArrayList<>();
            Map<Integer, List<Integer>> mapping = new HashMap<>();

            for (int i = 0; i < groupSizes.length; ++i) {
                List<Integer> list = mapping.computeIfAbsent(groupSizes[i], (x) -> new ArrayList<>());
                list.add(i);
                if (list.size() == groupSizes[i]) {
                    ans.add(new ArrayList<>(list));
                    list.clear();
                }
            }

            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[0,1,2],[5],[3,4,6]]", Arrs.toStrL(s.groupThePeople(new int[] {3, 3, 3, 3, 3, 1, 3})));
        Assert.assertEquals("[[1],[2,3,4],[0,5]]", Arrs.toStrL(s.groupThePeople(new int[] {2, 1, 3, 3, 3, 2})));
    }

}
