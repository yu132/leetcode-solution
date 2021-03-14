package redo.p0800_0899;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**  
 * @ClassName: P815  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月7日  
 *  
 */
public class P815 {

    class Solution {
        public int numBusesToDestination(int[][] routes, int source,
            int target) {

            Deque<Integer> queue = new LinkedList<>();

            queue.offer(source);

            @SuppressWarnings("unchecked")
            Set<Integer>[] checker = new HashSet[routes.length];

            Arrays.setAll(checker, (x) -> new HashSet<>());

            boolean sourceShown = false, targetShown = false;

            for (int i = 0; i < routes.length; ++i) {
                for (int station : routes[i]) {
                    checker[i].add(station);
                    if (station == source) {
                        sourceShown = true;
                    }
                    if (station == target) {
                        targetShown = true;
                    }
                }
            }

            if (!sourceShown || !targetShown) {
                return -1;
            }

            int size = 0, level = -1;

            Set<Integer> visited = new HashSet<>();
            visited.add(source);

            while (!queue.isEmpty()) {
                if (size == 0) {
                    size = queue.size();
                    ++level;
                }

                int node = queue.poll();

                if (node == target) {
                    return level;
                }

                for (int i = 0; i < routes.length; ++i) {
                    if (checker[i].contains(node)) {
                        for (int station : routes[i]) {
                            if (!visited.contains(station)) {
                                queue.offer(station);
                                visited.add(station);
                            }
                        }
                    }
                }

                --size;
            }
            return -1;
        }
    }

}
