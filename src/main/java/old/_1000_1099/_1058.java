package old._1000_1099;

import java.util.ArrayList;
import java.util.Collections;

/**  
 * @ClassName: _1058  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月14日  
 *  
 */
public class _1058 {

    class Solution {
        public String minimizeError(String[] prices, int target) {

            ArrayList<Double> small = new ArrayList<>();

            int               sum   = 0;
            for (int i = 0; i < prices.length; ++i) {
                double d = Double.valueOf(prices[i]);
                sum += (int)d;
                double temp = d - (int)d;
                if (!(Double.compare(temp, 0) == 0)) {
                    small.add(temp);
                }
            }

            if (target < sum || target > sum + small.size()) {
                return "-1";
            }

            Collections.sort(small);

            double ans = 0;
            int    i   = 0;
            for (; i < small.size() - (target - sum); ++i) {
                ans += small.get(i);
            }
            for (; i < small.size(); ++i) {
                ans += 1 - small.get(i);
            }

            return String.format("%.3f", ans);
        }
    }

}
