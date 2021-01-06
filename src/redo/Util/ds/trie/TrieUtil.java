package redo.Util.ds.trie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**  
 * @ClassName: TrieUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class TrieUtil {

    static class UniqueTrie {

        TrieNode head;

        Set<String> contains = new HashSet<>();

        public void add(String str) {
            if (contains.contains(str)) {
                return;
            }
            TrieNode node = head;
            for (char ch : str.toCharArray()) {
                node.children.putIfAbsent(ch, new TrieNode(ch));
                node = node.children.get(ch);
            }
            node.isWord = true;
        }

    }

    static class TrieNode {
        char ch;
        boolean isWord = false;
        Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode(char ch) {
            super();
            this.ch = ch;
        }
    }

}
