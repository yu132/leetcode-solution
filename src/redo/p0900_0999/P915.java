package redo.p0900_0999;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P915  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月25日  
 *  
 */
public class P915 {

    static//

    class Solution {
        public int partitionDisjoint(int[] A) {
            SimpleArrayDeque<MinValue> mqueue = new SimpleArrayDeque<>(A.length);

            for (int i = A.length - 1; i >= 0; --i) {
                if (mqueue.isEmpty() || A[i] < mqueue.peekLast().val) {
                    mqueue.offerLast(new MinValue(i, A[i]));
                }
            }

            int max = -1;
            for (int i = 0; i < A.length; ++i) {
                max = Math.max(max, A[i]);
                if (mqueue.peekLast().index == i) {
                    mqueue.pollLast();
                }
                if (mqueue.isEmpty() || mqueue.peekLast().val >= max) {
                    return i + 1;
                }
            }

            throw new RuntimeException("unreachable");
        }

        static class MinValue {
            int index, val;

            public MinValue(int index, int val) {
                super();
                this.index = index;
                this.val = val;
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



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(3, s.partitionDisjoint(new int[] {5, 0, 3, 8, 6}));
        Assert.assertEquals(4, s.partitionDisjoint(new int[] {1, 1, 1, 0, 6, 12}));
    }

}
