package _0200_0299;

import java.util.ArrayList;
import java.util.LinkedList;

/**  
 * @ClassName: _207  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月29日  
 *  
 */
public class _207 {

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[]                in   = new int[numCourses];
            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] next = new ArrayList[numCourses];
            for (int i = 0; i < next.length; ++i) {
                next[i] = new ArrayList<>();
            }
            for (int i = 0; i < prerequisites.length; ++i) {
                ++in[prerequisites[i][1]];
                next[prerequisites[i][0]].add(prerequisites[i][1]);
            }
            LinkedList<Integer> queue = new LinkedList<>();
            int                 count = 0;
            for (int i = 0; i < in.length; ++i) {
                if (in[i] == 0) {
                    queue.addLast(i);
                }
            }
            while (!queue.isEmpty()) {
                int node = queue.removeFirst();
                ++count;
                for (int i = 0; i < next[node].size(); ++i) {
                    if (--in[next[node].get(i)] == 0) {
                        queue.add(next[node].get(i));
                    }
                }
            }
            return count == numCourses;
        }
    }

}
