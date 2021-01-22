package redo.p1000_1099;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1053  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月17日  
 *  
 */
public class P1053 {

    static//

    class Solution {
        public int[] prevPermOpt1(int[] arr) {
            IntMonotonousDeque mqueue = new IntMonotonousDeque(arr.length);

            boolean flag = true;

            int replace1 = -1, replace2 = -1;

            for (int i = 0; i < arr.length; ++i) {
                if (i != 0 && arr[i - 1] > arr[i]) {
                    flag = false;
                }

                if (i != 0 && arr[i - 1] != arr[i]) {
                    SimpleIntArrayDeque deque = mqueue.deque;
                    int index = upperBound(deque.deque, arr, arr[i], deque.start, deque.end);
                    if (index != deque.start - 1 && deque.deque[index] >= replace1) {
                        replace1 = deque.deque[index];
                        replace2 = i;
                    }
                }

                mqueue.offerAndRemove(i, (last, now) -> arr[last] <= arr[now]);
            }

            if (flag) {
                return arr;
            }

            int temp = arr[replace1];
            arr[replace1] = arr[replace2];
            arr[replace2] = temp;

            return arr;
        }

        public int upperBound(int[] indexes, int[] arr, int target, int low, int high) {
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (arr[indexes[mid]] <= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low - 1;
        }

        static class IntMonotonousDeque {

            SimpleIntArrayDeque deque;

            public IntMonotonousDeque(int len) {
                super();
                this.deque = new SimpleIntArrayDeque(len);
            }

            // 添加元素并且保持单调
            public void offerAndRemove(int num, BiFunction<Integer, Integer, Boolean> monotoner) {
                while (!deque.isEmpty() && monotoner.apply(deque.peekLast(), num)) {
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

            public void clear() {
                deque.clear();
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

            public void clear() {
                start = end = 0;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {3, 1, 2}, s.prevPermOpt1(new int[] {3, 2, 1}));
        Assert.assertArrayEquals(new int[] {1, 1, 5}, s.prevPermOpt1(new int[] {1, 1, 5}));
        Assert.assertArrayEquals(new int[] {1, 7, 4, 6, 9}, s.prevPermOpt1(new int[] {1, 9, 4, 6, 7}));
        Assert.assertArrayEquals(new int[] {1, 3, 1, 3}, s.prevPermOpt1(new int[] {3, 1, 1, 3}));

        Assert.assertArrayEquals(
            new int[] {6, 1, 5, 9, 1, 1, 9, 7, 7, 9, 7, 6, 2, 7, 3, 4, 5, 1, 7, 6, 3, 5, 3, 1, 4, 7, 1, 1, 8, 8, 9, 1,
                9, 5, 1, 6, 5, 4, 7, 3, 2, 7, 4, 9, 7, 6, 2, 5, 7, 4, 3, 7, 5, 5, 4, 4, 2, 1, 3, 1, 6, 4, 8, 7, 5, 9, 3,
                1, 4, 4, 7, 5, 3, 7, 2, 4, 4, 8, 5, 4, 8, 1, 1, 3, 4, 3, 5, 4, 8, 1, 5, 4, 9, 8, 4, 5, 1, 3, 1, 3},

            s.prevPermOpt1(new int[] {6, 1, 5, 9, 1, 1, 9, 7, 7, 9, 7, 6, 2, 7, 3, 4, 5, 1, 7, 6, 3, 5, 3, 1, 4, 7, 1,
                1, 8, 8, 9, 1, 9, 5, 1, 6, 5, 4, 7, 3, 2, 7, 4, 9, 7, 6, 2, 5, 7, 4, 3, 7, 5, 5, 4, 4, 2, 1, 3, 1, 6, 4,
                8, 7, 5, 9, 3, 1, 4, 4, 7, 5, 3, 7, 2, 4, 4, 8, 5, 4, 8, 1, 1, 3, 4, 3, 5, 4, 8, 1, 5, 4, 9, 8, 4, 5, 3,
                1, 1, 3}));
    }

}
