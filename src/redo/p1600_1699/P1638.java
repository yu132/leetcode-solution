package redo.p1600_1699;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1638  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月2日  
 *  
 */
public class P1638 {

    static//

    class Solution {
        public int countSubstrings(String s, String t) {

            CountTrie trie = new CountTrie();

            for (int i = 0; i < t.length(); ++i) {
                trie.add(t.substring(i));
            }

            Map<String, Integer> same = new HashMap<>();

            int count = 0;

            for (int len = 1; len <= s.length(); ++len) {
                for (int i = 0; i <= s.length() - len; ++i) {
                    String sub = s.substring(i, i + len);
                    if (same.containsKey(sub)) {
                        count += same.get(sub);
                        continue;
                    }
                    int temp = findDiff(trie.head, sub, 0);
                    same.put(sub, temp);
                    count += temp;
                }
            }

            return count;
        }

        static int findDiff(TrieNode node, String str, int index) {
            if (str.length() == index) {
                return 0;
            }
            int count = 0;
            for (TrieNode child : node.children.values()) {
                if (child.ch != str.charAt(index)) {
                    count += findSame(child, str, index + 1);
                } else {
                    count += findDiff(child, str, index + 1);
                }
            }
            return count;
        }

        static int findSame(TrieNode node, String str, int index) {
            if (str.length() == index) {
                // System.out.println(str + " " + node.ch);
                // System.out.println(node.count);
                return node.count;
            }
            int count = 0;
            if (node.children.containsKey(str.charAt(index))) {
                count += findSame(node.children.get(str.charAt(index)), str, index + 1);
            }
            return count;
        }

        static class CountTrie {

            TrieNode head = new TrieNode('\0');

            Set<String> contains = new HashSet<>();

            public void add(String str) {
                if (contains.contains(str)) {
                    return;
                }
                TrieNode node = head;
                for (char ch : str.toCharArray()) {
                    node.children.putIfAbsent(ch, new TrieNode(ch));
                    node = node.children.get(ch);
                    ++node.count;
                }
            }

        }

        static class TrieNode {
            char ch;
            int count = 0;
            Map<Character, TrieNode> children = new HashMap<>();

            public TrieNode(char ch) {
                super();
                this.ch = ch;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        // Assert.assertEquals(6, s.countSubstrings("aba", "baba"));
        Assert.assertEquals(3, s.countSubstrings("ab", "bb"));
        Assert.assertEquals(0, s.countSubstrings("a", "a"));
        Assert.assertEquals(10, s.countSubstrings("abe", "bbc"));
    }

}
