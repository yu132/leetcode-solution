package _0800_0899;

import java.util.ArrayList;

/**  
 * @ClassName: _886  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月3日  
 *  
 */
public class _886 {

    class Solution {
        public boolean possibleBipartition(int N, int[][] dislikes) {

            @SuppressWarnings("unchecked")
            ArrayList<Integer>[] graph = new ArrayList[N + 1];

            for (int i = 1; i <= N; ++i) {
                graph[i] = new ArrayList<>();
            }

            for (int[] each : dislikes) {
                graph[each[0]].add(each[1]);
                graph[each[1]].add(each[0]);
            }

            boolean[] visited = new boolean[N + 1];
            int[]     type    = new int[N + 1];

            for (int i = 1; i <= N; ++i) {
                if (visited[i]) {
                    continue;
                }
                if (!helper(i, 1, visited, type, graph)) {
                    return false;
                }
            }

            return true;
        }

        public boolean helper(int loc, int typeNow, boolean[] visited, int[] type, ArrayList<Integer>[] graph) {
            if (visited[loc]) {
                return type[loc] == typeNow;
            }

            type[loc]    = typeNow;
            visited[loc] = true;

            int typeNext = typeNow == 1 ? 2 : 1;

            for (int each : graph[loc]) {
                if (!helper(each, typeNext, visited, type, graph)) {
                    return false;
                }
            }

            return true;
        }
    }

}
