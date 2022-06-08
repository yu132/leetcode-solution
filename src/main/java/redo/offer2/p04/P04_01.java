package redo.offer2.p04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**  
 * @ClassName: P04_01  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月9日  
 *  
 */
public class P04_01 {

    class Solution {
        public boolean findWhetherExistsPath(int n, int[][] graph, int start,
            int target) {

            List<Integer>[] adjacency = toAdjacency(n, graph);

            Deque<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n];

            queue.offer(start);

            while (!queue.isEmpty()) {
                int node = queue.poll();
                visited[node] = true;
                if (node == target) {
                    return true;
                }
                for (int child : adjacency[node]) {
                    if (visited[child]) {
                        continue;
                    }
                    queue.offer(child);
                }
            }

            return false;
        }

        public List<Integer>[] toAdjacency(int n, int[][] graph) {

            @SuppressWarnings("unchecked")
            List<Integer>[] adjacency = new ArrayList[n];

            Arrays.setAll(adjacency, (x) -> new ArrayList<>());

            for (int[] edge : graph) {
                adjacency[edge[0]].add(edge[1]);
            }

            return adjacency;
        }
    }

}
