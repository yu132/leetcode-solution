package redo.p1400_1499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1466  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1466 {

    static//

    class Solution {
        public int minReorder(int n, int[][] connections) {
            @SuppressWarnings("unchecked")
            List<Integer>[] in = new ArrayList[n], out = new ArrayList[n];

            Arrays.setAll(in, (x) -> new ArrayList<>());
            Arrays.setAll(out, (x) -> new ArrayList<>());

            for (int[] conn : connections) {
                out[conn[0]].add(conn[1]);
                in[conn[1]].add(conn[0]);
            }

            int count = 0;

            boolean[] visited = new boolean[n];

            SimpleIntArrayDeque queue = new SimpleIntArrayDeque(n);

            queue.offerLast(0);

            while (!queue.isEmpty()) {
                int now = queue.pollFirst();
                visited[now] = true;
                for (int inPoint : in[now]) {
                    if (!visited[inPoint]) {
                        queue.offerLast(inPoint);
                    }
                }
                for (int outPoint : out[now]) {
                    if (!visited[outPoint]) {
                        ++count;
                        queue.offerLast(outPoint);
                    }
                }
            }

            return count;
        }

        static class SimpleIntArrayDeque {

            int start = 0, end = 0, deque[];

            public SimpleIntArrayDeque(int len) {
                super();
                this.deque = new int[len];
            }

            public void offerLast(int num) {
                deque[end++] = num;
            }

            public int pollLast() {
                return deque[--end];
            }

            public int peekLast() {
                return deque[end - 1];
            }

            public int pollFirst() {
                return deque[start++];
            }

            public int peekFirst() {
                return deque[start];
            }

            public boolean isEmpty() {
                return start == end;
            }

            public int size() {
                return end - start;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.minReorder(6, Arrs.build2D("[[0,1],[1,3],[2,3],[4,0],[4,5]]")));

        Assert.assertEquals(2, s.minReorder(5, Arrs.build2D("[[1,0],[1,2],[3,2],[3,4]]")));

        Assert.assertEquals(0, s.minReorder(3, Arrs.build2D("[[1,0],[2,0]]")));


    }

}
