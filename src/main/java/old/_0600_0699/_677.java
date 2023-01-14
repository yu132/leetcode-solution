/**
 * @Title: _677.java
 *
 * @Package old._0600_0699
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月30日
 *
 */
package old._0600_0699;

/**
 * @ClassName: _677
 *
 * @Description: TODO(这里用一句话描述这个类的作用)
 *
 * @author 余定邦
 *
 * @date 2020年1月30日
 * 
 */
public class _677 {

    static class MapSum {

        static class Trie {

            private class TrieNode {

                TrieNode[] children = new TrieNode[26];

                int weight = 0;
            }

            private TrieNode root = new TrieNode();

            public void insert(String str, int weight) {
                TrieNode node = root;
                for (int i = 0; i < str.length(); ++i) {
                    int index = str.charAt(i) - 'a';
                    if (node.children[index] == null) {
                        node.children[index] = new TrieNode();
                    }
                    node = node.children[index];
                }
                node.weight = weight;
            }

            public int sum(String prefix) {
                TrieNode node = root;
                for (int i = 0; i < prefix.length(); ++i) {
                    int index = prefix.charAt(i) - 'a';
                    if (node.children[index] == null) {
                        return 0;
                    }
                    node = node.children[index];
                }

                return dfsSum(node);
            }

            private int dfsSum(TrieNode node) {
                if (node == null) {
                    return 0;
                }
                int weight = node.weight;

                for (int i = 0; i < 26; ++i) {
                    weight += dfsSum(node.children[i]);
                }

                return weight;
            }

        }

        private Trie trie = new Trie();

        /** Initialize your data structure here. */
        public MapSum() {}

        public void insert(String key, int val) {
            trie.insert(key, val);
        }

        public int sum(String prefix) {
            return trie.sum(prefix);
        }
    }

}
