package redo.p1600_1699;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1678  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月30日  
 *  
 */
public class P1678 {

    class Solution {
        public String interpret(String command) {
            return command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals("Goal", s.interpret("G()(al)"));
        Assert.assertEquals("Gooooal", s.interpret("G()()()()(al)"));
        Assert.assertEquals("alGalooG", s.interpret("(al)G(al)()()G"));
    }

}
