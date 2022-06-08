package redo.p1000_1099;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1072  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月17日  
 *  
 */
public class P1072 {

    static//

    class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            Counter<BitsMap> counter = new Counter<>();
            for (int[] nums : matrix) {
                counter.plus1(build(nums));
                counter.plus1(buildReverse(nums));
            }
            return maxCount(counter);
        }

        BitsMap buildReverse(int[] arr) {
            BitsMap bitsMap = new BitsMap(arr.length);
            for (int i = 0; i < arr.length; ++i) {
                bitsMap.set(i, arr[i] ^ 1);
            }
            return bitsMap;
        }

        BitsMap build(int[] arr) {
            BitsMap bitsMap = new BitsMap(arr.length);
            for (int i = 0; i < arr.length; ++i) {
                bitsMap.set(i, arr[i]);
            }
            return bitsMap;
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

                return ((bits[bits.length - 1] ^ other.bits[bits.length - 1]) | (~lastMask)) == -1;
            }
        }

        public static <K> int maxCount(Counter<K> counter) {
            int max = Integer.MIN_VALUE;
            for (IntValue value : counter.counter.values()) {
                max = Math.max(max, value.value);
            }
            return max;
        }

        static class Counter<K> {

            private Map<K, IntValue> counter;

            public Counter() {
                this(16);
            }

            public Counter(int size) {
                super();
                this.counter = new HashMap<>(size);
            }

            public final static IntValue NUM_0 = new IntValue();

            public int plus1(K key) {
                return ++counter.computeIfAbsent(key, (x) -> new IntValue()).value;
            }

            public void add(K key, int num) {
                counter.computeIfAbsent(key, (x) -> new IntValue()).value += num;
            }

            public int minus1(K key) {
                if (counter.containsKey(key)) {
                    IntValue val = counter.get(key);
                    --val.value;
                    if (val.value == 0) {
                        counter.remove(key);
                    }
                    return val.value;
                }
                return 0;
            }

            public int get(K key) {
                return counter.getOrDefault(key, NUM_0).value;
            }

            public Set<K> keys() {
                return counter.keySet();
            }

            public List<Integer> values() {
                List<Integer> list = new ArrayList<>(counter.size());
                for (IntValue val : counter.values()) {
                    list.add(val.value);
                }
                return list;
            }

            public List<Pair<K>> keysAndVals() {
                List<Pair<K>> list = new ArrayList<>(counter.size());
                for (Map.Entry<K, IntValue> entry : counter.entrySet()) {
                    list.add(new Pair<K>(entry.getKey(), entry.getValue().value));
                }
                return list;
            }

        }

        static class Pair<K> {
            K key;
            int val;

            public Pair(K key, int val) {
                super();
                this.key = key;
                this.val = val;
            }
        }

        static class IntValue {
            int value = 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(1, s.maxEqualRowsAfterFlips(Arrs.build2D("[[0,1],[1,1]]")));
        Assert.assertEquals(2, s.maxEqualRowsAfterFlips(Arrs.build2D("[[0,1],[1,0]]")));
        Assert.assertEquals(2, s.maxEqualRowsAfterFlips(Arrs.build2D("[[0,0,0],[0,0,1],[1,1,0]]")));
    }

}
