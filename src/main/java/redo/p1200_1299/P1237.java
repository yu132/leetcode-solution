package redo.p1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1237  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1237 {

    interface CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y);
    };

    class Solution {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> ans = new ArrayList<>();
            int x = 1, y = 1000;
            while (x <= 1000 && y >= 1) {
                int n = customfunction.f(x, y);
                if (n < z) {
                    ++x;
                } else if (n > z) {
                    --y;
                } else {
                    ans.add(Arrays.asList(x, y));
                    ++x;
                    --y;
                }
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[1,4],[2,3],[3,2],[4,1]]",
            s.findSolution((x, y) -> x + y, 5).toString().replaceAll("\\s", ""));
        Assert.assertEquals("[[1,5],[5,1]]", s.findSolution((x, y) -> x * y, 5).toString().replaceAll("\\s", ""));
    }

}
