package _1200_1299;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: _1276  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月10日  
 *  
 */
public class _1276 {

    class Solution {
        public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
            if ((tomatoSlices & 1) == 1) {
                return Collections.emptyList();
            }

            tomatoSlices >>= 1;

            if (tomatoSlices < cheeseSlices || tomatoSlices > cheeseSlices * 2) {
                return Collections.emptyList();
            }

            List<Integer> ans = new ArrayList<>();
            int           dif = tomatoSlices - cheeseSlices;
            ans.add(dif);
            ans.add(cheeseSlices - dif);
            return ans;
        }
    }

}
