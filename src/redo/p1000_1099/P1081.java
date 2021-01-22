package redo.p1000_1099;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1081  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月16日  
 *  
 */
public class P1081 {

    static//

    class Solution {
        public String smallestSubsequence(String s) {
            IntMonotonousDeque mqueue = new IntMonotonousDeque(s.length());
            int[] lastCharIndex = lastCharIndex(s);
            boolean[] used = new boolean[26];

            for (int[] i = new int[1]; i[0] < s.length(); ++i[0]) {
                if (used[s.charAt(i[0]) - 'a']) {
                    continue;
                }
                used[s.charAt(i[0]) - 'a'] = true;
                mqueue.offerAndRemove(s.charAt(i[0]), (last, now) -> {
                    if (now <= last && lastCharIndex[last - 'a'] >= i[0]) {
                        used[last - 'a'] = false;
                        return true;
                    }
                    return false;
                });
            }

            char[] ans = new char[mqueue.size()];

            for (int i = 0; i < ans.length; ++i) {
                ans[i] = (char)mqueue.deque.deque[i];
            }

            return String.valueOf(ans);
        }

        public int[] lastCharIndex(String s) {
            int[] lastCharIndex = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                lastCharIndex[s.charAt(i) - 'a'] = i;
            }
            return lastCharIndex;
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
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("abc", s.smallestSubsequence("bcabc"));
        Assert.assertEquals("acdb", s.smallestSubsequence("cbacdcbc"));
        Assert.assertEquals("dca", s.smallestSubsequence("dca"));
        Assert.assertEquals("acd", s.smallestSubsequence("acdadc"));
    }

}
