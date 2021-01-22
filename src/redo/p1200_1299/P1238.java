package redo.p1200_1299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1238  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月13日  
 *  
 */
public class P1238 {

    static//

    class Solution {
        public List<Integer> circularPermutation(int n, int start) {
            List<Integer> codes = generateCode(n);
            int index = codes.indexOf(start);
            return rotationLeft(codes, index);
        }

        // 向左移动k位
        public static <T> List<T> rotationLeft(List<T> list, int k) {
            List<T> ans = new ArrayList<>();
            ans.addAll(list.subList(k, list.size()));
            ans.addAll(list.subList(0, k));
            return ans;
        }

        // N代表编码的位数
        List<Integer> generateCode(int N) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0, len = 1 << N; i < len; ++i) {
                ans.add(i ^ (i >> 1));
            }
            return ans;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(3, 2, 0, 1), s.circularPermutation(2, 3));
        Assert.assertEquals(Arrays.asList(2, 6, 7, 5, 4, 0, 1, 3), s.circularPermutation(3, 2));
    }

}
