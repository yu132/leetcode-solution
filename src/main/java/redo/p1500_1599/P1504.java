package redo.p1500_1599;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;


/**  
 * @ClassName: P1504  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class P1504 {

    static//

    class Solution {
        public int numSubmat(int[][] mat) {
            int[][] rowPrefix = new int[mat.length][mat[0].length];
            for (int i = 0; i < mat.length; ++i) {
                rowPrefix[i][0] = mat[i][0];
                for (int j = 1; j < mat[0].length; ++j) {
                    rowPrefix[i][j] = (mat[i][j] == 0 ? 0 : rowPrefix[i][j - 1] + 1);
                }
            }

            MonotonousDeque<Node> nodes = new MonotonousDeque<>(mat.length);
            int sum = 0;
            for (int j = 0; j < mat[0].length; ++j) {
                int[] sumCol = new int[1];
                nodes.clear();
                for (int i = 0; i < mat.length; ++i) {
                    nodes.offerAndRemove(new Node(rowPrefix[i][j], 1), (last, now) -> {
                        if (now.rowLen <= last.rowLen) {
                            now.colLen += last.colLen;
                            sumCol[0] -= (last.rowLen - now.rowLen) * last.colLen;
                            return true;
                        }
                        return false;
                    });
                    sumCol[0] += rowPrefix[i][j];
                    sum += sumCol[0];
                }
            }
            return sum;
        }

        static class Node {
            int rowLen;
            int colLen;

            public Node(int rowLen, int colLen) {
                super();
                this.rowLen = rowLen;
                this.colLen = colLen;
            }
        }

        static class MonotonousDeque<T> {

            SimpleArrayDeque<T> deque;

            public MonotonousDeque(int len) {
                super();
                this.deque = new SimpleArrayDeque<T>(len);
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

            public T[] deque() {
                return deque.deque;
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
                    this.deque = (T[])new Object[len];
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



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(13, s.numSubmat(Arrs.build2D("[[1,0,1],[1,1,0],[1,1,0]]")));

        Assert.assertEquals(24, s.numSubmat(Arrs.build2D("[[0,1,1,0],[0,1,1,1],[1,1,1,0]]")));

        Assert.assertEquals(21, s.numSubmat(Arrs.build2D("[[1,1,1,1,1,1]]")));

        Assert.assertEquals(5, s.numSubmat(Arrs.build2D("[[1,0,1],[0,1,0],[1,0,1]]")));
    }

}
