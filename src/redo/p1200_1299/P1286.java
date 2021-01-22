package redo.p1200_1299;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1286  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class P1286 {

    class CombinationIterator {

        String next;
        String characters;
        int[] indexes;

        public CombinationIterator(String characters, int combinationLength) {
            indexes = new int[combinationLength];
            this.characters = characters;
            Arrays.setAll(indexes, (x) -> x);
            next = characters.substring(0, combinationLength);
        }

        public String next() {
            String ret = next;
            for (int i = indexes.length - 1; i >= 0; --i) {
                if (indexes[i] < characters.length() - (indexes.length - i)) {
                    ++indexes[i];
                    for (int j = i + 1; j < indexes.length; ++j) {
                        indexes[j] = indexes[j - 1] + 1;
                    }
                    char[] ch = new char[indexes.length];
                    for (int k = 0; k < indexes.length; ++k) {
                        ch[k] = characters.charAt(indexes[k]);
                    }
                    next = String.valueOf(ch);
                    return ret;
                }
            }
            next = null;
            return ret;
        }

        public boolean hasNext() {
            return next != null;
        }
    }

    @Test
    public void test() {
        CombinationIterator s = new CombinationIterator("abc", 2);
        Assert.assertEquals("ab", s.next());
        Assert.assertEquals(true, s.hasNext());
        Assert.assertEquals("ac", s.next());
        Assert.assertEquals(true, s.hasNext());
        Assert.assertEquals("bc", s.next());
        Assert.assertEquals(false, s.hasNext());
    }

    @Test
    public void test2() {
        CombinationIterator s = new CombinationIterator("ahijp", 2);
        Assert.assertEquals("ah", s.next());
        Assert.assertEquals(true, s.hasNext());
        Assert.assertEquals("ai", s.next());
        Assert.assertEquals(true, s.hasNext());
        Assert.assertEquals("aj", s.next());
        Assert.assertEquals(true, s.hasNext());
        Assert.assertEquals("ap", s.next());
        Assert.assertEquals(true, s.hasNext());
        Assert.assertEquals("hi", s.next());
        Assert.assertEquals(true, s.hasNext());
        Assert.assertEquals("hj", s.next());
        Assert.assertEquals(true, s.hasNext());
        Assert.assertEquals("hp", s.next());
        Assert.assertEquals(true, s.hasNext());
    }

}
