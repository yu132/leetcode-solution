package redo.p0000_0099;

import java.util.Deque;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P84  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P84 {

    static//

    class Solution {
        public int largestRectangleArea(int[] heights) {
            int max = 0;
            Deque<Data> stack = new LinkedList<>();

            for (int i = 0; i < heights.length; ++i) {
                int index = i;
                while (!stack.isEmpty() && stack.peek().height > heights[i]) {
                    Data top = stack.pop();
                    index = top.index;
                    max = Math.max(max, top.height * (i - index));
                }
                Data top = new Data(index, heights[i]);
                stack.push(top);
            }

            while (!stack.isEmpty()) {
                Data top = stack.pop();
                max = Math.max(max, top.height * (heights.length - top.index));
            }

            return max;
        }

        static class Data {
            int index, height;

            public Data(int index, int height) {
                super();
                this.index = index;
                this.height = height;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(10,
        // s.largestRectangleArea(new int[] {2, 1, 5, 6, 2, 3}));
        Assert.assertEquals(3, s.largestRectangleArea(new int[] {1, 2, 1}));
    }

}
