package redo.p1400_1499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
 * @ClassName: P1462  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1462 {

    static//

    class Solution {
        public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
            int[] in = new int[n];
            SimpleIntArrayDeque in0 = new SimpleIntArrayDeque(n);

            ListMap<Integer, Integer> out = new ListMap<>();

            for (int[] prerequisite : prerequisites) {
                out.add(prerequisite[0], prerequisite[1]);
                ++in[prerequisite[1]];
            }

            for (int i = 0; i < n; ++i) {
                if (in[i] == 0) {
                    in0.offerLast(i);
                }
            }

            SetMap<Integer, Integer> pre = new SetMap<>();

            while (!in0.isEmpty()) {
                int from = in0.pollFirst();
                for (int to : out.get(from)) {
                    pre.add(to, from);
                    pre.addAll(to, pre.get(from));
                    --in[to];
                    if (in[to] == 0) {
                        in0.offerLast(to);
                    }
                }
            }

            List<Boolean> ans = new ArrayList<>();

            for (int[] querie : queries) {
                ans.add(pre.contain(querie[1], querie[0]));
            }

            return ans;
        }

        static class SetMap<K, E> {

            Map<K, Set<E>> map = new HashMap<>();

            public void add(K key, E element) {
                map.computeIfAbsent(key, (x) -> new HashSet<>()).add(element);
            }

            public void addAll(K key, Collection<E> elements) {
                map.computeIfAbsent(key, (x) -> new HashSet<>()).addAll(elements);
            }

            public void remove(K key, E element) {
                map.computeIfAbsent(key, (x) -> new HashSet<>()).remove(element);
            }

            public boolean contain(K key, E element) {
                return get(key).contains(element);
            }

            public Set<E> get(K key) {
                return map.getOrDefault(key, Collections.emptySet());
            }
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

        // 简化的数组双端队列，没有向头部添加的功能，也不能循环存储，必须开足够的空间
        static class SimpleIntArrayDeque {

            int start = 0, end = 0, deque[];

            public SimpleIntArrayDeque(int len) {
                super();
                this.deque = new int[len];
            }

            public void offerLast(int num) {
                deque[end++] = num;
            }

            public int pollLast() {
                return deque[--end];
            }

            public int peekLast() {
                return deque[end - 1];
            }

            public int pollFirst() {
                return deque[start++];
            }

            public int peekFirst() {
                return deque[start];
            }

            public boolean isEmpty() {
                return start == end;
            }

            public int size() {
                return end - start;
            }
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(false, true),
            s.checkIfPrerequisite(2, Arrs.build2D("[[1,0]]"), Arrs.build2D("[[0,1],[1,0]]")));

        Assert.assertEquals(Arrays.asList(false, false),
            s.checkIfPrerequisite(2, Arrs.build2D("[]"), Arrs.build2D("[[1,0],[0,1]]")));

        Assert.assertEquals(Arrays.asList(true, true),
            s.checkIfPrerequisite(3, Arrs.build2D("[[1,2],[1,0],[2,0]]"), Arrs.build2D("[[1,0],[1,2]]")));

        Assert.assertEquals(Arrays.asList(false, true),
            s.checkIfPrerequisite(3, Arrs.build2D("[[1,0],[2,0]]"), Arrs.build2D("[[0,1],[2,0]]")));

        Assert.assertEquals(Arrays.asList(true, false, true, false), s.checkIfPrerequisite(5,
            Arrs.build2D("[[0,1],[1,2],[2,3],[3,4]]"), Arrs.build2D("[[0,4],[4,0],[1,3],[3,0]]")));
    }
}
