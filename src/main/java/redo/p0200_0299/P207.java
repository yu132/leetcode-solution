package redo.p0200_0299;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**  
 * @ClassName: P207  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P207 {

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph =
                toOrderlyAdjacency(numCourses, prerequisites);

            int[] eds = countEnterDegree(graph);

            Deque<Integer> queue = new LinkedList<>();

            int count = 0;

            for (int i = 0; i < numCourses; ++i) {
                if (eds[i] == 0) {
                    queue.offer(i);
                    ++count;
                }
            }

            while (!queue.isEmpty()) {

                int node = queue.poll();

                for (int child : graph[node]) {
                    --eds[child];
                    if (eds[child] == 0) {
                        queue.offer(child);
                        ++count;
                    }
                }
            }

            return count == numCourses;
        }

        public int[] countEnterDegree(List<Integer>[] graph) {
            int[] ed = new int[graph.length];
            for (int i = 0; i < ed.length; ++i) {
                for (int child : graph[i]) {
                    ++ed[child];
                }
            }
            return ed;
        }

        // 有向图
        public List<Integer>[] toOrderlyAdjacency(int n, int[][] edges) {
            @SuppressWarnings("unchecked")
            List<Integer>[] adjacency = new ArrayList[n];

            for (int i = 0; i < adjacency.length; ++i) {
                adjacency[i] = new ArrayList<>();
            }

            for (int[] edge : edges) {
                adjacency[edge[0]].add(edge[1]);
            }

            return adjacency;
        }
    }

}
