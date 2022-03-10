package redo.p1800_1899;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import redo.testUtil.Arrs;

/**  
 * @ClassName: P1886  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1886 {

    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            int count1 = count(mat), count2 = count(target);

            if (count1 != count2) {
                return false;
            }

            if (equals(mat, target)) {
                return true;
            }

            for (int i = 0; i < 3; ++i) {
                turn90(mat);
                if (equals(mat, target)) {
                    return true;
                }
            }

            return false;
        }

        boolean equals(int[][] mat, int[][] target) {
            int n = mat.length;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (mat[i][j] != target[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        void turn90(int[][] mat) {
            int n = mat.length;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n / 2; ++j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[i][n - 1 - j];
                    mat[i][n - 1 - j] = temp;
                }
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }
        }

        int count(int[][] mat) {
            int n = mat.length;
            int count = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    count += mat[i][j];
                }
            }
            return count;
        }
    }

    @Test
    public void test() {
        assertEquals(true,
            new Solution().findRotation(
                Arrs.build2D("[[0,0,0],[0,1,0],[1,1,1]]"),
                Arrs.build2D("[[1,1,1],[0,1,0],[0,0,0]]")));
    }
}
