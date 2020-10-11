package _0200_0299;

/**  
 * @ClassName: _208  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月29日  
 *  
 */
public class _208 {

    class Trie {

        class Node {
            char now;
            boolean isPrefix = true;
            Node[] next = new Node[26];

            public Node(char now) {
                super();
                this.now = now;
            }
        }

        private Node head = new Node(' ');

        /** Initialize your data structure here. */
        public Trie() {}

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node node = head;
            for (char ch : word.toCharArray()) {
                if (node.next[ch - 'a'] == null) {
                    node.next[ch - 'a'] = new Node(ch);
                }
                node = node.next[ch - 'a'];
            }
            node.isPrefix = false;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node node = head;
            for (char ch : word.toCharArray()) {
                if (node.next[ch - 'a'] == null) {
                    return false;
                }
                node = node.next[ch - 'a'];
            }
            return !node.isPrefix;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node node = head;
            for (char ch : prefix.toCharArray()) {
                if (node.next[ch - 'a'] == null) {
                    return false;
                }
                node = node.next[ch - 'a'];
            }
            return true;
        }
    }

}
