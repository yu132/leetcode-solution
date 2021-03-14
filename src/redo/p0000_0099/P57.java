package redo.p0000_0099;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P57  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月11日  
 *  
 */
public class P57 {

    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            int start = -1, end = -1;

            List<int[]> ans = new ArrayList<>(intervals.length);

            boolean add = false;

            for (int[] range : intervals) {
                if (range[1] <= end) {
                    continue;
                }
                if (range[0] <= end) {
                    end = Math.max(end, range[1]);
                    continue;
                }
                if (end != -1 && end < range[0]) {
                    ans.add(new int[] {start, end});
                    end = -1;
                    ans.add(range);
                    continue;
                }
                if (!add && newInterval[1] < range[0]) {
                    ans.add(newInterval);
                    ans.add(range);
                    add = true;
                    continue;
                }
                if ((range[0] <= newInterval[0] && range[1] >= newInterval[0])
                    || (range[0] >= newInterval[0]
                        && range[0] <= newInterval[1])) {
                    start = Math.min(range[0], newInterval[0]);
                    end = Math.max(range[1], newInterval[1]);
                    add = true;
                    continue;
                }
                ans.add(range);
            }

            if (end != -1) {
                ans.add(new int[] {start, end});
            }

            if (!add) {
                ans.add(newInterval);
            }

            return ans.toArray(new int[0][]);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals("[[1,5],[6,9]]", Arrs
        // .toStr(s.insert(Arrs.build2D("[[1,3],[6,9]]"), new int[] {2, 5})));
        Assert.assertEquals("[[1,2],[3,10],[12,16]]",
            Arrs.toStr(
                s.insert(Arrs.build2D("[[1,2],[3,5],[6,7],[8,10],[12,16]]"),
                    new int[] {4, 8})));


    }
}
