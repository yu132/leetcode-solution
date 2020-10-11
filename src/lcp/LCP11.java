package lcp;

import java.util.HashSet;

/**  
 * @ClassName: LCP11  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月20日  
 *  
 */
public class LCP11 {

    class Solution {
        public int expectNumber(int[] scores) {
            HashSet<Integer> set = new HashSet<>(scores.length);
            for (int score : scores) {
                set.add(score);
            }
            return set.size();
        }
    }

}
