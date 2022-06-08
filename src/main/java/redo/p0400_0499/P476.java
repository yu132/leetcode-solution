package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: P476  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月19日  
 *  
 */
public class P476 {

    class Solution {
        public int findComplement(int num) {
            return ~num & getMask(num);
        }

        // 生成最高位到最右边全1的掩码，屏蔽前导0
        public int getMask(int num) {
            num |= num >>> 1;
            num |= num >>> 2;
            num |= num >>> 4;
            num |= num >>> 8;
            num |= num >>> 16;
            return num;
        }
    }

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(2, s.findComplement(5));
        assertEquals(0, s.findComplement(1));
    }

}
