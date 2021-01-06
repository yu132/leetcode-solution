package redo.Util.ag.maximumMargin;

import java.util.Arrays;

/**  
 * @ClassName: MaximumMarginUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月5日  
 *  
 */
public class MaximumMarginUtil {

    public int maxMargin(int[] position, int numOfThings) {
        Arrays.sort(position);
        int maxLen = position[position.length - 1] - position[0];
        int low = 0, high = maxLen + 1;
        while (low < high) {// 二分查找答案
            int mid = (low + high) >>> 1;
            if (possibleToPlace(position, mid, numOfThings)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low - 1;
    }

    private boolean possibleToPlace(int[] position, int distance, int num) {
        if (distance == 0) {
            return false;
        }

        int last = 0, possible = 1;
        for (int i = 1; i < position.length; ++i) {
            if (position[i] - position[last] >= distance) {
                ++possible;
                if (possible >= num) {
                    return true;
                }
                last = i;
            }
        }

        return false;
    }

}
