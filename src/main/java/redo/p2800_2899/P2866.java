package redo.p2800_2899;

import redo.testUtil.Arrs;

import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class P2866 {

    class Solution {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            long[] left = new long[maxHeights.size()];
            long[] right = new long[maxHeights.size()];

            LinkedMonotonousDeque<Node> mDq = new LinkedMonotonousDeque<>();
            long[] sum = new long[1];
            for (int i = 0; i < maxHeights.size(); ++i) {
                mDq.offerAndRemove(new Node(1, maxHeights.get(i)), (old, _new) -> {
                    if (old.height > _new.height) {
                        sum[0] -= old.height * old.x;
                        _new.x += old.x;
                        return true;
                    }
                    return false;
                });
                Node peek = mDq.end();
                sum[0] += peek.height * peek.x;
                left[i] = sum[0];
            }
            sum[0] = 0;
            mDq.clear();
            for (int i = maxHeights.size() - 1; i >= 0; --i) {
                mDq.offerAndRemove(new Node(1, maxHeights.get(i)), (old, _new) -> {
                    if (old.height > _new.height) {
                        sum[0] -= old.height * old.x;
                        _new.x += old.x;
                        return true;
                    }
                    return false;
                });
                Node peek = mDq.end();
                sum[0] += peek.height * peek.x;
                right[i] = sum[0];
            }
            long ans = 0;
            for (int i = 0; i < maxHeights.size(); ++i) {
                ans = Math.max(ans, left[i] + right[i] - maxHeights.get(i));
            }
            return ans;
        }

        class Node {
            long x, height;

            public Node(long x, long height) {
                this.x = x;
                this.height = height;
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

    public static void main(String[] args) {
        long ans = new P2866().new Solution().maximumSumOfHeights(Arrs.buildL("[6,5,3,9,2,7]"));
        System.out.println(ans);
    }

}
