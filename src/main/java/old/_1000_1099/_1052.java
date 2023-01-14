package old._1000_1099;

/**  
 * @ClassName: _1052  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月9日  
 *  
 */
public class _1052 {

    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {

            int happy = 0, low = 0, high = X, max = 0;

            for (int i = 0; i < customers.length; ++i) {
                if (grumpy[i] == 0) {
                    happy += customers[i];
                }
            }

            for (int i = 0; i < X; ++i) {
                if (grumpy[i] == 1) {
                    happy += customers[i];
                }
            }

            max = Math.max(max, happy);

            while (high < customers.length) {
                if (grumpy[low] == 1) {
                    happy -= customers[low];
                }
                if (grumpy[high] == 1) {
                    happy += customers[high];
                }
                ++low;
                ++high;
                max = Math.max(max, happy);
            }

            return max;
        }
    }

}
