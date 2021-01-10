package redo.p1400_1499;

import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1438  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
public class P1438 {

    static//

    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            MonotonousDeque<Data> min = new MonotonousDeque<>(nums.length), max = new MonotonousDeque<>(nums.length);

            int ans = 0, index[] = new int[1];
            for (int[] i = new int[1]; i[0] < nums.length; ++i[0]) {
                Data d = new Data(nums[i[0]], i[0]);
                min.offerAndRemove(d, (data) -> {
                    return data.val > nums[i[0]];
                });
                max.offerAndRemove(d, (data) -> {
                    return data.val < nums[i[0]];
                });
                matain(max, nums, limit, index, i);
                matain(min, nums, limit, index, i);
                ans = Math.max(ans, i[0] - index[0] + 1);
            }

            return ans;
        }

        private void matain(MonotonousDeque<Data> queue, int[] nums, int limit, int[] index, int[] i) {
            queue.keepSize((data) -> {
                if (Math.abs(data.val - nums[i[0]]) > limit) {
                    index[0] = Math.max(index[0], data.index + 1);
                    return true;
                }
                return false;
            });
        }

        class Data {
            int val, index;

            public Data(int val, int index) {
                super();
                this.val = val;
                this.index = index;
            }
        }

        static class MonotonousDeque<T> {

            SimpleArrayDeque<T> deque;

            public MonotonousDeque(int len) {
                super();
                this.deque = new SimpleArrayDeque<T>(len);
            }

            // 添加元素并且保持单调
            public void offerAndRemove(T val, Function<T, Boolean> monotoner) {
                while (!deque.isEmpty() && monotoner.apply(deque.peekLast())) {
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
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.longestSubarray(new int[] {8, 2, 4, 7}, 4));
        Assert.assertEquals(4, s.longestSubarray(new int[] {10, 1, 2, 4, 7, 2}, 5));
        Assert.assertEquals(3, s.longestSubarray(new int[] {4, 2, 2, 2, 4, 4, 2, 2}, 0));
        Assert.assertEquals(6, s.longestSubarray(new int[] {2, 2, 2, 4, 4, 2, 5, 5, 5, 5, 5, 2}, 2));
    }

}
