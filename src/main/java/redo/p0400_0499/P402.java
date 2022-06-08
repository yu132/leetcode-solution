package redo.p0400_0499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P402  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月16日  
 *  
 */
public class P402 {

    static//

    class Solution {
        public String removeKdigits(String num, int k) {

            SimpleIntArrayDeque stack = new SimpleIntArrayDeque(num.length());

            for (int i = 0; i < num.length(); ++i) {
                while (!stack.isEmpty() && stack.peekLast() > num.charAt(i) - '0' && k > 0) {
                    stack.pollLast();
                    --k;
                }
                stack.offerLast(num.charAt(i) - '0');
            }

            StringBuilder buf = new StringBuilder(k);

            boolean first0 = true;

            for (int i = 0, len = stack.size() - k; i < len; ++i) {
                if (first0) {
                    if (stack.peekFirst() == 0) {
                        stack.pollFirst();
                        continue;
                    } else {
                        first0 = false;
                    }
                }
                buf.append(stack.pollFirst());
            }

            return buf.length() == 0 ? "0" : buf.toString();
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
        Assert.assertEquals("1219", s.removeKdigits("1432219", 3));
        Assert.assertEquals("200", s.removeKdigits("10200", 1));
        Assert.assertEquals("0", s.removeKdigits("10", 2));
        Assert.assertEquals("0", s.removeKdigits("9", 1));
    }

}
