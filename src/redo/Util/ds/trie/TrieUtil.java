package redo.Util.ds.trie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

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
