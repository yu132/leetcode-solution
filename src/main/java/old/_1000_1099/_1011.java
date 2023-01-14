package old._1000_1099;

/**  
 * @ClassName: _1011  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月8日  
 *  
 */
public class _1011 {

    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            int low = 1, high = Math.max(50000 * 600 / D, 500);

            while (low < high) {
                int     mid  = (low + high) >>> 1;

                boolean flag = true;

                int     day  = 1, weightNow = 0;
                for (int i = 0; i < weights.length; ++i) {
                    if (weights[i] > mid) {
                        flag = false;
                        break;
                    }
                    weightNow += weights[i];
                    if (weightNow > mid) {
                        weightNow = weights[i];
                        ++day;
                        if (day > D) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (flag) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return low;
        }
    }

    public static void main(String[] args) {
        System.out.println(new _1011().new Solution().shipWithinDays(new int[] {1, 2, 3, 1, 1}, 4));
    }
}
