package redo.p1100_1199;

import org.junit.Assert;
import org.junit.Test;
import utils.Sets;

import java.util.*;

/**
 * @author 余定邦
 * @ClassName: P1169
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2021年1月14日
 */
public class P1169 {

    static//

    class Solution {
        public List<String> invalidTransactions(String[] transactions) {
            ListMap<String, Transaction> listMap = new ListMap<>();
            for (String str : transactions) {
                Transaction transaction = Transaction.of(str);
                listMap.add(transaction.name, transaction);
            }

            List<String> invalid = new ArrayList<>();
            for (List<Transaction> transactionsList : listMap.map.values()) {
                Collections.sort(transactionsList, (a, b) -> Integer.compare(a.time, b.time));
                Counter<String> citys = new Counter<>();

                for (int left = 0, mid = 0, right = 0; mid < transactionsList.size(); ++mid) {
                    while (right < transactionsList.size()
                            && transactionsList.get(right).time <= transactionsList.get(mid).time + 60) {
                        citys.plus1(transactionsList.get(right).city);
                        ++right;
                    }
                    while (left < mid && transactionsList.get(left).time < transactionsList.get(mid).time - 60) {
                        citys.minus1(transactionsList.get(left).city);
                        ++left;
                    }
                    if (citys.counter.size() > 1 || transactionsList.get(mid).amount > 1000) {
                        invalid.add(transactionsList.get(mid).toString());
                    }
                }
            }

            return invalid;
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

        static class ListMap<K, E> {

            Map<K, List<E>> map = new HashMap<>();

            public void add(K key, E element) {
                map.computeIfAbsent(key, (x) -> new ArrayList<>()).add(element);
            }

            public void remove(K key, E element) {
                map.computeIfAbsent(key, (x) -> new ArrayList<>()).remove(element);
            }

            public List<E> get(K key) {
                return map.getOrDefault(key, Collections.emptyList());
            }

        }

        static class Transaction {
            String name, city;
            int time, amount;

            public Transaction(String name, String city, int time, int amount) {
                super();
                this.name = name;
                this.city = city;
                this.time = time;
                this.amount = amount;
            }

            static Transaction of(String str) {
                int index1 = str.indexOf(',');
                int index2 = str.indexOf(',', index1 + 1);
                int index3 = str.indexOf(',', index2 + 1);
                String name = str.substring(0, index1), city = str.substring(index3 + 1, str.length());
                int time = Integer.valueOf(str.substring(index1 + 1, index2)),
                        amount = Integer.valueOf(str.substring(index2 + 1, index3));
                return new Transaction(name, city, time, amount);
            }

            @Override
            public String toString() {
                return name + "," + time + "," + amount + "," + city;
            }
        }
    }


    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Sets.asSets("alice,20,800,mtv", "alice,50,100,beijing"),
                new HashSet<>(s.invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,100,beijing"})));

        Assert.assertEquals(Sets.asSets("alice,50,1200,mtv"),
                new HashSet<>(s.invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,1200,mtv"})));

        Assert.assertEquals(Sets.asSets("bob,50,1200,mtv"),
                new HashSet<>(s.invalidTransactions(new String[]{"alice,20,800,mtv", "bob,50,1200,mtv"})));

        Assert.assertEquals(
                Sets.asSets("a,1,10001,b", "a,2,1200,b", "a,3,10001,b", "a,4,1200,c", "a,5,10001,b", "a,6,1200,b"),
                new HashSet<>(s.invalidTransactions(
                        new String[]{"a,1,10001,b", "a,2,1200,b", "a,3,10001,b", "a,4,1200,c", "a,5,10001,b", "a,6,1200,b"})));
    }
}
