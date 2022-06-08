package redo.p1700_1799;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: P1742  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P1742 {

    class Solution {
        public int countBalls(int lowLimit, int highLimit) {
            Map<Integer, Integer> counter = new HashMap<>();

            int max = 0;

            for (int i = lowLimit; i <= highLimit; ++i) {
                int sumDigits = sumDigits(i);
                int num = counter.getOrDefault(sumDigits, 0) + 1;
                max = Math.max(max, num);
                counter.put(sumDigits, num);
            }

            return max;
        }

        int sumDigits(int num) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            return sum;
        }
    }

}
