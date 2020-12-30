package _1600_1699;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

/**  
 * @ClassName: _1640  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月14日  
 *  
 */
public class _1640 {

    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            HashMap<Integer, int[]> map = new HashMap<>();
            for (int[] a : pieces) {
                map.put(a[0], a);
            }
            int index = 0;
            while (index < arr.length) {
                int[] pic = map.get(arr[index]);
                if (pic == null) {
                    return false;
                }
                for (int i = 0; i < pic.length; ++i) {
                    if (pic[i] != arr[index + i]) {
                        return false;
                    }
                }
                index += pic.length;
            }
            return true;
        }
    }

    @Test
    public void test() {
        int[] arr = {91, 4, 64, 78};
        int[][] pics = {{78}, {4, 64}, {91}};
        assertTrue(new Solution().canFormArray(arr, pics));
    }

}
