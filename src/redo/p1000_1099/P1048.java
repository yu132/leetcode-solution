package redo.p1000_1099;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1048  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月19日  
 *  
 */
public class P1048 {

    static//

    class Solution {
        public int longestStrChain(String[] words) {

            int n = words.length;

            Arrays.sort(words, (a, b) -> Integer.compare(b.length(), a.length()));

            // System.out.println(Arrays.toString(words));

            int[][] counts = new int[n][];
            int[] hash = new int[n];
            ListMap<Integer, Integer> invertedIndex = new ListMap<>();

            for (int i = 0; i < words.length; ++i) {
                counts[i] = countLowercaseLetters(words[i]);
                hash[i] = hash(words[i].length(), counts[i]);
                invertedIndex.add(hash[i], i);
            }

            int[] dp = new int[n];

            int max = 1;

            for (int i = 0; i < words.length; ++i) {
                for (int j = 0; j < 26; ++j) {
                    for (int nextCandidate : invertedIndex.get(hashGreater(hash[i], j))) {
                        if (next(words[i], words[nextCandidate])) {
                            dp[i] = Math.max(dp[i], dp[nextCandidate] + 1);
                            max = Math.max(max, dp[i] + 1);
                        }
                    }
                }
            }

            return max;
        }

        boolean next(String lower, String higher) {
            int i = 0, j = 0;
            while (i < lower.length() && j < higher.length()) {
                if (lower.charAt(i) == higher.charAt(j)) {
                    ++i;
                    ++j;
                } else {
                    ++j;
                }
            }
            return i == lower.length() && (j == higher.length() || j == higher.length() - 1);
        }

        int hashGreater(int hash, int chIndex) {
            return hash + 1 + 1000 * (chIndex + 1);
        }

        int hash(int len, int[] count) {
            int hash = len;
            for (int i = 0; i < 26; ++i) {
                hash += 1000 * (i + 1) * count[i];
            }
            return hash;
        }

        static class ListMap<K, E> {

            Map<K, List<E>> map = new HashMap<>();

            public void add(K key, E element) {
                map.computeIfAbsent(key, (x) -> new ArrayList<>()).add(element);
            }

            public void remove(K key, E element) {
                map.computeIfAbsent(key, (x) -> new ArrayList<>()).remove(element);
            }

            public List<E> get(K key) {
                return map.getOrDefault(key, Collections.emptyList());
            }

        }

        public int[] countLowercaseLetters(String str) {
            int[] count = new int[26];
            for (char ch : str.toCharArray()) {
                ++count[ch - 'a'];
            }
            return count;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(4, s.longestStrChain(new String[] {"a", "b", "ba", "bca", "bda", "bdca"}));
        // Assert.assertEquals(2, s.longestStrChain(new String[] {"a", "b", "ab", "bac"}));
        Assert.assertEquals(5, s.longestStrChain(new String[] {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}));
    }

}
