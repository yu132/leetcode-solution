package _0600_0699;

import java.util.List;

/**  
 * @ClassName: _624  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月27日  
 *  
 */
public class _624 {

    class Solution {
        public int maxDistance(List<List<Integer>> arrays) {

            int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1), res = Integer.MIN_VALUE;

            for (int i = 1; i < arrays.size(); ++i) {
                int low = arrays.get(i).get(0), high = arrays.get(i).get(arrays.get(i).size() - 1);
                res = Math.max(res, max - low);
                res = Math.max(res, high - min);
                min = Math.min(min, low);
                max = Math.max(max, high);
            }

            return res;
        }
    }

}
