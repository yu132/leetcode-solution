package redo.p2700_2799;

import java.util.Arrays;

public class P2707 {

    class Solution {
        public int minExtraChar(String s, String[] dictionary) {
            SimpleTire tire = new SimpleTire();
            for (String str : dictionary) {
                tire.addRev(str);
            }
            int[] dp = new int[s.length() + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= s.length(); ++i) {
                SimpleTire.SimpleTrieNode node = tire.root;
                for (int j = i - 1; j >= 0; --j) {
                    node = node.children[s.charAt(j) - 'a'];
                    if (null == node) {
                        break;
                    }
                    if (node.isWord) {
                        dp[i] = Math.min(dp[i], dp[j]);
                    }
                }
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            }
            return dp[s.length()];
        }

        class SimpleTire {

            SimpleTrieNode root = new SimpleTrieNode('\0');

            public boolean addRev(String str) {
                SimpleTrieNode node = root;
                char[] chs = str.toCharArray();
                for (int i = chs.length - 1; i >= 0; --i) {
                    char ch = chs[i];
                    if (node.children[ch - 'a'] == null) {
                        node.children[ch - 'a'] = new SimpleTrieNode(ch);
                    }
                    node = node.children[ch - 'a'];
                }
                boolean added = node.isWord;
                node.isWord = true;
                return added;
            }

            public boolean contains(String str) {
                SimpleTrieNode node = root;
                for (char ch : str.toCharArray()) {
                    if (node.children[ch - 'a'] == null) {
                        return false;
                    }
                    node = node.children[ch - 'a'];
                }
                return node.isWord;
            }

            class SimpleTrieNode {
                char ch;
                boolean isWord;
                SimpleTrieNode[] children = new SimpleTrieNode[26];

                public SimpleTrieNode(char ch) {
                    this.ch = ch;
                }
            }
        }
    }

}
