package redo.p0800_0899;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P841  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月29日  
 *  
 */
public class P841 {

    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int n = rooms.size();
            return dfs(0, new boolean[n], rooms) == n;
        }

        int dfs(int x, boolean[] visited, List<List<Integer>> rooms) {
            if (visited[x]) {
                return 0;
            }
            visited[x] = true;
            int count = 1;
            for (int child : rooms.get(x)) {
                count += dfs(child, visited, rooms);
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.canVisitAllRooms(Arrs.build2DL("[[1],[2],[3],[]]")));
        Assert.assertEquals(false, s.canVisitAllRooms(Arrs.build2DL("[[1,3],[3,0,1],[2],[0]]")));
    }

}
