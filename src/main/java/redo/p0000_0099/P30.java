package redo.p0000_0099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P30  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月11日  
 *  
 */
public class P30 {

    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {

            if (words == null) {
                return Collections.emptyList();
            }

            if (s.length() < words.length * words[0].length()) {
                return Collections.emptyList();
            }

            int[] checkCounter = new int[26];

            Map<String, Integer> checkCounterMap = new HashMap<>();

            int m = words.length, n = words[0].length();

            for (String str : words) {
                for (char ch : str.toCharArray()) {
                    ++checkCounter[ch - 'a'];
                }
                plus1(checkCounterMap, str);
            }

            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < n; ++i) {

                int[] counter = new int[26];
                Map<String, Integer> counterMap = new HashMap<>();

                int j = 0;
                if (i + n * m > s.length()) {
                    break;
                }
                for (; j < m; ++j) {
                    int start = n * j + i;
                    for (int k = 0; k < n; ++k) {
                        ++counter[s.charAt(start + k) - 'a'];
                    }
                    plus1(counterMap, s.substring(start, start + n));
                }

                if (Arrays.equals(checkCounter, counter)
                    && mapEquals(checkCounterMap, counterMap)) {
                    ans.add(i);
                }

                int ss = i + n;

                for (; ss + m * n <= s.length(); ss += n, ++j) {

                    int start = n * j + i;
                    for (int k = 0; k < n; ++k) {
                        ++counter[s.charAt(start + k) - 'a'];
                        --counter[s.charAt(ss - n + k) - 'a'];
                    }
                    plus1(counterMap, s.substring(start, start + n));
                    minus1(counterMap, s.substring(ss - n, ss));

                    if (Arrays.equals(checkCounter, counter)
                        && mapEquals(checkCounterMap, counterMap)) {
                        ans.add(ss);
                    }
                }
            }

            return ans;
        }

        boolean mapEquals(Map<String, Integer> checkCounterMap,
            Map<String, Integer> counterMap) {

            for (Map.Entry<String, Integer> entry : checkCounterMap
                .entrySet()) {
                if (counterMap.getOrDefault(entry.getKey(), 0)
                    .intValue() != entry.getValue().intValue()) {
                    return false;
                }
            }

            return true;
        }

        void plus1(Map<String, Integer> checkCounterMap, String str) {
            checkCounterMap.put(str, 1 + checkCounterMap.getOrDefault(str, 0));
        }

        void minus1(Map<String, Integer> checkCounterMap, String str) {
            checkCounterMap.put(str, -1 + checkCounterMap.getOrDefault(str, 0));
        }

    }


    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(Arrays.asList(0, 9),
        // s.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}));

        Assert.assertEquals(Arrays.asList(8),
            s.findSubstring("wordgoodgoodgoodbestword",
                new String[] {"word", "good", "best", "good"}));

    }

}
