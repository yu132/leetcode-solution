package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P190  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月14日  
 *  
 */
public class P1190 {

    static//

    class Solution {
        public String reverseParentheses(String s) {
            FixedIntArrayStack stack = new FixedIntArrayStack(s.length() / 2);

            int[] pair = new int[s.length()];

            char[] chs = s.toCharArray();
            for (int i = 0; i < s.length(); ++i) {
                if (chs[i] == '(') {
                    stack.push(i);
                } else if (chs[i] == ')') {
                    pair[stack.peek()] = i;
                    pair[i] = stack.pop();
                }
            }

            StringBuilder buf = new StringBuilder(s.length());

            for (int i = 0, d = 1; i < s.length(); i += d) {
                if (chs[i] == '(' || chs[i] == ')') {
                    i = pair[i];
                    d = -d;
                } else {
                    buf.append(chs[i]);
                }
            }

            return buf.toString();
        }

        static class FixedIntArrayStack {
            int index = 0, stack[];

            public FixedIntArrayStack(int len) {
                super();
                this.stack = new int[len];
            }

            public void push(int num) {
                stack[index++] = num;
            }

            public int pop() {
                return stack[--index];
            }

            public int peek() {
                return stack[index - 1];
            }

            public boolean isEmpty() {
                return index == 0;
            }

            public int size() {
                return index;
            }
        }
    }


    // class Solution {
    // public String reverseParentheses(String s) {
    // FixedIntArrayStack stack = new FixedIntArrayStack(s.length() / 2);
    // List<int[]> ranges = new ArrayList<>();
    // char[] chs = s.toCharArray();
    // for (int i = 0; i < s.length(); ++i) {
    // if (chs[i] == '(') {
    // stack.push(i);
    // } else if (chs[i] == ')') {
    // ranges.add(new int[] {stack.peek() + 1, i - 1});
    // stack.pop();
    // }
    // }
    //
    // for (int[] range : ranges) {
    // reverse(chs, range[0], range[1]);
    // }
    //
    // StringBuilder buf = new StringBuilder(s.length());
    // for (char ch : chs) {
    // if (ch == '(' || ch == ')') {
    // continue;
    // }
    // buf.append(ch);
    // }
    // return buf.toString();
    // }
    //
    // public static void reverse(char[] array, int from, int to) {
    // for (; from < to; ++from, --to) {
    // while (array[from] == '(') {
    // ++from;
    // }
    // while (array[to] == ')') {
    // --to;
    // }
    // swap(array, from, to);
    // }
    // }
    //
    // public static void swap(char[] array, int x, int y) {
    // char num = array[x];
    // array[x] = array[y];
    // array[y] = num;
    // }
    //
    // static class FixedIntArrayStack {
    // int index = 0, stack[];
    //
    // public FixedIntArrayStack(int len) {
    // super();
    // this.stack = new int[len];
    // }
    //
    // public void push(int num) {
    // stack[index++] = num;
    // }
    //
    // public int pop() {
    // return stack[--index];
    // }
    //
    // public int peek() {
    // return stack[index - 1];
    // }
    //
    // public boolean isEmpty() {
    // return index == 0;
    // }
    //
    // public int size() {
    // return index;
    // }
    // }
    // }


    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("dcba", s.reverseParentheses("(abcd)"));
        Assert.assertEquals("iloveu", s.reverseParentheses("(u(love)i)"));
        Assert.assertEquals("leetcode", s.reverseParentheses("(ed(et(oc))el)"));
        Assert.assertEquals("apmnolkjihgfedcbq", s.reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

}
