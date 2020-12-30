package utils;

import java.util.List;

/**  
 * @ClassName: CoptIntListToIntArray  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月20日  
 *  
 */
public class CoptIntListToIntArray {

    public int[] copy(List<Integer> list) {
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            nums[i] = list.get(i);
        }
        return nums;
    }

}
