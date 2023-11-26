package redo.p2900_2999;

import redo.testUtil.Arrs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class P2940 {

    static
            //
    class Solution {
        public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
            Map<int[], Integer> indexMap = new HashMap<>();
            for (int i = 0; i < queries.length; ++i) {
                int[] query = queries[i];
                indexMap.put(query, i);
                if (query[0] > query[1]) {
                    int temp = query[0];
                    query[0] = query[1];
                    query[1] = temp;
                }
            }
            Arrays.sort(queries, Comparator.<int[]>comparingInt(a -> a[1]).thenComparing(a -> a[0]));
            MonotonousDeque<Node> mQueue = new MonotonousDeque<>(heights.length);
            int[] ans = new int[queries.length];
            for (int i = queries.length - 1, j = heights.length - 1; i >= 0; --i) {
                int x = queries[i][0], y = queries[i][1];
                if (x == y) {
                    ans[indexMap.get(queries[i])] = y;
                    continue;
                }
                if (heights[y] > heights[x]) {
                    ans[indexMap.get(queries[i])] = y;
                    continue;
                }
                while (j >= y) {
                    mQueue.offerAndRemove(new Node(heights[j], j), (o, n) -> n.val > o.val);
                    --j;
                }
                int maxVal = Math.max(heights[x], heights[y]);
                int idx = binarySearchMax(mQueue.start(), mQueue.end(), mid -> mQueue.get(mid).val > maxVal);
                ans[indexMap.get(queries[i])] = idx == mQueue.start() - 1 ? -1 : mQueue.get(idx).index;
            }
            return ans;
        }

        //judgeRange = [low,high-1], returnRange = [low-1,high-1]
        public int binarySearchMax(int low, int high, Function<Integer, Boolean> judge) {
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (judge.apply(mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low - 1;
        }

        static class Node {
            int val;
            int index;

            public Node(int val, int index) {
                this.val = val;
                this.index = index;
            }
        }

        static class MonotonousDeque<T> {

            SimpleArrayDeque<T> deque;

            public MonotonousDeque(int len) {
                super();
                this.deque = new SimpleArrayDeque<>(len);
            }

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

            public int start() {
                return deque.start;
            }

            public int end() {
                return deque.end;
            }

            public T get(int index) {
                return deque.get(index);
            }

            public void values(Consumer<T> consumer) {
                for (int i = start(); i < end(); ++i) {
                    consumer.accept(deque.deque[i]);
                }
            }

            static class SimpleArrayDeque<T> {

                int start = 0, end = 0;
                T[] deque;

                @SuppressWarnings("unchecked")
                public SimpleArrayDeque(int len) {
                    super();
                    this.deque = (T[]) new Object[len];
                }

                public T get(int index) {
                    return deque[index];
                }

                public void offerLast(T num) {
                    deque[end++] = num;
                }

                public T pollLast() {
                    return deque[--end];
                }

                public T peekLast() {
                    return deque[end - 1];
                }

                public T pollFirst() {
                    return deque[start++];
                }

                public T peekFirst() {
                    return deque[start];
                }

                public boolean isEmpty() {
                    return start == end;
                }

                public int size() {
                    return end - start;
                }

                public void clear() {
                    start = end = 0;
                }
            }
        }
    }


    //[1,2,1,2,1,2]

    //[[0,0],[0,1],[0,2],[0,3],[0,4],[0,5],[1,0],[1,1],[1,2],[1,3],[1,4],[1,5],[2,0],[2,1],[2,2],[2,3],[2,4],[2,5],[3,0],[3,1],[3,2],[3,3],[3,4],[3,5],[4,0],[4,1],[4,2],[4,3],[4,4],[4,5],[5,0],[5,1],[5,2],[5,3],[5,4],[5,5]]


    public static void main(String[] args) {
        int[] ans = new Solution().leftmostBuildingQueries(Arrs.build("[6,4,8,5,2,7]"), Arrs.build2D("[[0,1],[0,3],[2,4],[3,4],[2,2]]"));
        System.out.println(Arrays.toString(ans));
    }

}
