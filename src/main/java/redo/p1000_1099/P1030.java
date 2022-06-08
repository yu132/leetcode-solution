package redo.p1000_1099;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**  
 * @ClassName: P030  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月26日  
 *  
 */
public class P1030 {

    class Solution {
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            Deque<int[]> queue = new LinkedList<>();
            List<int[]> ans = new ArrayList<>();
            queue.offer(new int[] {r0, c0});
            boolean[][] visited = new boolean[R][C];
            while (!queue.isEmpty()) {
                int[] p = queue.poll();
                if (p[0] < 0 || p[0] >= R || p[1] < 0 || p[1] >= C) {
                    continue;
                }
                if (visited[p[0]][p[1]]) {
                    continue;
                }
                visited[p[0]][p[1]] = true;
                ans.add(p);
                queue.offer(new int[] {p[0] - 1, p[1]});
                queue.offer(new int[] {p[0] + 1, p[1]});
                queue.offer(new int[] {p[0], p[1] - 1});
                queue.offer(new int[] {p[0], p[1] + 1});
            }
            return ans.toArray(new int[0][]);
        }
    }

}
