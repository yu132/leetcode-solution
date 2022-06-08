package redo.p2000_2099;

public class P2053 {

    class Solution {
        public String kthDistinct(String[] arr, int k) {
            SimpleTire tire = new SimpleTire();
            boolean[] used = new boolean[arr.length];
            for (int i = 0; i < arr.length; ++i) {
                int ret = tire.add(arr[i], i);
                if (ret != -1) {
                    used[ret] = true;
                    used[i] = true;
                }
            }
            for (int i = 0; i < arr.length; ++i) {
                if (!used[i]) {
                    --k;
                }
                if (k == 0) {
                    return arr[i];
                }
            }
            return "";
        }

        class SimpleTire {

            SimpleTrieNode root = new SimpleTrieNode('\0');

            public int add(String str, int index) {
                SimpleTrieNode node = root;
                for (char ch : str.toCharArray()) {
                    if (node.children[ch - 'a'] == null) {
                        node.children[ch - 'a'] = new SimpleTrieNode(ch);
                    }
                    node = node.children[ch - 'a'];
                }
                int x = node.index;
                node.index = index;
                return x;
            }
        }

        class SimpleTrieNode {
            char ch;
            int index = -1;
            SimpleTrieNode[] children = new SimpleTrieNode[26];

            public SimpleTrieNode(char ch) {
                this.ch = ch;
            }
        }
    }

}
