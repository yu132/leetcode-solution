package redo.p0900_0999;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P986  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月20日  
 *  
 */
public class P986 {

    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

            List<int[]> ans = new ArrayList<>();

            for (int i1 = 0, i2 = 0; i1 < firstList.length && i2 < secondList.length;) {
                int[] low, high;
                if (firstList[i1][1] > secondList[i2][1]) {
                    low = secondList[i2++];
                    high = firstList[i1];
                } else {
                    low = firstList[i1++];
                    high = secondList[i2];
                }
                if (low[1] < high[0]) {// 没有交集
                    continue;
                }
                ans.add(new int[] {Math.max(low[0], high[0]), low[1]});
            }

            return ans.toArray(new int[0][]);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]",
            Arrs.toStr(s.intervalIntersection(Arrs.build2D("[[0,2],[5,10],[13,23],[24,25]]"),
                Arrs.build2D("[[1,5],[8,12],[15,24],[25,26]]"))));
        Assert.assertEquals("[]",
            Arrs.toStr(s.intervalIntersection(Arrs.build2D("[[1,3],[5,9]]"), Arrs.build2D("[]"))));
        Assert.assertEquals("[]",
            Arrs.toStr(s.intervalIntersection(Arrs.build2D("[]"), Arrs.build2D("[[4,8],[10,12]]"))));
        Assert.assertEquals("[[3,7]]",
            Arrs.toStr(s.intervalIntersection(Arrs.build2D("[[1,7]]"), Arrs.build2D("[[3,10]]"))));
    }

}
