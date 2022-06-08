package redo.p1200_1299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P1297  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月11日  
 *  
 */
public class P1297 {

    static//

    class Solution {
        public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
            int[] indexes = new int[26];
            Set<Character> chs = new HashSet<>();
            Counter<String> counter = new Counter<>();

            int start = 0;
            for (int i = 0; i < s.length(); ++i) {
                chs.add(s.charAt(i));
                indexes[s.charAt(i) - 'a'] = i;
                if (chs.size() > maxLetters) {
                    int min = Integer.MAX_VALUE;
                    char exceptChar = 0;
                    for (char ch : chs) {
                        if (min > indexes[ch - 'a']) {
                            min = indexes[ch - 'a'];
                            exceptChar = ch;
                        }
                    }
                    chs.remove(exceptChar);
                    start = min + 1;
                }
                if (start <= i - minSize + 1) {
                    counter.plus1(s.substring(i - minSize + 1, i + 1));
                }
            }

            int max = 0;
            for (int val : counter.values()) {
                max = Math.max(max, val);
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

            public void plus1(K key) {
                ++counter.computeIfAbsent(key, (x) -> new IntValue()).value;
            }

            public void add(K key, int num) {
                counter.computeIfAbsent(key, (x) -> new IntValue()).value += num;
            }

            public void minus1(K key) {
                if (counter.containsKey(key)) {
                    IntValue val = counter.get(key);
                    --val.value;
                    if (val.value == 0) {
                        counter.remove(key);
                    }
                }
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
        Assert.assertEquals(2, s.maxFreq("aababcaab", 2, 3, 4));
        Assert.assertEquals(2, s.maxFreq("aaaa", 1, 3, 3));
        Assert.assertEquals(3, s.maxFreq("aabcabcab", 2, 2, 3));
        Assert.assertEquals(0, s.maxFreq("abcde", 2, 3, 3));
    }

}
