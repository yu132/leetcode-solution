package redo.p1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**  
 * @ClassName: P1222  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P1222 {

    static//

    class Solution {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            int[][] queenCandidate = new int[8][];
            for (int[] queen : queens) {
                if (queen[0] == king[0]) {// 水平
                    if (queen[1] > king[1]) {// 0
                        if (queenCandidate[0] == null || queen[1] < queenCandidate[0][1]) {
                            queenCandidate[0] = queen;
                        }
                    } else {// 1
                        if (queenCandidate[1] == null || queen[1] > queenCandidate[1][1]) {
                            queenCandidate[1] = queen;
                        }
                    }
                } else if (queen[1] == king[1]) {// 垂直
                    if (queen[0] > king[0]) {// 2
                        if (queenCandidate[2] == null || queen[0] < queenCandidate[2][0]) {
                            queenCandidate[2] = queen;
                        }
                    } else {// 3
                        if (queenCandidate[3] == null || queen[0] > queenCandidate[3][0]) {
                            queenCandidate[3] = queen;
                        }
                    }
                } else if (queen[0] - king[0] == queen[1] - king[1]) {// 主对角线
                    if (queen[1] > king[1]) {// 4
                        if (queenCandidate[4] == null || queen[1] < queenCandidate[4][1]) {
                            queenCandidate[4] = queen;
                        }
                    } else {// 5
                        if (queenCandidate[5] == null || queen[1] > queenCandidate[5][1]) {
                            queenCandidate[5] = queen;
                        }
                    }
                } else if (queen[0] + queen[1] == king[0] + king[1]) {// 副对角线
                    if (queen[1] > king[1]) {// 6
                        if (queenCandidate[6] == null || queen[1] < queenCandidate[6][1]) {
                            queenCandidate[6] = queen;
                        }
                    } else {// 7
                        if (queenCandidate[7] == null || queen[1] > queenCandidate[7][1]) {
                            queenCandidate[7] = queen;
                        }
                    }
                }
            }

            List<List<Integer>> ans = new ArrayList<>();
            for (int[] queen : queenCandidate) {
                if (queen == null) {
                    continue;
                }
                ans.add(Arrays.asList(queen[0], queen[1]));
            }
            return ans;
        }
    }

}
