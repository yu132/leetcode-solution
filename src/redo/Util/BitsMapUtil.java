package redo.Util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/**  
 * @ClassName: BitsMap  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月17日  
 *  
 */
public class BitsMapUtil {

    static class BM {
        int[] bits;

        public BM(int len) {
            super();
            this.bits = new int[(len - 1) / 32 + 1];
        }

        public void set(int index, int bit) {
            int i1 = index / 32, i2 = index % 32;
            if (bit == 1) {
                bits[i1] |= 1 << i2;
            } else {
                bits[i1] &= ~(1 << i2);
            }
        }

        public int get(int index) {
            int i1 = index / 32, i2 = index % 32;
            return (bits[i1] & (1 << i2)) >> i2;
        }
    }

    static class BitsMap {

        int[] bits;
        int lastMask;
        int len;

        BitsMap(int len) {
            bits = new int[(len - 1) / 32 + 1];
            lastMask = (1 << (len % 32)) - 1;
            this.len = len;
        }

        @Override
        public int hashCode() {
            int hashcode = 0;
            for (int num : bits) {
                hashcode ^= num;
            }
            return hashcode;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof BitsMap)) {
                return false;
            }
            return same((BitsMap)obj);
        }

        void set(int index, int bit) {
            if (bit == 1) {
                bits[index / 32] |= 1 << (index % 32);
            } else {
                bits[index / 32] &= ~(1 << index % 32);
            }
        }

        int get(int index) {
            int i1 = index / 32, i2 = index % 32;
            return (bits[i1] & (1 << i2)) >> i2;
        }

        boolean same(BitsMap other) {
            for (int i = 0; i < bits.length; ++i) {
                if (bits[i] != other.bits[i]) {
                    return false;
                }
            }
            return true;
        }

        boolean converse(BitsMap other) {
            for (int i = 0; i < bits.length - 1; ++i) {
                if (bits[i] != ~other.bits[i]) {
                    return false;
                }
            }

            return ((bits[bits.length - 1] ^ other.bits[bits.length - 1])
                | (~lastMask)) == -1;
        }
    }

    BitsMap build(String str) {
        BitsMap bitsMap = new BitsMap(str.length());
        for (int i = 0; i < str.length(); ++i) {
            bitsMap.set(i, str.charAt(str.length() - 1 - i) - '0');
        }
        return bitsMap;
    }

    String toString(BitsMap bitsMap) {
        StringBuilder buf = new StringBuilder(bitsMap.len);
        for (int i = bitsMap.len - 1; i >= 0; --i) {
            buf.append(bitsMap.get(i));
        }
        return buf.toString();
    }

    @Test
    public void test() {
        BitsMap bitsMap1 = build("10000");
        assertEquals(1, bitsMap1.get(4));
        assertEquals(0, bitsMap1.get(2));

        BitsMap bitsMap2 = build("01111");
        assertEquals(true, bitsMap1.converse(bitsMap2));

        String str1 =
            "1111111110111111111111111111111111001111111111111111110111111111111111111110000111111111111111111111101111111111";
        String str2 =
            "0000000001000000000000000000000000110000000000000000001000000000000000000001111000000000000000000000010000000000";

        assertEquals(true, build(str1).converse(build(str2)));
    }

}
