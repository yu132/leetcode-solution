package redo.p1700_1799;

import java.util.Arrays;

/**  
 * @ClassName: P1710  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P1710 {

    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));

            int count = 0;

            for (int i = 0; i < boxTypes.length; ++i) {
                if (truckSize >= boxTypes[i][0]) {
                    count += boxTypes[i][0] * boxTypes[i][1];
                    truckSize -= boxTypes[i][0];
                } else {
                    count += truckSize * boxTypes[i][1];
                    break;
                }
            }

            return count;
        }
    }

}
