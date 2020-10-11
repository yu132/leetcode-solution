package _0500_0599;

/**  
 * @ClassName: _531  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月17日  
 *  
 */
public class _531 {

    class Solution {
        public int findLonelyPixel(char[][] picture) {

            int[] col = new int[picture[0].length], row = new int[picture.length];

            for (int i = 0; i < picture.length; ++i) {
                for (int j = 0; j < picture[0].length; ++j) {
                    if (picture[i][j] == 'B') {
                        ++row[i];
                        ++col[j];
                    }
                }
            }

            int count = 0;

            for (int i = 0; i < picture.length; ++i) {
                for (int j = 0; j < picture[0].length; ++j) {
                    if (picture[i][j] == 'B' && col[j] == 1 && row[i] == 1) {
                        ++count;
                    }
                }
            }

            return count;

        }
    }

}
