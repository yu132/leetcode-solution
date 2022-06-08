package redo.p0200_0299;

/**  
 * @ClassName: P208  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月25日  
 *  
 */
public class P208 {

    static//

    class Trie {

        TrieNode root = new TrieNode();

        /** Initialize your data structure here. */
        public Trie() {}

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }

        TrieNode find(String str) {
            TrieNode node = root;
            for (char ch : str.toCharArray()) {
                if (node.children[ch - 'a'] == null) {
                    return null;
                }
                node = node.children[ch - 'a'];
            }
            return node;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = find(word);
            if (node == null) {
                return false;
            }
            return node.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return find(prefix) != null;
        }

        static class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isWord = false;
        }
    }

}
