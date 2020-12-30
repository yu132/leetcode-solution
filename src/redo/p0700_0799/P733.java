package redo.p0700_0799;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P733  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月21日  
 *  
 */
public class P733 {

    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image[sr][sc] == newColor) {
                return image;
            }
            dfs(sr, sc, image[sr][sc], newColor, image);
            return image;
        }

        public void dfs(int sr, int sc, int oldColor, int newColor, int[][] image) {
            if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
                return;
            }
            if (image[sr][sc] != oldColor) {
                return;
            }
            image[sr][sc] = newColor;
            dfs(sr - 1, sc, oldColor, newColor, image);
            dfs(sr + 1, sc, oldColor, newColor, image);
            dfs(sr, sc - 1, oldColor, newColor, image);
            dfs(sr, sc + 1, oldColor, newColor, image);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("[[2,2,2],[2,2,0],[2,0,1]]", Arrays
            .deepToString(s.floodFill(new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)).replaceAll("\\s", ""));
    }

}
