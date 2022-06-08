package redo.offer;

import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P12  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月4日  
 *  
 */
public class P12 {

    class Solution {
        public boolean exist(char[][] board, String word) {
            if (board.length == 0 || board[0].length == 0) {
                return false;
            }
            int m = board.length, n = board[0].length;
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (backtrack(0, i, j, board, word, visited)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean backtrack(int index, int x, int y, char[][] board,
            String word, boolean[][] visited) {
            if (index == word.length()) {
                return true;
            }
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                return false;
            }
            if (visited[x][y]) {
                return false;
            }
            if (board[x][y] != word.charAt(index)) {
                return false;
            }
            visited[x][y] = true;
            boolean flag = backtrack(index + 1, x + 1, y, board, word, visited)
                || backtrack(index + 1, x - 1, y, board, word, visited)
                || backtrack(index + 1, x, y + 1, board, word, visited)
                || backtrack(index + 1, x, y - 1, board, word, visited);
            visited[x][y] = false;
            return flag;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(true, s.exist(Arrs.build2Dc(
            "[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"),
            "ABCCED"));

        Assert.assertEquals(false,
            s.exist(Arrs.build2Dc("[[\"a\",\"b\"],[\"c\",\"d\"]]"), "abcd"));
    }

}
