package redo.p0000_0099;

import java.util.Deque;
import java.util.LinkedList;

import redo.p0000_0099.P84.Solution.Data;

/**  
 * @ClassName: P85  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P85 {

    static//

    class Solution {
        public int maximalRectangle(char[][] matrix) {

            if (matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }

            int m = matrix.length, n = matrix[0].length;

            int[][] pre = new int[n][m];

            for (int i = 0; i < m; ++i) {
                if (matrix[i][0] == '1') {
                    pre[0][i] = 1;
                }
            }

            for (int j = 1; j < n; ++j) {
                for (int i = 0; i < m; ++i) {
                    if (matrix[i][j] == '1') {
                        pre[j][i] = pre[j - 1][i] + 1;
                    }
                }
            }

            int max = 0;

            for (int j = 0; j < n; ++j) {
                max = Math.max(max, largestRectangleArea(pre[j]));
            }

            return max;
        }

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

}
