package redo.offer2.p17;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P17_15  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月18日  
 *  
 */
public class P17_15 {

    class Solution {
        public String longestWord(String[] words) {

            if (words == null || words.length == 0) {
                return "";
            }

            Set<String> set = new HashSet<>();
            Arrays.sort(words,
                (a, b) -> Integer.compare(a.length(), b.length()));

            int minLen = words[0].length(), maxLen = minLen;

            String ans = "";

            for (String word : words) {

                int index = 0;

                if (backtrack(index, word, minLen, maxLen, set)) {
                    if (word.length() > ans.length()
                        || (word.length() == ans.length()
                            && word.compareTo(ans) < 0)) {
                        ans = word;
                    }
                }

                minLen = Math.min(minLen, word.length());
                maxLen = Math.max(maxLen, word.length());

                set.add(word);
            }
            return ans;
        }

        boolean backtrack(int index, String word, int low, int high,
            Set<String> set) {
            if (index == word.length()) {
                return true;
            }

            for (int i = low; i <= high && index + i <= word.length(); ++i) {
                if (set.contains(word.substring(index, index + i))) {
                    if (backtrack(index + i, word, low, high, set)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("dogwalker", s.longestWord(new String[] {"cat",
            "banana", "dog", "nana", "walk", "walker", "dogwalker"}));
    }

}
