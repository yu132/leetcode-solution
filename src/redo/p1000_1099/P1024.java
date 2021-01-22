package redo.p1000_1099;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1024  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1024 {

    class Solution {
        public int videoStitching(int[][] clips, int T) {

            if (T == 0) {
                return 0;
            }

            Arrays.sort(clips, (a, b) -> Integer.compare(a[0], b[0]));

            int next = 0, nn = 0, count = 0;
            for (int[] clip : clips) {
                if (clip[0] > next) {
                    next = nn;
                    ++count;
                }
                if (clip[0] > next) {
                    return -1;
                }
                nn = Math.max(nn, clip[1]);
                if (nn >= T) {
                    return count + 1;
                }
            }

            return -1;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.videoStitching(Arrs.build2D("[[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]]"), 10));
        Assert.assertEquals(-1, s.videoStitching(Arrs.build2D("[[0,1],[1,2]]"), 5));
        Assert.assertEquals(3,
            s.videoStitching(Arrs.build2D(
                "[[0,1],[6,8],[0,2],[5,6],[0,4],[0,3],[6,7],[1,3],[4,7],[1,4],[2,5],[2,6],[3,4],[4,5],[5,7],[6,9]]"),
                9));
        Assert.assertEquals(2, s.videoStitching(Arrs.build2D("[[0,4],[2,8]]"), 5));
        Assert.assertEquals(2, s.videoStitching(Arrs.build2D("[[0,4],[2,5],[5,8]]"), 5));
        Assert.assertEquals(0, s.videoStitching(Arrs.build2D("[[2,4]]"), 0));
    }

}
