package redo.p1400_1499;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.StringList;

/**  
 * @ClassName: P1436  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class P1436 {

    static//

    class Solution {
        public String destCity(List<List<String>> paths) {
            Set<String> locations = new HashSet<>();
            for (int i = 0; i < paths.size(); ++i) {
                locations.add(paths.get(i).get(1));
            }
            for (int i = 0; i < paths.size(); ++i) {
                locations.remove(paths.get(i).get(0));
            }
            return locations.iterator().next();
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("Sao Paulo", s.destCity(
            StringList.build2DList("[[\"London\",\"New York\"],[\"New York\",\"Lima\"],[\"Lima\",\"Sao Paulo\"]]")));
        Assert.assertEquals("A", s.destCity(StringList.build2DList("[[\"B\",\"C\"],[\"D\",\"B\"],[\"C\",\"A\"]]")));
        Assert.assertEquals("Z", s.destCity(StringList.build2DList("[[\"A\",\"Z\"]]")));


    }

}
