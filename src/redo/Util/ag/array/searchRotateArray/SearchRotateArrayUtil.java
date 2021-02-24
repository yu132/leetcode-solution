package redo.Util.ag.array.searchRotateArray;

/**  
 * @ClassName: SearchRotateArrayUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月11日  
 *  
 */
public class SearchRotateArrayUtil {

    // 重复旋转数组中查找特定值
    public int search(int[] arr, int target) {
        int bound = findBound(arr);
        int index = lowerBound(arr, target, 0, bound);
        if (arr[index] == target) {
            return index;
        }
        index = lowerBound(arr, target, bound, arr.length);
        if (index != arr.length && arr[index] == target) {
            return index;
        }
        return -1;
    }

    public int lowerBound(int[] arr, int target, int low, int high) {
        if (low >= high) {
            return low;
        }
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (target <= arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // 可能出现重复的寻找边界，返回数组中最小值的旋转前下标
    public int findBound(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) >>> 1;
            if (arr[mid] == arr[high]) {
                --high;
            } else if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                if (high + 1 < arr.length && arr[high + 1] < arr[high]) {
                    return high + 1;
                }
                high = mid;
            }
        }
        return low;
    }

}
