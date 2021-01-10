package redo.Util.ag.sternBrocot;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

/**  
 * @ClassName: SternBrocot  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
public class SternBrocotUtil {

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

    @Test
    public void test() {
        SternBrocot s = new SternBrocot();
        assertEquals(new HashSet<>(Arrays.asList("1/5", "1/4", "1/3", "2/5", "1/2", "3/5", "2/3", "3/4", "4/5")),
            new HashSet<>(s.getAllProperFraction(5)));
    }

}
