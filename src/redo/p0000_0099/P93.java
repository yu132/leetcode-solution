package redo.p0000_0099;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: P93  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P93 {

    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> ans = new ArrayList<>();
            backtrack(0, new ArrayList<>(), s, ans);
            return ans;
        }

        void backtrack(int index, List<String> list, String s,
            List<String> ans) {

            if (list.size() >= 5) {
                return;
            }

            if (index == s.length() && list.size() == 4) {
                ans.add(String.join(".", list));
                return;
            }

            int num = 0;
            for (int i = index; i < s.length(); ++i) {
                if (i == index + 1 && num == 0) {
                    return;
                }
                num = num * 10 + s.charAt(i) - '0';
                if (num > 255) {
                    return;
                }
                list.add(String.valueOf(num));
                backtrack(i + 1, list, s, ans);
                list.remove(list.size() - 1);
            }
        }
    }

}
