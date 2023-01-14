package old._0000_0099;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _93  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月20日  
 *  
 */
public class _93 {

    class Solution {
        public List<String> restoreIpAddresses(String s) {

            List<String> ans = new ArrayList<>();

            for (int i = 1; i < 4; ++i) {
                if (i >= s.length()) {
                    break;
                }

                String str1 = s.substring(0, i);

                if (!isVaild(str1)) {
                    continue;
                }

                for (int j = i + 1; j < i + 4; ++j) {
                    if (j >= s.length()) {
                        break;
                    }

                    String str2 = s.substring(i, j);

                    if (!isVaild(str2)) {
                        continue;
                    }

                    for (int k = j + 1; k < j + 4; ++k) {
                        if (k >= s.length()) {
                            break;
                        }

                        if (s.length() - k > 3) {
                            continue;
                        }

                        String str3 = s.substring(j, k);

                        if (!isVaild(str3)) {
                            continue;
                        }

                        String str4 = s.substring(k);

                        if (!isVaild(str4)) {
                            continue;
                        }

                        ans.add(str1 + "." + str2 + "." + str3 + "." + str4);
                    }
                }
            }

            return ans;
        }

        private boolean isVaild(String str) {
            if (str.length() != 1 && str.charAt(0) == '0') {
                return false;
            }
            return Integer.valueOf(str) <= 255;
        }
    }

}
