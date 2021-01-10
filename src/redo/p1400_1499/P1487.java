package redo.p1400_1499;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1487  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月6日  
 *  
 */
public class P1487 {

    class Solution {
        public String[] getFolderNames(String[] names) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < names.length; ++i) {
                if (map.containsKey(names[i])) {
                    int suffix = map.get(names[i]);
                    while (map.containsKey(names[i] + '(' + suffix + ')')) {
                        ++suffix;
                    }
                    map.put(names[i] + '(' + suffix + ')', 1);
                    map.put(names[i], suffix + 1);
                    names[i] = names[i] + '(' + suffix + ')';
                } else {
                    map.put(names[i], 1);
                }
            }
            return names;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new String[] {"pes", "fifa", "gta", "pes(2019)"},
            s.getFolderNames(new String[] {"pes", "fifa", "gta", "pes(2019)"}));
        Assert.assertArrayEquals(new String[] {"gta", "gta(1)", "gta(2)", "avalon"},
            s.getFolderNames(new String[] {"gta", "gta(1)", "gta", "avalon"}));
        Assert.assertArrayEquals(new String[] {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece(4)"},
            s.getFolderNames(new String[] {"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"}));
        Assert.assertArrayEquals(new String[] {"wano", "wano(1)", "wano(2)", "wano(3)"},
            s.getFolderNames(new String[] {"wano", "wano", "wano", "wano"}));
        Assert.assertArrayEquals(new String[] {"kaido", "kaido(1)", "kaido(2)", "kaido(1)(1)"},
            s.getFolderNames(new String[] {"kaido", "kaido(1)", "kaido", "kaido(1)"}));
    }

}
