package old._1100_1199;

/**  
 * @ClassName: _1176  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月31日  
 *  
 */
public class _1176 {

    class Solution {
        public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

            int sum = 0, index = 0, point = 0;

            for (int i = 0; i < k; ++i) {
                sum += calories[i];
            }

            if (sum < lower) {
                --point;
            } else if (sum > upper) {
                ++point;
            }

            while (index + k < calories.length) {
                sum -= calories[index];
                sum += calories[index + k];
                ++index;
                if (sum < lower) {
                    --point;
                } else if (sum > upper) {
                    ++point;
                }
            }

            return point;
        }
    }

}
