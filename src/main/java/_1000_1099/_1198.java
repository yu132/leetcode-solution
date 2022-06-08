package _1000_1099;

/**  
 * @ClassName: _1198  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月15日  
 *  
 */
public class _1198 {

    class Solution {
        public int smallestCommonElement(int[][] mat) {
            int[]   index = new int[mat.length];
            boolean same  = true;

            while (true) {

                same = true;
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < mat.length; ++i) {
                    if (index[i] == mat[i].length) {
                        return -1;
                    }
                    if (mat[i][index[i]] > max) {
                        max = mat[i][index[i]];
                    }
                }

                for (int i = 0; i < mat.length; ++i) {
                    if (mat[i][index[i]] < max) {
                        ++index[i];
                        same = false;
                    }
                }

                if (same) {
                    return max;
                }
            }
        }
    }

    public static void main(String[] args) {
        new _1198().new Solution()
            .smallestCommonElement(new int[][] {{1, 2, 3, 4, 5}, {2, 4, 5, 8, 10}, {3, 5, 7, 9, 11}, {1, 3, 5, 7, 9}});
    }
}
