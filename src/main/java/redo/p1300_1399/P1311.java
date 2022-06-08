package redo.p1300_1399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1311  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月10日  
 *  
 */
public class P1311 {

    static//

    class Solution {
        public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id,
            int level) {
            int n = friends.length;

            Counter<String> counter = new Counter<>(100);

            boolean[] visited = new boolean[n];

            // dfs(id, 0, level, friends, new boolean[n], counter, watchedVideos);

            Deque<Integer> queue = new LinkedList<>();
            queue.offer(id);

            int k = -1, size = 0;

            while (!queue.isEmpty()) {

                if (size == 0) {
                    size = queue.size();
                    ++k;
                }

                int now = queue.poll();

                --size;

                if (visited[now]) {
                    continue;
                }

                visited[now] = true;

                if (level == k) {
                    for (String video : watchedVideos.get(now)) {
                        counter.plus1(video);
                    }
                    continue;
                }

                for (int child : friends[now]) {
                    queue.offer(child);
                }
            }

            List<Pair<String>> kvs = counter.keysAndVals();
            Collections.sort(kvs, (a, b) -> {
                if (a.val == b.val) {
                    return a.key.compareTo(b.key);
                }
                return Integer.compare(a.val, b.val);
            });

            List<String> ans = new ArrayList<>();
            for (Pair<String> kv : kvs) {
                ans.add(kv.key);
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
        Assert.assertEquals(Arrays.asList("B", "C"),
            s.watchedVideosByFriends(Arrs.build2DsL("[[\"A\",\"B\"],[\"C\"],[\"B\",\"C\"],[\"D\"]]"),
                Arrs.build2D("[[1,2],[0,3],[0,3],[1,2]]"), 0, 1));

        Assert.assertEquals(Arrays.asList("D"),
            s.watchedVideosByFriends(Arrs.build2DsL("[[\"A\",\"B\"],[\"C\"],[\"B\",\"C\"],[\"D\"]]"),
                Arrs.build2D("[[1,2],[0,3],[0,3],[1,2]]"), 0, 2));

        Assert.assertEquals(Arrays.asList("C", "D"),
            s.watchedVideosByFriends(Arrs.build2DsL("[[\"A\",\"B\"],[\"C\"],[\"B\",\"C\"],[\"D\",\"C\"]]"),
                Arrs.build2D("[[1,2],[0,3],[0,3],[1,2]]"), 0, 2));
    }

}
