package redo.p1400_1499;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1475  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1475 {

    static//

    class Solution {
        public int[] finalPrices(int[] prices) {
            FixedIntArrayStack stack = new FixedIntArrayStack(prices.length);
            FixedIntArrayStack stackIndex = new FixedIntArrayStack(prices.length);
            for (int i = 0; i < prices.length; ++i) {
                int num = prices[i];
                while (!stack.isEmpty() && num <= stack.peek()) {
                    prices[stackIndex.pop()] = stack.pop() - num;
                }
                stack.push(num);
                stackIndex.push(i);
            }
            while (!stack.isEmpty()) {
                prices[stackIndex.pop()] = stack.pop();
            }
            return prices;
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
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new int[] {4, 2, 4, 2, 3}, s.finalPrices(new int[] {8, 4, 6, 2, 3}));
        Assert.assertArrayEquals(new int[] {1, 2, 3, 4, 5}, s.finalPrices(new int[] {1, 2, 3, 4, 5}));
        Assert.assertArrayEquals(new int[] {9, 0, 1, 6}, s.finalPrices(new int[] {10, 1, 1, 6}));
    }

}
