package lcci.M08;

/**  
 * @ClassName: M08_10  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月5日  
 *  
 */
public class M08_10 {

    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image.length == 0) {
                return image;
            }
            if (image[sr][sc] == newColor) {
                return image;
            }
            dfs(image, sr, sc, image[sr][sc], newColor);
            return image;
        }

        public void dfs(int[][] image, int x, int y, int src, int target) {
            if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
                return;
            }
            if (image[x][y] != src) {
                return;
            }
            image[x][y] = target;
            dfs(image, x + 1, y, src, target);
            dfs(image, x - 1, y, src, target);
            dfs(image, x, y + 1, src, target);
            dfs(image, x, y - 1, src, target);
        }
    }

}
