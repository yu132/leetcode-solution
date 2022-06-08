package redo.p1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1200  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月28日  
 *  
 */
public class P1200 {

    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            Arrays.sort(arr);
            List<List<Integer>> ans = new ArrayList<>();
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < arr.length; ++i) {
                int diff = arr[i] - arr[i - 1];
                if (diff < min) {
                    ans.clear();
                    min = diff;
                    ans.add(Arrays.asList(arr[i - 1], arr[i]));
                } else if (diff == min) {
                    ans.add(Arrays.asList(arr[i - 1], arr[i]));
                }
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[1,2],[2,3],[3,4]]",
            s.minimumAbsDifference(new int[] {4, 2, 1, 3}).toString().replaceAll("\\s", ""));
        Assert.assertEquals("[[1,3]]",
            s.minimumAbsDifference(new int[] {1, 3, 6, 10, 15}).toString().replaceAll("\\s", ""));
        Assert.assertEquals("[[-14,-10],[19,23],[23,27]]",
            s.minimumAbsDifference(new int[] {3, 8, -10, 23, 19, -4, -14, 27}).toString().replaceAll("\\s", ""));
    }

}
