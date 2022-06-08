package redo.p1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1233  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P1233 {

    static//

    class Solution {
        public List<String> removeSubfolders(String[] folder) {
            DisorderlyTrie<String> trie = new DisorderlyTrie<>();
            List<String> ans = new ArrayList<>();
            Arrays.sort(folder);
            for (String eachFolder : folder) {
                if (trie.add(splitAndRemoveEmpty(eachFolder, '/'))) {
                    ans.add(eachFolder);
                }
            }
            return ans;
        }

        // 使用某个单独字符进行切分，切分后不保留空字符串，即将多个spliter当作一个来处理
        public List<String> splitAndRemoveEmpty(String str, char spliter) {
            int start = 0;
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) == spliter) {
                    if (start == i) {
                        ++start;
                        continue;
                    }

                    ans.add(str.substring(start, i));

                    start = i + 1;
                }
            }

            if (start != str.length()) {
                ans.add(str.substring(start));
            }

            return ans;
        }

        static class DisorderlyTrie<T extends Comparable<T>> {

            DisorderlyTrieNode<T> head = new DisorderlyTrieNode<>(null);

            public boolean add(List<T> vals) {
                DisorderlyTrieNode<T> node = head;
                for (T val : vals) {
                    if (node.children.containsKey(val) && !node.children.get(val).isPrefix) {
                        return false;
                    }
                    node = node.children.computeIfAbsent(val, (x) -> new DisorderlyTrieNode<>(val));
                }
                node.isPrefix = false;
                return true;
            }
        }

        static class DisorderlyTrieNode<T> {
            T val;
            boolean isPrefix = true;
            Map<T, DisorderlyTrieNode<T>> children = new HashMap<>();

            public DisorderlyTrieNode(T val) {
                super();
                this.val = val;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList("/a", "/c/d", "/c/f"),
            s.removeSubfolders(new String[] {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}));
        Assert.assertEquals(Arrays.asList("/a"), s.removeSubfolders(new String[] {"/a", "/a/b/c", "/a/b/d"}));
        Assert.assertEquals(Arrays.asList("/a/b/c", "/a/b/ca", "/a/b/d"),
            s.removeSubfolders(new String[] {"/a/b/c", "/a/b/d", "/a/b/ca"}));
    }

}
