package _1400_1499;

/**  
 * @ClassName: _1491  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年7月28日  
 *  
 */
public class _1491 {

    class Solution {
        public double average(int[] salary) {
            int max = salary[0], min = salary[0], sum = salary[0];

            for (int i = 1; i < salary.length; ++i) {
                max  = Math.max(max, salary[i]);
                min  = Math.min(min, salary[i]);
                sum += salary[i];
            }

            return (double)(sum - max - min) / (salary.length - 2);
        }
    }

}
