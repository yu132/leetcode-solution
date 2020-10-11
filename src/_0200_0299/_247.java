package _0200_0299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: _247  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月6日  
 *  
 */
public class _247 {

    class Solution {
        public List<String> findStrobogrammatic(int n) {
            if (n == 1) {
                return Arrays.asList("0", "1", "8");
            } else if (n == 2) {
                return Arrays.asList("11", "69", "88", "96");
            }

            List<String> l  = helper(n - 2);

            List<String> l2 = new ArrayList<>();

            for (String each : l) {
                l2.add("1" + each + "1");
                l2.add("8" + each + "8");
                l2.add("6" + each + "9");
                l2.add("9" + each + "6");
            }

            return l2;
        }

        public List<String> helper(int n) {
            if (n == 1) {
                return Arrays.asList("0", "1", "8");
            } else if (n == 2) {
                return Arrays.asList("00", "11", "69", "88", "96");
            }

            List<String> l  = helper(n - 2);

            List<String> l2 = new ArrayList<>();

            for (String each : l) {
                l2.add("1" + each + "1");
                l2.add("8" + each + "8");
                l2.add("6" + each + "9");
                l2.add("9" + each + "6");
                l2.add("0" + each + "0");
            }

            return l2;
        }
    }

}
