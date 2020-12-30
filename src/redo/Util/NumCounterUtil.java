package redo.Util;

/**  
 * @ClassName: NumCounter  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class NumCounterUtil {

    public static int[] count(int[] nums, int start, int end) {
        int[] count = new int[end - start];
        for (int num : nums) {
            ++count[num - start];
        }
        return count;
    }

    // 前缀和 sum(0 to i)=prefix[i+1];
    public static int[] prefix(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return prefix;
    }

    // 后缀和 sum(i to len)=suffix[i];
    public static int[] suffix(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; --i) {
            prefix[i] = prefix[i + 1] + nums[i];
        }
        return prefix;
    }

    public static void countRowAndColumn(int[][] matrix, int[] row, int[] col) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                row[i] += matrix[i][j];
                col[j] += matrix[i][j];
            }
        }
    }

}
