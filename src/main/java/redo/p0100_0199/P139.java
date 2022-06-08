package redo.p0100_0199;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P139  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月24日  
 *  
 */
public class P139 {

    static//

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;

            TrieNode root = toTrie(wordDict);

            for (int i = 0; i < s.length(); ++i) {
                if (dp[i]) {
                    serach(root, i, s, dp);
                }
            }

            return dp[s.length()];
        }

        void serach(TrieNode root, int index, String s, boolean[] dp) {
            TrieNode next;
            for (;
                index < s.length()
                    && (next = root.children[s.charAt(index) - 'a']) != null;
                ++index) {
                root = next;
                if (next.isWord) {
                    dp[index + 1] = true;
                }
            }
        }

        TrieNode toTrie(List<String> wordDict) {
            TrieNode root = new TrieNode();

            for (String str : wordDict) {
                add(root, str);
            }

            return root;
        }

        void add(TrieNode root, String str) {
            for (char ch : str.toCharArray()) {
                if (root.children[ch - 'a'] == null) {
                    root.children[ch - 'a'] = new TrieNode();
                }
                root = root.children[ch - 'a'];
            }
            root.isWord = true;
        }

        static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true,
            s.wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

}
