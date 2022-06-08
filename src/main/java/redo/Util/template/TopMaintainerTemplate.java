package redo.Util.template;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class TopMaintainerTemplate {

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

    class TopDistinctMaintainer<E extends Comparable<E>> {

        PriorityQueue<E> pq;

        Set<E> set;

        int k;

        public TopDistinctMaintainer(int k) {
            this.k = k;
            pq = new PriorityQueue<>(k);
            set = new HashSet<>(k);
        }

        public void put(E element) {
            if (set.contains(element)) {
                return;
            }
            if (pq.size() >= k) {
                if (element.compareTo(pq.peek()) > 0) {
                    set.remove(pq.poll());
                } else {
                    return;
                }
            }
            pq.offer(element);
            set.add(element);
        }
    }

}
