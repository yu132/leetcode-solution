package redo.p0200_0299;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**  
 * @ClassName: P211  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P211 {

    static//

    class WordDictionary {

        UniqueTrie trie = new UniqueTrie();

        /** Initialize your data structure here. */
        public WordDictionary() {}

        public void addWord(String word) {
            trie.add(word);
        }

        public boolean search(String word) {
            return helper(0, trie.root, word);
        }

        boolean helper(int index, TrieNode node, String word) {
            if (index == word.length()) {
                return node.isWord;
            }
            if (word.charAt(index) == '.') {
                for (TrieNode child : node.children.values()) {
                    if (helper(index + 1, child, word)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!node.children.containsKey(word.charAt(index))) {
                    return false;
                }
                return helper(index + 1, node.children.get(word.charAt(index)),
                    word);
            }
        }

        static class UniqueTrie {

            TrieNode root = new TrieNode('\0');

            Set<String> contains = new HashSet<>();

            public void add(String str) {
                if (contains.contains(str)) {
                    return;
                }
                TrieNode node = root;
                for (char ch : str.toCharArray()) {
                    node.children.putIfAbsent(ch, new TrieNode(ch));
                    node = node.children.get(ch);
                }
                node.isWord = true;
            }

            public void addAll(List<String> strs) {
                for (String str : strs) {
                    add(str);
                }
            }

        }

        static class TrieNode {
            char ch;
            boolean isWord = false;
            TreeMap<Character, TrieNode> children = new TreeMap<>();

            public TrieNode(char ch) {
                super();
                this.ch = ch;
            }
        }
    }

}
