package redo.p1000_1099;

/**  
 * @ClassName: P1095  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月28日  
 *  
 */
public class P1095 {

    class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {

            int peak = findPeak(mountainArr);

            int ret = binarySearch(mountainArr, 0, peak, target);

            if (ret != -1) {
                return ret;
            }

            ret = reverseBinarySearch(mountainArr, peak, mountainArr.length(),
                target);

            return ret;
        }

        int reverseBinarySearch(MountainArray mountainArr, int low, int high,
            int target) {
            --high;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (mountainArr.get(mid) < target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if (mountainArr.get(low - 1) == target) {
                return low - 1;
            }
            return -1;
        }

        int binarySearch(MountainArray mountainArr, int low, int high,
            int target) {
            --high;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (mountainArr.get(mid) < target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if (mountainArr.get(low) == target) {
                return low;
            }
            return -1;
        }

        int findPeak(MountainArray mountainArr) {
            int low = 0, high = mountainArr.length() - 1;
            while (low < high) {
                int mid = (low + high) >>> 1;
                if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

    interface MountainArray {
        public int get(int index);

        public int length();
    }

}
