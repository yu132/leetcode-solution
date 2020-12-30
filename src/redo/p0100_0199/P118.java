package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**  
 * @ClassName: P118  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P118 {

    class Solution {
        public List<List<Integer>> generate(int numRows) {
            if (numRows == 0) {
                return Collections.emptyList();
            } else if (numRows == 1) {
                return Arrays.asList(Arrays.asList(1));
            }

            List<List<Integer>> lists = new ArrayList<>();
            lists.add(Arrays.asList(1));

            for (int i = 1; i < numRows; ++i) {
                lists.add(new ArrayList<>());
                List<Integer> list = lists.get(i);
                List<Integer> last = lists.get(i - 1);
                list.add(1);
                for (int j = 1; j < i; ++j) {
                    list.add(last.get(j) + last.get(j - 1));
                }
                list.add(1);
            }

            return lists;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]", s.generate(5).toString().replaceAll("\\s", ""));
    }



}
