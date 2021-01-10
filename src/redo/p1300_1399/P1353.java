package redo.p1300_1399;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1353  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1353 {

    static//

    class Solution {
        public int maxEvents(int[][] events) {
            Arrays.sort(events, (a, b) -> {
                return Integer.compare(a[1], b[1]);
            });
            NextHelper next = new NextHelper(max(events) + 1);
            int count = 0;

            for (int[] event : events) {
                int nextIndex = next.findNext(event[0]);
                if (nextIndex == -1) {
                    continue;
                }
                if (nextIndex <= event[1]) {
                    ++count;
                    next.use(nextIndex);
                }
            }

            return count;
        }

        int max(int[][] events) {
            int max = 0;
            for (int[] event : events) {
                max = Math.max(max, event[1]);
            }
            return max;
        }

        static class NextHelper {
            int[] next;

            NextHelper(int len) {
                next = new int[len];
                Arrays.setAll(next, (x) -> x);
            }

            int findNext(int index) {
                if (index < 0 || index >= next.length) {
                    return -1;
                }
                if (next[index] == index) {
                    return index;
                } else {
                    return next[index] = findNext(next[index]);
                }
            }

            void use(int index) {
                next[index] = index + 1;
            }
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.maxEvents(Arrs.build2D("[[1,2],[2,3],[3,4]]")));
        Assert.assertEquals(4, s.maxEvents(Arrs.build2D("[[1,2],[2,3],[3,4],[1,2]]")));
        Assert.assertEquals(4, s.maxEvents(Arrs.build2D("[[1,4],[4,4],[2,2],[3,4],[1,1]]")));
        Assert.assertEquals(1, s.maxEvents(Arrs.build2D("[[1,100000]]")));
        Assert.assertEquals(7, s.maxEvents(Arrs.build2D("[[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]")));
        Assert.assertEquals(4, s.maxEvents(Arrs.build2D("[[1,2],[2,2],[3,3],[3,4],[3,4]]")));
        Assert.assertEquals(5, s.maxEvents(Arrs.build2D("[[1,2],[1,2],[3,3],[1,5],[1,5]]")));
    }

}
