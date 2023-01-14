package old._0600_0699;

/**  
 * @ClassName: _676  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月20日  
 *  
 */
public class _676 {

    class MagicDictionary {

        TreeNode root = new TreeNode();

        /** Initialize your data structure here. */
        public MagicDictionary() {}

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                TreeNode node = root;
                for (char ch : word.toCharArray()) {
                    if (node.children[ch - 'a'] == null) {
                        node.children[ch - 'a'] = new TreeNode();
                    }
                    node = node.children[ch - 'a'];
                }
                node.isWord = true;
            }
        }

        public boolean search(String searchWord) {
            return dfs(0, searchWord, root, 0);
        }

        public boolean dfs(int index, String searchWord, TreeNode node, int diff) {
            if (diff == 2) {
                return false;
            }
            if (node == null) {
                return diff == 1;
            }
            if (index == searchWord.length()) {
                if (!node.isWord) {
                    return false;
                }
                return diff == 1;
            }

            for (int i = 0; i < 26; ++i) {
                if (node.children[i] != null) {
                    if (i == searchWord.charAt(index) - 'a') {
                        if (dfs(index + 1, searchWord, node.children[i], diff)) {
                            return true;
                        }
                    } else {
                        if (dfs(index + 1, searchWord, node.children[i], diff + 1)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        class TreeNode {
            TreeNode[] children = new TreeNode[26];
            boolean isWord;
        }
    }


    public static void main(String[] args) {
        MagicDictionary md = new _676().new MagicDictionary();
        md.buildDict(new String[] {"hello", "leetcode"});
        System.out.println(md.search("hello"));
        System.out.println(md.search("hhllo"));
        System.out.println(md.search("hell"));
        System.out.println(md.search("leetcoded"));
        System.out.println(md.search("leetcode"));
        System.out.println(md.search("leetcoda"));
        System.out.println(md.search("beetcode"));
    }
}
