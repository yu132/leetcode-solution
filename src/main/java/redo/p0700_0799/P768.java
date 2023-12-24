package redo.p0700_0799;

import java.util.LinkedList;
import java.util.function.BiFunction;
import java.util.function.Function;

public class P768 {

    class Solution {
        public int maxChunksToSorted(int[] arr) {
            LinkedMonotonousDeque<Node> mdq = new LinkedMonotonousDeque<>();

            for (int num : arr) {
                mdq.offerAndRemove(new Node(num, num), (o, n) -> {
                    if (n.min >= o.max) {
                        return false;
                    }
                    n.min = Math.min(o.min, n.min);
                    n.max = Math.max(o.max, n.max);
                    return true;
                });
            }

            return mdq.size();
        }

        class Node {
            int min, max;

            public Node(int min, int max) {
                this.min = min;
                this.max = max;
            }
        }


        class LinkedMonotonousDeque<T> {

            LinkedList<T> deque = new LinkedList<>();

            // 添加元素并且保持单调
            public void offerAndRemove(T val, BiFunction<T, T, Boolean> monotoner) {
                while (!deque.isEmpty() && monotoner.apply(deque.peekLast(), val)) {
                    deque.pollLast();
                }
                deque.offerLast(val);
            }

            // 删除最旧的元素，用于保持队列大小或者删除过期项目
            public void keepSize(Function<T, Boolean> sizeKeeper) {
                while (!deque.isEmpty() && sizeKeeper.apply(deque.peekFirst())) {
                    deque.pollFirst();
                }
            }

            public int size() {
                return deque.size();
            }

            public void clear() {
                deque.clear();
            }

            public T first() {
                return deque.getFirst();
            }

            public T end() {
                return deque.getLast();
            }
        }
    }

}
