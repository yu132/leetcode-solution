package redo.p1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1239  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P1239 {

    class Solution {

        int max = 0;

        public int maxLength(List<String> arr) {
            List<String> notSameChar = new ArrayList<>();
            for (Iterator<String> it = arr.iterator(); it.hasNext();) {
                String str = it.next();
                int[] count = countLowercaseLetters(str);
                boolean flag = true;
                for (int num : count) {
                    if (num >= 2) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    notSameChar.add(str);
                }
            }
            backtrack(0, 0, new boolean[26], notSameChar);
            return max;
        }

        void backtrack(int index, int maxLen, boolean[] used, List<String> arr) {
            if (index == arr.size()) {
                max = Math.max(max, maxLen);
                return;
            }
            boolean canChoose = true;
            char[] chs = arr.get(index).toCharArray();
            for (char ch : chs) {
                if (used[ch - 'a']) {
                    canChoose = false;
                    break;
                }
            }
            if (canChoose) {
                for (char ch : chs) {
                    used[ch - 'a'] = true;
                }
                backtrack(index + 1, maxLen + chs.length, used, arr);
                for (char ch : chs) {
                    used[ch - 'a'] = false;
                }
            }
            backtrack(index + 1, maxLen, used, arr);
        }

        public int[] countLowercaseLetters(String str) {
            int[] chs = new int[26];
            for (char ch : str.toCharArray()) {
                ++chs[ch - 'a'];
            }
            return chs;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(4, s.maxLength(Arrays.asList("un", "iq", "ue")));
        Assert.assertEquals(4, s.maxLength(Arrays.asList("aaaaaaaa", "iq", "ue")));
        Assert.assertEquals(6, s.maxLength(Arrays.asList("cha", "r", "act", "ers")));
        Assert.assertEquals(26, s.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
    }
}
