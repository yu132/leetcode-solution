package redo.p1200_1299;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1268  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月12日  
 *  
 */
public class P1268 {

    static//

    class Solution {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            UniqueTrie trie = new UniqueTrie();

            for (String product : products) {
                trie.add(product);
            }

            List<List<String>> ans = new ArrayList<>();

            for (int i = 1; i <= searchWord.length(); ++i) {
                ans.add(sreachMinK(searchWord.substring(0, i), 3, trie));
            }

            return ans;
        }

        static List<String> sreachMinK(String prefix, int k, UniqueTrie trie) {
            Deque<TrieNode> stack = new LinkedList<>();
            List<String> ans = new ArrayList<>();
            List<Character> chs = new ArrayList<>();

            TrieNode first = trie.head;

            for (char ch : prefix.toCharArray()) {
                TrieNode next = first.children.get(ch);
                if (next == null) {
                    return Collections.emptyList();
                }
                chs.add(ch);
                first = next;
            }

            if (first.isWord) {
                --k;
                ans.add(valueOf(chs));
            }

            for (TrieNode node : first.children.descendingMap().values()) {
                stack.push(node);
                stack.push(node);
            }

            while (!stack.isEmpty()) {
                TrieNode node = stack.pop();
                if (node == stack.peek()) {
                    chs.add(node.ch);
                    if (node.isWord) {
                        ans.add(valueOf(chs));
                        --k;
                        if (k == 0) {
                            return ans;
                        }
                    }
                    for (TrieNode child : node.children.descendingMap().values()) {
                        stack.push(child);
                        stack.push(child);
                    }
                } else {
                    chs.remove(chs.size() - 1);
                }
            }

            return ans;
        }

        public static String valueOf(List<Character> chs) {
            StringBuilder buf = new StringBuilder(chs.size());
            for (char ch : chs) {
                buf.append(ch);
            }
            return buf.toString();
        }

        static class UniqueTrie {

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
                }
                node.isWord = true;
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
        Assert.assertEquals(
            "[[mobile,moneypot,monitor],[mobile,moneypot,monitor],[mouse,mousepad],[mouse,mousepad],[mouse,mousepad]]",
            Arrs.toStrL(
                s.suggestedProducts(new String[] {"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse")));

        Assert.assertEquals("[[havana],[havana],[havana],[havana],[havana],[havana]]",
            Arrs.toStrL(s.suggestedProducts(new String[] {"havana"}, "havana")));

        Assert.assertEquals("[[baggage,bags,banner],[baggage,bags,banner],[baggage,bags],[bags]]",
            Arrs.toStrL(s.suggestedProducts(new String[] {"bags", "baggage", "banner", "box", "cloths"}, "bags")));

        Assert.assertEquals("[[],[],[],[],[],[],[]]",
            Arrs.toStrL(s.suggestedProducts(new String[] {"havana"}, "tatiana")));
    }

}
