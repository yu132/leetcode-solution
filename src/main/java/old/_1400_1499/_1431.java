package old._1400_1499;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _1431  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月16日  
 *  
 */
public class _1431 {

    class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int max = 0;
            for (int i = 0; i < candies.length; ++i) {
                max = Math.max(max, candies[i]);
            }
            List<Boolean> ans = new ArrayList<>();
            for (int i = 0; i < candies.length; ++i) {
                ans.add(candies[i] + extraCandies >= max);
            }
            return ans;
        }
    }

}
