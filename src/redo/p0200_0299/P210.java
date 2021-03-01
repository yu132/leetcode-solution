package redo.p0200_0299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**  
 * @ClassName: P210  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P210 {

    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer>[] adjac = toAdjac(numCourses, prerequisites);

            Deque<Integer> queue = new LinkedList<>();

            int[] in = new int[numCourses];

            for (int[] edge : prerequisites) {
                ++in[edge[0]];
            }

            for (int i = 0; i < numCourses; ++i) {
                if (in[i] == 0) {
                    queue.offer(i);
                }
            }

            int[] ans = new int[numCourses];
            int index = 0;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                ans[index++] = node;
                for (int child : adjac[node]) {
                    --in[child];
                    if (in[child] == 0) {
                        queue.offer(child);
                    }
                }
            }

            if (index != numCourses) {
                return new int[0];
            }

            return ans;
        }

        List<Integer>[] toAdjac(int n, int[][] edges) {
            @SuppressWarnings("unchecked")
            List<Integer>[] adjac = new ArrayList[n];
            Arrays.setAll(adjac, (x) -> new ArrayList<>());

            for (int[] edge : edges) {
                adjac[edge[1]].add(edge[0]);
            }

            return adjac;
        }
    }

}
