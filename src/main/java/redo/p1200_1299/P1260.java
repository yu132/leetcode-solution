package redo.p1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1260  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1260 {

    class Solution {
        public List<List<Integer>> shiftGrid(int[][] grid, int k) {
            if (grid.length == 0) {
                return Collections.emptyList();
            }
            int[] arr = new int[grid.length * grid[0].length];
            for (int i = 0; i < grid.length; ++i) {
                System.arraycopy(grid[i], 0, arr, i * grid[i].length, grid[i].length);
            }
            k %= grid.length * grid[0].length;
            int[] copy = Arrays.copyOfRange(arr, arr.length - k, arr.length);
            System.arraycopy(arr, 0, arr, k, arr.length - k);
            System.arraycopy(copy, 0, arr, 0, k);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < grid.length; ++i) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < grid[0].length; ++j) {
                    temp.add(arr[i * grid[0].length + j]);
                }
                ans.add(temp);
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[9,1,2],[3,4,5],[6,7,8]]",
            s.shiftGrid(Arrs.build2D("[[1,2,3],[4,5,6],[7,8,9]]"), 1).toString().replaceAll("\\s", ""));
        Assert.assertEquals("[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]",
            s.shiftGrid(Arrs.build2D("[[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]]"), 4).toString().replaceAll("\\s",
                ""));
        Assert.assertEquals("[[1,2,3],[4,5,6],[7,8,9]]",
            s.shiftGrid(Arrs.build2D("[[1,2,3],[4,5,6],[7,8,9]]"), 9).toString().replaceAll("\\s", ""));
        Assert.assertEquals("[[6],[5],[1],[2],[3],[4],[7]]",
            s.shiftGrid(Arrs.build2D("[[1],[2],[3],[4],[7],[6],[5]]"), 23).toString().replaceAll("\\s", ""));


    }

}
