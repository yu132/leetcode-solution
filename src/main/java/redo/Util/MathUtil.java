package redo.Util;

/**  
 * @ClassName: MathUtil  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月12日  
 *  
 */
public class MathUtil {

    public static int min(int... nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }

    public static int max(int... nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

}
