package redo.p0200_0299;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**  
 * @ClassName: P212  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月14日  
 *  
 */
public class P212 {

    static//

    class Solution {
        public List<String> findWords(char[][] board, String[] words) {

            if (board.length == 0 || board[0].length == 0) {
                return Collections.emptyList();
            }

            int m = board.length, n = board[0].length;

            UniqueTrie trie = new UniqueTrie();

            for (String str : words) {
                trie.add(str);
            }

            Set<String> ans = new HashSet<>();

            boolean[][] used = new boolean[m][n];

            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (check(i, j, m, n, board, trie.root)) {
                        dfs(i, j, m, n, board,
                            trie.root.children.get(board[i][j]), ans, used);
                    }
                }
            }

            return new ArrayList<>(ans);
        }

        static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        void dfs(int x, int y, int m, int n, char[][] board, TrieNode node,
            Set<String> ans, boolean[][] used) {

            if (used[x][y]) {
                return;
            }

            used[x][y] = true;

            if (node.isWord) {
                ans.add(node.str);
            }

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (check(nx, ny, m, n, board, node)) {
                    dfs(nx, ny, m, n, board, node.children.get(board[nx][ny]),
                        ans, used);
                }
            }

            used[x][y] = false;
        }

        boolean check(int x, int y, int m, int n, char[][] board,
            TrieNode node) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return false;
            }
            return node.children.containsKey(board[x][y]);
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
                node.str = str;
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
            String str;
            TreeMap<Character, TrieNode> children = new TreeMap<>();

            public TrieNode(char ch) {
                super();
                this.ch = ch;
            }
        }
    }

}
