package redo.p1400_1499;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1418  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月8日  
 *  
 */
public class P1418 {

    static//

    class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            Map<Integer, Counter<String>> counter = new HashMap<>();
            Set<String> itemsNameSet = new HashSet<>();
            for (List<String> order : orders) {
                itemsNameSet.add(order.get(2));
                counter.computeIfAbsent(Integer.valueOf(order.get(1)), (x) -> new Counter<>()).plus1(order.get(2));
            }
            List<String> itemsNameList = new ArrayList<>(itemsNameSet);
            Collections.sort(itemsNameList);

            List<List<String>> ans = new ArrayList<>();

            List<String> title = new ArrayList<>();
            title.add("Table");
            title.addAll(itemsNameList);
            ans.add(title);

            List<Map.Entry<Integer, Counter<String>>> entryList = new ArrayList<>(counter.entrySet());
            Collections.sort(entryList, (a, b) -> Integer.compare(a.getKey(), b.getKey()));

            for (Map.Entry<Integer, Counter<String>> entry : entryList) {
                Counter<String> counterEach = entry.getValue();

                List<String> table = new ArrayList<>();
                table.add(String.valueOf(entry.getKey()));
                for (String itemName : itemsNameList) {
                    table.add(String.valueOf(counterEach.get(itemName)));
                }
                ans.add(table);
            }

            return ans;
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

        }

        static class IntValue {
            int value = 0;
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrs.build2DsL(
            "[[\"Table\",\"Beef Burrito\",\"Ceviche\",\"Fried Chicken\",\"Water\"],[\"3\",\"0\",\"2\",\"1\",\"0\"],[\"5\",\"0\",\"1\",\"0\",\"1\"],[\"10\",\"1\",\"0\",\"0\",\"0\"]]"),
            s.displayTable(Arrs.build2DsL(
                "[[\"David\",\"3\",\"Ceviche\"],[\"Corina\",\"10\",\"Beef Burrito\"],[\"David\",\"3\",\"Fried Chicken\"],[\"Carla\",\"5\",\"Water\"],[\"Carla\",\"5\",\"Ceviche\"],[\"Rous\",\"3\",\"Ceviche\"]]")));

        Assert.assertEquals(
            Arrs.build2DsL(
                "[[\"Table\",\"Canadian Waffles\",\"Fried Chicken\"],[\"1\",\"2\",\"0\"],[\"12\",\"0\",\"3\"]]"),
            s.displayTable(Arrs.build2DsL(
                "[[\"James\",\"12\",\"Fried Chicken\"],[\"Ratesh\",\"12\",\"Fried Chicken\"],[\"Amadeus\",\"12\",\"Fried Chicken\"],[\"Adam\",\"1\",\"Canadian Waffles\"],[\"Brianna\",\"1\",\"Canadian Waffles\"]]")));

        Assert.assertEquals(
            Arrs.build2DsL("[[\"Table\",\"Bean Burrito\",\"Beef Burrito\",\"Soda\"],[\"2\",\"1\",\"1\",\"1\"]]"),
            s.displayTable(Arrs.build2DsL(
                "[[\"Laura\",\"2\",\"Bean Burrito\"],[\"Jhon\",\"2\",\"Beef Burrito\"],[\"Melissa\",\"2\",\"Soda\"]]")));

    }

}
