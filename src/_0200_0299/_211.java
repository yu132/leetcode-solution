package _0200_0299;

import java.util.HashSet;
import java.util.Set;

/**  
 * @ClassName: _211  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月29日  
 *  
 */
public class _211 {

    class WordDictionary {

        class Node {
            boolean isPrefix = true;
            Node[] next = new Node[26];
        }

        private Node head = new Node();

        private Set<Integer> len = new HashSet<>();

        /** Initialize your data structure here. */
        public WordDictionary() {}

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            len.add(word.length());
            Node node = head;
            for (char ch : word.toCharArray()) {
                if (node.next[ch - 'a'] == null) {
                    node.next[ch - 'a'] = new Node();
                }
                node = node.next[ch - 'a'];
            }
            node.isPrefix = false;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            if (!len.contains(word.length())) {
                return false;
            }
            return find(0, word, head);
        }

        private boolean find(int index, String word, Node node) {
            if (node == null) {
                return false;
            }
            if (index == word.length()) {
                return !node.isPrefix;
            }
            if (word.charAt(index) == '.') {
                for (int i = 0; i < 26; ++i) {
                    if (find(index + 1, word, node.next[i])) {
                        return true;
                    }
                }
                return false;
            } else {
                return find(index + 1, word, node.next[word.charAt(index) - 'a']);
            }
        }
    }

}
