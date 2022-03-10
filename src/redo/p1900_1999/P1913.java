package redo.p1900_1999;

/**  
 * @ClassName: P1913  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年8月1日  
 *  
 */
public class P1913 {

    class Solution {
        public int maxProductDifference(int[] nums) {
            int max0 = Integer.MIN_VALUE, max1 = Integer.MIN_VALUE,
                min0 = Integer.MAX_VALUE, min1 = Integer.MAX_VALUE;

            for (int num : nums) {
                if (num >= max0) {
                    max1 = max0;
                    max0 = num;
                } else if (num > max1) {
                    max1 = num;
                }

                if (num <= min0) {
                    min1 = min0;
                    min0 = num;
                } else if (num < min1) {
                    min1 = num;
                }
            }

            return max1 * max0 - min1 * min0;
        }
    }

}
