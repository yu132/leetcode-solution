package redo.p1500_1599;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1557  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class P1557 {

    class Solution {
        public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
            Set<Integer> ans = new HashSet<>();
            for (int i = 0; i < n; ++i) {
                ans.add(i);
            }
            for (List<Integer> edge : edges) {
                ans.remove(edge.get(1));
            }
            return new ArrayList<>(ans);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(0, 3),
            s.findSmallestSetOfVertices(6, Arrs.build2DL("[[0,1],[0,2],[2,5],[3,4],[4,2]]")));
        Assert.assertEquals(Arrays.asList(0, 2, 3),
            s.findSmallestSetOfVertices(5, Arrs.build2DL("[[0,1],[2,1],[3,1],[1,4],[2,4]]")));
    }

}
