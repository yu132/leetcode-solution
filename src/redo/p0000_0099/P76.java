package redo.p0000_0099;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P76  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月18日  
 *  
 */
public class P76 {

    public class Solution {
        /**
         * 
         * @param S string字符串 
         * @param T string字符串 
         * @return string字符串
         */
        public String minWindow(String S, String T) {
            int[] count = new int[128], count2 = new int[128];
            for (char ch : T.toCharArray()) {
                ++count2[ch];
            }
            int acc = 0;
            for (int i = 0; i < 128; ++i) {
                if (count2[i] == 0) {
                    ++acc;
                }
            }

            int minLen = Integer.MAX_VALUE, start = 0;

            for (int left = 0, right = 0; right < S.length(); ++right) {
                char chRight = S.charAt(right);
                ++count[chRight];
                if (count[chRight] == count2[chRight]) {
                    ++acc;
                }
                while (acc == 128 && left <= right) {
                    char chLeft = S.charAt(left);
                    --count[chLeft];
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        start = left;
                    }
                    if (count[chLeft] == count2[chLeft] - 1) {
                        --acc;
                    }
                    ++left;
                }
            }

            if (minLen == Integer.MAX_VALUE) {
                return "";
            }

            return S.substring(start, start + minLen);
        }
    }

    // class Solution {
    // public String minWindow(String s, String t) {
    // Map<Integer, Integer> counter = new HashMap<>();
    //
    // Map<Integer, Integer> counter2 = new HashMap<>();
    //
    // for (char num : t.toCharArray()) {
    // plus1(counter2, num);
    // }
    //
    // int min = Integer.MAX_VALUE, start = 0, greater = 0;
    // for (int left = 0, right = 0; right < s.length(); ++right) {
    // if (counter2.containsKey((int)s.charAt(right))) {
    // plus1(counter, s.charAt(right));
    // if (counter.get((int)s.charAt(right))
    // .equals(counter2.get((int)s.charAt(right)))) {
    // ++greater;
    // }
    // }
    // while (greater == counter2.size()) {
    // int len = right - left + 1;
    // if (len < min) {
    // min = len;
    // start = left;
    // }
    // if (counter2.containsKey((int)s.charAt(left))) {
    // minus1(counter, s.charAt(left));
    // if (counter.getOrDefault((int)s.charAt(left),
    // 0) == counter2.get((int)s.charAt(left)) - 1) {
    // --greater;
    // }
    // }
    // ++left;
    // }
    // }
    //
    // if (min == Integer.MAX_VALUE) {
    // return "";
    // }
    //
    // return s.substring(start, start + min);
    // }
    //
    // public void plus1(Map<Integer, Integer> counter, int val) {
    // counter.put(val, counter.getOrDefault(val, 0) + 1);
    // }
    //
    // public void minus1(Map<Integer, Integer> counter, int val) {
    // counter.put(val, counter.getOrDefault(val, 0) - 1);
    // if (counter.get(val) == 0) {
    // counter.remove(val);
    // }
    // }
    // }

    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("YXNZ", s.minWindow("XDOYEZODEYXNZ", "XYZ"));
    }

}
