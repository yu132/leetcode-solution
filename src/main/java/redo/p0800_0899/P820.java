package redo.p0800_0899;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P820  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月30日  
 *  
 */
public class P820 {

    static//

    class Solution {
        public int minimumLengthEncoding(String[] words) {
            UniqueTrie trie = new UniqueTrie();
            trie.addAllReverse(words);
            return dfs(trie.root, 1);
        }

        int dfs(TrieNode node, int len) {
            if (node.children.size() == 0) {
                return len;
            }
            int count = 0;
            for (TrieNode child : node.children.values()) {
                count += dfs(child, len + 1);
            }
            return count;
        }

        static class UniqueTrie {

            TrieNode root = new TrieNode('\0');

            Set<String> contains = new HashSet<>(30);

            public void addReverse(String str) {
                if (contains.contains(str)) {
                    return;
                }
                TrieNode node = root;

                for (int i = str.length() - 1; i >= 0; --i) {
                    char ch = str.charAt(i);
                    node.children.putIfAbsent(ch, new TrieNode(ch));
                    node = node.children.get(ch);
                }
                node.isWord = true;
            }

            public void addAllReverse(String[] strs) {
                for (String str : strs) {
                    addReverse(str);
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



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(10,
            s.minimumLengthEncoding(new String[] {"time", "me", "bell"}));
    }
}
