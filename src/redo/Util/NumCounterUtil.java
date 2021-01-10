package redo.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**  
 * @ClassName: NumCounter  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年12月29日  
 *  
 */
public class NumCounterUtil {

    public static int[] count(int[] nums, int start, int end) {
        int[] count = new int[end - start];
        for (int num : nums) {
            ++count[num - start];
        }
        return count;
    }

    // 前缀和 sum(0 to i)=prefix[i+1];
    public static int[] prefix(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        return prefix;
    }

    // 后缀和 sum(i to len)=suffix[i];
    public static int[] suffix(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = nums.length - 1; i >= 0; --i) {
            prefix[i] = prefix[i + 1] + nums[i];
        }
        return prefix;
    }

    public static void countRowAndColumn(int[][] matrix, int[] row, int[] col) {
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                row[i] += matrix[i][j];
                col[j] += matrix[i][j];
            }
        }
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

    }

    static class IntValue {
        int value = 0;
    }

}
