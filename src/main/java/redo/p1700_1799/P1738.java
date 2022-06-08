package redo.p1700_1799;

import java.util.PriorityQueue;

public class P1738 {

    class Solution {
        public int kthLargestValue(int[][] matrix, int k) {

            TopMaintainer<Integer> top = new TopMaintainer<>(k);

            int[][] prefix = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    prefix[i + 1][j + 1] = matrix[i][j] ^ prefix[i][j + 1]
                            ^ prefix[i + 1][j] ^ prefix[i][j];
                    top.put(prefix[i + 1][j + 1]);
                }
            }
            return top.top();
        }

        class TopMaintainer<E extends Comparable<E>> {

            PriorityQueue<E> pq;

            int k;

            public TopMaintainer(int k) {
                this.k = k;
                pq = new PriorityQueue<>(k);
            }

            public E top() {
                return pq.peek();
            }

            public void put(E element) {
                if (pq.size() < k) {
                    pq.offer(element);
                } else {
                    if (element.compareTo(pq.peek()) > 0) {
                        pq.poll();
                        pq.offer(element);
                    }
                }
            }
        }

    }

}
