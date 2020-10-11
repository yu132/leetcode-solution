package lcof;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: M46  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年2月21日  
 *  
 */
public class M46 {

    class Solution {
        public int translateNum(int num) {

            if (num == 0) {
                return 1;
            }

            List<Integer> list = new ArrayList<>();

            while (num != 0) {
                list.add(num % 10);
                num /= 10;
            }

            Collections.reverse(list);

            int[] dp = new int[list.size() + 1];

            dp[0] = 1;
            dp[1] = 1;

            for (int i = 1; i < list.size(); ++i) {
                if (list.get(i - 1) != 0 && list.get(i - 1) * 10 + list.get(i) < 26) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                } else {
                    dp[i + 1] = dp[i];
                }
            }

            return dp[list.size()];
        }
    }

}
