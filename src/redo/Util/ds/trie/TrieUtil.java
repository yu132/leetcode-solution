package redo.Util.ds.trie;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author 余定邦
 * @ClassName: TrieUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2021年1月2日
 */
public class TrieUtil {

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
    }

    class SimpleTrieNode {
        char ch;
        boolean isWord;
        SimpleTrieNode[] children = new SimpleTrieNode[26];

        public SimpleTrieNode(char ch) {
            this.ch = ch;
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
