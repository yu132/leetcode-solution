package redo.offer2.p17;

import java.util.Arrays;

/**  
 * @ClassName: P17_08  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月16日  
 *  
 */
public class P17_08 {

    static//

    class Solution {
        public int bestSeqAtIndex(int[] height, int[] weight) {

            int n = height.length;

            People[] peoples = new People[n];

            for (int i = 0; i < n; ++i) {
                peoples[i] = new People(height[i], weight[i]);
            }

            Arrays.sort(peoples, (a, b) -> {
                if (a.height == b.height) {
                    return Integer.compare(b.weight, a.weight);
                } else if (a.height < b.height) {
                    return -1;
                } else {
                    return 1;
                }
            });

            int[] stack = new int[n];
            int top = 0;

            for (int i = 0; i < n; ++i) {
                if (top == 0 || stack[top - 1] < peoples[i].weight) {
                    stack[top++] = peoples[i].weight;
                } else {
                    stack[lowerBound(stack, 0, top, peoples[i].weight)] =
                        peoples[i].weight;
                }
            }

            return top;
        }

        int lowerBound(int[] stack, int low, int high, int target) {
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (target <= stack[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        static class People {
            int height;
            int weight;

            public People(int height, int weight) {
                super();
                this.height = height;
                this.weight = weight;
            }
        }
    }

}
