package redo.p1400_1499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1447  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
public class P1447 {

    static//

    class Solution {
        public List<String> simplifiedFractions(int n) {
            return new SternBrocot().getAllProperFraction(n);
        }

        static class SternBrocot {

            // 生成以2到N为底的所有真分数
            public List<String> getAllProperFraction(int N) {
                List<String> ans = new ArrayList<>();
                gen(0, 1, 1, 1, N, ans);
                return ans;
            }

            void gen(int m, int n, int mm, int nn, int N, List<String> ans) {
                if (n + nn <= N) {
                    gen(m, n, m + mm, n + nn, N, ans);
                    ans.add((m + mm) + "/" + (n + nn));
                    gen(m + mm, n + nn, mm, nn, N, ans);
                }
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList("1/2"), s.simplifiedFractions(2));
        Assert.assertEquals(Arrays.asList("1/3", "1/2", "2/3"), s.simplifiedFractions(3));
        Assert.assertEquals(Arrays.asList("1/4", "1/3", "1/2", "2/3", "3/4"), s.simplifiedFractions(4));
    }

}
