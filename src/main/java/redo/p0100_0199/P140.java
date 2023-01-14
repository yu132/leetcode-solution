package redo.p0100_0199;

import java.util.ArrayList;
import java.util.List;

public class P140 {

    class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            SimpleTire tire = new SimpleTire();
            for (String str : wordDict) {
                tire.add(str);
            }
            List<String> ans = new ArrayList<>();
            backtrack(0, s, new StringBuilder(s.length() + wordDict.size()), tire.root, ans, tire.root);
            return ans;
        }

        void backtrack(int index, String s, StringBuilder buf, SimpleTrieNode node, List<String> ans, SimpleTrieNode root) {

            if (index == s.length()) {
                if (!node.isWord) {
                    return;
                }
                ans.add(buf.toString());
                return;
            }

            SimpleTrieNode child = node.children[s.charAt(index) - 'a'];

            if (child == null) {
                return;
            }

            buf.append(child.ch);
            backtrack(index + 1, s, buf, child, ans, root);
            if (child.isWord) {
                buf.append(' ');
                backtrack(index + 1, s, buf, root, ans, root);
                buf.deleteCharAt(buf.length() - 1);
            }
            buf.deleteCharAt(buf.length() - 1);
        }

        class SimpleTire {

            SimpleTrieNode root = new SimpleTrieNode('\0');

            public boolean add(String str) {
                SimpleTrieNode node = root;
                for (char ch : str.toCharArray()) {
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
