package redo.offer2.p17;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import redo.offer2.p17.P17_13.Solution.TrieNode;

/**  
 * @ClassName: P17_13  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月16日  
 *  
 */
public class P17_13 {

    static//

    class Solution {
        public int respace(String[] dictionary, String sentence) {

            int n = sentence.length();

            TrieNode root = new TrieNode('\0');
            for (String str : dictionary) {
                add(root, str);
            }
            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; ++i) {
                dp[i] = dp[i - 1] + 1;
                TrieNode node = root;
                for (int j = i - 1; j >= 0; --j) {
                    char ch = sentence.charAt(j);

                    TrieNode next = node.children[ch - 'a'];

                    if (next == null) {
                        break;
                    } else if (next.isWord) {
                        dp[i] = Math.min(dp[i], dp[j]);
                    }

                    if (dp[i] == 0) {
                        break;
                    }

                    node = next;
                }
            }

            return dp[n];
        }

        void add(TrieNode root, String str) {
            for (int i = str.length() - 1; i >= 0; --i) {
                char ch = str.charAt(i);
                if (root.children[ch - 'a'] == null) {
                    root.children[ch - 'a'] = new TrieNode(ch);
                }
                root = root.children[ch - 'a'];
            }
            root.isWord = true;
        }

        static class TrieNode {
            char ch;
            TrieNode[] children;
            boolean isWord;

            public TrieNode(char ch) {
                super();
                this.ch = ch;
                this.children = new TrieNode[26];
                isWord = false;
            }
        }
    }

    // class Solution {
    //
    // int[] dp;
    //
    // public int respace(String[] dictionary, String sentence) {
    // dp = new int[sentence.length() + 1];
    // Arrays.fill(dp, -1);
    // Set<String> dic = new HashSet<>();
    // for (String str : dictionary) {
    // dic.add(str);
    // }
    // return dp(0, sentence, dic);
    // }
    //
    // int dp(int index, String sen, Set<String> dic) {
    // if (index == sen.length()) {
    // return 0;
    // }
    // if (dp[index] == -1) {
    // int min = Integer.MAX_VALUE;
    // for (int i = 1; i <= sen.length() - index; ++i) {
    // int after = dp(index + i, sen, dic);
    // int now =
    // dic.contains(sen.substring(index, index + i)) ? 0 : i;
    // min = Math.min(min, now + after);
    // }
    // dp[index] = min;
    // }
    // return dp[index];
    // }
    // }

}
