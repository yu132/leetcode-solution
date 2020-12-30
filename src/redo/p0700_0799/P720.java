package redo.p0700_0799;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P720  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P720 {

    class Solution {
        public String longestWord(String[] words) {
            TrieNode head = buildTrie(words);

            String[] ans = new String[1];

            for (TrieNode node : head.sub) {
                dfs(node, new ArrayList<>(30), ans);
            }

            if (ans[0] == null) {
                return "";
            }

            return ans[0];
        }

        public void dfs(TrieNode node, List<Character> list, String[] ans) {
            if (node == null || !node.isWord) {
                if (ans[0] == null || list.size() > ans[0].length()) {
                    ans[0] = build(list);
                }
                return;
            }
            list.add(node.ch);
            for (TrieNode subNode : node.sub) {
                dfs(subNode, list, ans);
            }
            list.remove(list.size() - 1);
        }

        public String build(List<Character> list) {
            StringBuilder sb = new StringBuilder(list.size());
            for (char ch : list) {
                sb.append(ch);
            }
            return sb.toString();
        }

        private TrieNode buildTrie(String[] words) {
            TrieNode head = new TrieNode('\0');
            for (String str : words) {
                TrieNode node = head;
                for (char ch : str.toCharArray()) {
                    if (node.sub[ch - 'a'] == null) {
                        node.sub[ch - 'a'] = new TrieNode(ch);
                    }
                    node = node.sub[ch - 'a'];
                }
                node.isWord = true;
            }
            return head;
        }

        class TrieNode {
            char ch;
            boolean isWord;
            TrieNode[] sub = new TrieNode[26];

            TrieNode(char ch) {
                super();
                this.ch = ch;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("world", s.longestWord(new String[] {"w", "wo", "wor", "worl", "world"}));
        Assert.assertEquals("apple",
            s.longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}));
        Assert.assertEquals("a", s.longestWord(new String[] {"a", "b"}));
        Assert.assertEquals("", s.longestWord(new String[] {}));
        Assert.assertEquals("", s.longestWord(new String[] {"ab"}));
    }

}
