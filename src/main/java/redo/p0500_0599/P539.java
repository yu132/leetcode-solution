package redo.p0500_0599;

import java.util.Arrays;
import java.util.List;

public class P539 {

    class Solution {
        public int findMinDifference(List<String> timePoints) {
            int[] arr = new int[timePoints.size()];
            for (int i = 0; i < timePoints.size(); ++i) {
                arr[i] = Integer.parseInt(timePoints.get(i).substring(0, 2)) * 60
                        + Integer.parseInt(timePoints.get(i).substring(3));
            }
            Arrays.sort(arr);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < arr.length; ++i) {
                min = Math.min(min, arr[i] - arr[i - 1]);
            }
            min = Math.min(min, arr[0] + 1440 - arr[arr.length - 1]);
            return min;
        }
    }

}
