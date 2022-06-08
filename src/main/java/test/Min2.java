package test;

/**  
 * @ClassName: Min2  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年9月23日  
 *  
 */
public class Min2 {

    public static void main(String[] args) {
        int[] nums = {-2, -1, 0, 1, 2};
        System.out.println(min2(nums));
    }

    public static int min2(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return min2;
    }

}
