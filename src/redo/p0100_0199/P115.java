package redo.p0100_0199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P115  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P115 {

    class Solution {
        public int numDistinct(String s, String t) {
            int[] dp = new int[t.length() + 1];
            dp[0] = 1;

            @SuppressWarnings("unchecked")
            List<Integer>[] list = new List[128];

            Arrays.setAll(list, (x) -> new ArrayList<>());

            for (int i = t.length() - 1; i >= 0; --i) {
                list[t.charAt(i)].add(i + 1);
            }

            for (char ch : s.toCharArray()) {
                for (int i : list[ch]) {
                    dp[i] += dp[i - 1];
                }
            }

            return dp[t.length()];
        }
    }

}
