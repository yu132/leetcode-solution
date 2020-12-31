package redo.p1600_1699;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1656  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1656 {

    class OrderedStream {

        private String[] stream;
        private int index = 1;

        public OrderedStream(int n) {
            stream = new String[n + 1];
        }

        public List<String> insert(int id, String value) {
            stream[id] = value;
            if (index != id) {
                return Collections.emptyList();
            }
            List<String> ans = new ArrayList<>();
            for (; index < stream.length; ++index) {
                if (stream[index] == null) {
                    break;
                }
                ans.add(stream[index]);
            }
            return ans;
        }
    }



    @Test
    public void test() {
        OrderedStream s = new OrderedStream(5);
        Assert.assertEquals(Arrays.asList(), s.insert(3, "c"));
        Assert.assertEquals(Arrays.asList("a"), s.insert(1, "a"));
        Assert.assertEquals(Arrays.asList("b", "c"), s.insert(2, "b"));
        Assert.assertEquals(Arrays.asList(), s.insert(5, "e"));
        Assert.assertEquals(Arrays.asList("d", "e"), s.insert(4, "d"));
    }

}
