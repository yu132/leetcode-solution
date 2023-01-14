package redo.p2400_2499;

import java.util.ArrayList;
import java.util.List;

public class P2452 {

    class Solution {
        public List<String> twoEditWords(String[] queries, String[] dictionary) {
            SimpleTire simpleTire = new SimpleTire();
            for (String str : dictionary) {
                simpleTire.add(str);
            }
            List<String> ans = new ArrayList<>();
            for (String query : queries) {
                if (simpleTire.containsWithFizz(query, 2)) {
                    ans.add(query);
                }
            }
            return ans;
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

            public boolean containsWithFizz(String str, int fuzzyCount) {
                return containsWithFizz(str, 0, root, fuzzyCount);
            }

            public boolean containsWithFizz(String str, int index, SimpleTrieNode node, int fuzzyCount) {
                if (null == node) {
                    return false;
                }
                if (index == str.length()) {
                    return node.isWord;
                }
                if (node.children[str.charAt(index) - 'a'] != null
                        && containsWithFizz(str, index + 1, node.children[str.charAt(index) - 'a'], fuzzyCount)) {
                    return true;
                }
                if (fuzzyCount > 0) {
                    for (int i = 0; i < 26; ++i) {
                        if (containsWithFizz(str, index + 1, node.children[i], fuzzyCount - 1)) {
                            return true;
                        }
                    }
                }
                return false;
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
