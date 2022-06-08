package redo.p1600_1699;

import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1673  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class P1673 {

    static//

    class Solution {
        public int[] mostCompetitive(int[] nums, int k) {

            IntMonotonousDeque queue = new IntMonotonousDeque(nums.length);

            for (int[] i = new int[1]; i[0] < nums.length; ++i[0]) {
                queue.offerAndRemove(nums[i[0]], (topNum) -> {
                    return nums.length - i[0] + queue.size() > k && nums[i[0]] < topNum;
                });
            }

            int[] ans = new int[k];

            for (int i = 0; i < k; ++i) {
                ans[i] = queue.deque()[i + queue.start()];
            }

            return ans;
        }

        static class IntMonotonousDeque {

            SimpleIntArrayDeque deque;

            public IntMonotonousDeque(int len) {
                super();
                this.deque = new SimpleIntArrayDeque(len);
            }

            // 添加元素并且保持单调
            public void offerAndRemove(int num, Function<Integer, Boolean> monotoner) {
                while (!deque.isEmpty() && monotoner.apply(deque.peekLast())) {
                    deque.pollLast();
                }
                deque.offerLast(num);
            }

            // 删除最旧的元素，用于保持队列大小或者删除过期项目
            public void keepSize(Function<Integer, Boolean> sizeKeeper) {
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

            public int[] deque() {
                return deque.deque;
            }

            public void values(Consumer<Integer> consumer) {
                for (int i = start(); i < end(); ++i) {
                    consumer.accept(deque.deque[i]);
                }
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
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {2, 6}, s.mostCompetitive(new int[] {3, 5, 2, 6}, 2));
        Assert.assertArrayEquals(new int[] {2, 3, 3, 4}, s.mostCompetitive(new int[] {2, 4, 3, 3, 5, 4, 9, 6}, 4));
        Assert.assertArrayEquals(new int[] {8, 80, 2},
            s.mostCompetitive(new int[] {71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3));
    }
}
