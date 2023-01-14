package old._1400_1499;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _1441  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月20日  
 *  
 */
public class _1441 {

    class Solution {
        public List<String> buildArray(int[] target, int n) {
            List<String> ans = new ArrayList<>();
            for (int i = 0, v = 1; i < target.length; ++i) {
                while (target[i] > v) {
                    ans.add("Push");
                    ans.add("Pop");
                    ++v;
                }
                ans.add("Push");
                ++v;
            }
            return ans;
        }
    }

}
