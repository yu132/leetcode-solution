package redo.contest.t233;

/**  
 * @ClassName: P5711  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月21日  
 *  
 */
public class P5711 {

    class Solution {
        public int maxValue(int n, int index, int maxSum) {
            int left = index + 1, right = n - index;

            int low = 0, high = maxSum + 1;

            while (low < high) {
                int mid = (low + high) >>> 1;
                long sum = cul(left, mid) + cul(right, mid) - mid;
                if (sum > maxSum) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return low - 1;
        }

        long cul(int range, int maxVal) {
            if (range > maxVal) {
                return (long)(1 + maxVal) * maxVal / 2 + (range - maxVal);
            } else {
                return (((long)maxVal - range + 1) + maxVal) * range / 2;
            }
        }
    }

}
