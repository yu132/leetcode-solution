package redo.p0100_0199;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: P179  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P179 {

    static//

    class Solution {
        public String largestNumber(int[] nums) {
            List<String> list = toStringList(nums);

            Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));

            String ans = String.join("", list);

            if (ans.startsWith("0")) {
                return "0";
            }

            return ans;
        }

        public static List<String> toStringList(int[] nums) {
            List<String> ans = new ArrayList<>(nums.length);
            for (int num : nums) {
                ans.add(String.valueOf(num));
            }
            return ans;
        }
    }

}
