package _0200_0299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**  
 * @ClassName: _267  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月9日  
 *  
 */
public class _267 {

    class Solution {
        public List<String> generatePalindromes(String s) {
            if (s.length() == 1) {
                List<String> ans = new ArrayList<>();
                ans.add(s);
                return ans;
            }
            int[] count = new int[256];
            for (char each : s.toCharArray()) {
                ++count[each];
            }
            char[]  c     = new char[s.length() / 2];
            int     index = 0;
            char    mid   = ' ';
            boolean odd   = false;
            for (int i = 0; i < count.length; ++i) {
                if ((count[i] & 1) == 1) {
                    if (odd) {
                        return Collections.emptyList();
                    } else {
                        odd = true;
                        mid = (char)i;
                    }
                }
                for (int j = 0; j < count[i] / 2; ++j) {
                    c[index++] = (char)i;
                }
            }
            List<List<Character>> temp = uniqueAllPermutation(c);
            List<String>          ans  = new ArrayList<>();
            for (List<Character> each : temp) {
                StringBuilder sb = new StringBuilder(each.size() * 2 + 1);
                for (int i = 0; i < each.size(); ++i) {
                    sb.append(each.get(i));
                }
                if (odd) {
                    sb.append(mid);
                }
                for (int i = each.size() - 1; i >= 0; --i) {
                    sb.append(each.get(i));
                }
                ans.add(sb.toString());
            }
            return ans;
        }

        public List<List<Character>> uniqueAllPermutation(char[] nums) {
            List<List<Character>> ans = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return ans;
            }
            Arrays.sort(nums);
            helper(ans, new ArrayList<>(), nums, new boolean[nums.length]);
            return ans;
        }

        private void helper(List<List<Character>> ans, List<Character> now, char[] nums, boolean[] used) {
            if (now.size() == nums.length) {
                ans.add(new ArrayList<>(now));
            } else {
                long lastUsed = Long.MAX_VALUE;
                for (int i = 0; i < nums.length; ++i) {
                    if (!used[i] && nums[i] != lastUsed) {
                        used[i] = true;
                        now.add(nums[i]);
                        helper(ans, now, nums, used);
                        lastUsed = nums[i];
                        used[i]  = false;
                        now.remove(now.size() - 1);
                    }
                }
            }
        }
    }
}
