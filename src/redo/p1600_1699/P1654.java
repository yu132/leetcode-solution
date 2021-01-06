package redo.p1600_1699;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1654  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class P1654 {

    static//

    class Solution {
        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            boolean[] visited = new boolean[8050];
            for (int num : forbidden) {
                visited[num] = true;
            }
            Deque<Data> queue = new LinkedList<>();

            queue.offer(new Data(0, 0, true));

            while (!queue.isEmpty()) {
                Data data = queue.poll();
                if (data.index < 0 || data.index >= 8050) {
                    continue;
                }
                if (visited[data.index]) {
                    continue;
                }
                if (data.index == x) {
                    return data.step;
                }
                visited[data.index] = true;
                if (!data.backtrace) {
                    queue.offer(new Data(data.index - b, data.step + 1, true));
                }
                queue.offer(new Data(data.index + a, data.step + 1, false));
            }

            return -1;
        }

        class Data {
            int index;
            int step;
            boolean backtrace;

            public Data(int index, int step, boolean backtrace) {
                super();
                this.index = index;
                this.step = step;
                this.backtrace = backtrace;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.minimumJumps(new int[] {14, 4, 18, 1, 15}, 3, 15, 9));
        Assert.assertEquals(-1, s.minimumJumps(new int[] {8, 3, 16, 6, 12, 20}, 3, 15, 9));
        Assert.assertEquals(2, s.minimumJumps(new int[] {1, 6, 2, 14, 5, 17, 4}, 16, 9, 7));
        Assert.assertEquals(121,
            s.minimumJumps(new int[] {162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193,
                84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14,
                176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98}, 29, 98, 80));

        Assert.assertEquals(3998, s.minimumJumps(new int[] {1998}, 1999, 2000, 2000));

        Assert.assertEquals(1036, s.minimumJumps(new int[] {1362, 873, 1879, 725, 305, 794, 1135, 1358, 1717, 159, 1370,
            1861, 583, 1193, 1921, 778, 1263, 239, 1224, 1925, 1505, 566, 5, 15}, 560, 573, 64));
    }

}
