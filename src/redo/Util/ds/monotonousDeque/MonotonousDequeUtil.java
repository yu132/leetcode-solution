package redo.Util.ds.monotonousDeque;

import java.util.function.Consumer;
import java.util.function.Function;

/**  
 * @ClassName: MonotonousDeque  
 *
 * @Description: 
 * 
 *  内部维持单调不变的双端队列，用于线性优化某种有规律的查找情况，
 *  当出现例如a[i+1]<a[i]，而a[i]此时能被排除在查找范围之外的情况，
 *  则此时使用单调队列能优化至O(n)
 *
 * @author 余定邦  
 *
 * @date 2020年12月31日  
 *  
 */
public class MonotonousDequeUtil {


    // checked leetcode 1673
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
