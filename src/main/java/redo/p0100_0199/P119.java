package redo.p0100_0199;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**  
 * @ClassName: P119  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月17日  
 *  
 */
public class P119 {

    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> list = new ArrayList<>();
            list.add(1);

            while (rowIndex-- != 0) {
                list.add(1);
                for (int i = list.size() - 2; i >= 1; --i) {
                    list.set(i, list.get(i) + list.get(i - 1));
                }
            }

            return list;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals("[1,3,3,1]", s.getRow(3).toString().replaceAll("\\s", ""));
        assertEquals("[1,4,6,4,1]", s.getRow(4).toString().replaceAll("\\s", ""));
    }

}
