package redo.mianshi.p08;

/**  
 * @ClassName: P08_10  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月10日  
 *  
 */
public class P08_10 {

    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image[sr][sc] == newColor) {
                return image;
            }
            int m = image.length, n = image[0].length;

            dfs(image, sr, sc, m, n, image[sr][sc], newColor);

            return image;
        }

        public void dfs(int[][] image, int x, int y, int m, int n, int old,
            int newColor) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                return;
            }
            if (image[x][y] != old) {
                return;
            }
            image[x][y] = newColor;

            dfs(image, x + 1, y, m, n, old, newColor);
            dfs(image, x - 1, y, m, n, old, newColor);
            dfs(image, x, y + 1, m, n, old, newColor);
            dfs(image, x, y - 1, m, n, old, newColor);
        }
    }

}
