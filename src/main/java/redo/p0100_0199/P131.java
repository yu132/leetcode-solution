package redo.p0100_0199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P131  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月13日  
 *  
 */
public class P131 {

    class Solution {
        public List<List<String>> partition(String s) {
            return backtrack(0, s);
        }

        List<List<String>> backtrack(int index, String s) {
            if (index == s.length()) {
                return Arrays.asList(Arrays.asList());
            }

            List<List<String>> ans = new ArrayList<>();

            for (int i = index + 1; i <= s.length(); ++i) {
                if (isParr(s, index, i)) {
                    for (List<String> l : backtrack(i, s)) {
                        List<String> ll = new ArrayList<>();
                        ll.add(s.substring(index, i));
                        ll.addAll(l);
                        ans.add(ll);
                    }
                }
            }

            return ans;
        }

        boolean isParr(String str, int low, int high) {
            --high;
            while (low < high) {
                if (str.charAt(low) != str.charAt(high)) {
                    return false;
                }
                ++low;
                --high;
            }
            return true;
        }
    }


}
