package redo.p2000_2099;

import java.util.LinkedList;
import java.util.function.BiPredicate;

public class P2016 {

    class Solution {
        public int maximumDifference(int[] nums) {
            MonotonicQueueTemplate<Integer> mQueue = new MonotonicQueueTemplate<>();

            int diff = -1;

            for (int num : nums) {
                mQueue.removeAndAddLast(num, (o, n) -> n <= o);
                if (mQueue.list.size() > 1) {
                    diff = Math.max(diff, mQueue.list.getLast() - mQueue.list.getFirst());
                }
            }

            return diff;
        }


        public class MonotonicQueueTemplate<E> {
            public LinkedList<E> list = new LinkedList<>();

            public void removeAndAddFirst(E val, BiPredicate<E, E> removeWhenOldAndNew) {
                while (!list.isEmpty() && removeWhenOldAndNew.test(list.getFirst(), val)) {
                    list.removeFirst();
                }
                list.addFirst(val);
            }

            public void removeAndAddLast(E val, BiPredicate<E, E> removeWhenOldAndNew) {
                while (!list.isEmpty() && removeWhenOldAndNew.test(list.getLast(), val)) {
                    list.removeLast();
                }
                list.addLast(val);
            }

            public void maxSizeFromFirst(int size) {
                if (list.size() > size) {
                    list.removeFirst();
                }
            }

            public void maxSizeFromLast(int size) {
                if (list.size() > size) {
                    list.removeLast();
                }
            }
        }
    }

}
