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

    /**
     * 模糊搜索字典树，允许有几个位置不同，且所有单词的长度均相同，没有长度上的差异
     *
     * @param tree       树
     * @param str        待匹配的字符串
     * @param fuzzyCount 允许有几个地方不同
     * @return
     */
    public boolean containsWithFizz(SimpleTire tree, String str, int fuzzyCount) {
        return containsWithFizz(str, 0, tree.root, fuzzyCount);
    }

    public boolean containsWithFizz(String str, int index, SimpleTire.SimpleTrieNode node, int fuzzyCount) {
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
