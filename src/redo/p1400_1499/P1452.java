package redo.p1400_1499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import redo.testUtil.Arrs;

/**  
 * @ClassName: P1452  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月7日  
 *  
 */
public class P1452 {

    static//

    class Solution {
        public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
            ListMap<String, Integer> companyIndexMapping = new ListMap<>();

            Map<List<String>, Integer> listIndexMapping = new HashMap<>();

            for (int i = 0; i < favoriteCompanies.size(); ++i) {
                listIndexMapping.put(favoriteCompanies.get(i), i);
            }

            Collections.sort(favoriteCompanies, (a, b) -> Integer.compare(b.size(), a.size()));

            List<Integer> ans = new ArrayList<>();

            for (int i = 0; i < favoriteCompanies.size(); ++i) {
                List<String> companies = favoriteCompanies.get(i);
                int[] count = new int[i];
                for (String company : companies) {
                    for (int index : companyIndexMapping.get(company)) {
                        ++count[index];
                    }
                    companyIndexMapping.add(company, i);
                }
                boolean flag = true;
                for (int num : count) {
                    if (num == companies.size()) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans.add(listIndexMapping.get(companies));
                }
            }

            Collections.sort(ans);

            return ans;
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
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(Arrays.asList(0, 1, 4), s.peopleIndexes(Arrs.build2DsL(
            "[[\"leetcode\",\"google\",\"facebook\"],[\"google\",\"microsoft\"],[\"google\",\"facebook\"],[\"google\"],[\"amazon\"]]")));

        Assert.assertEquals(Arrays.asList(0, 1), s.peopleIndexes(Arrs.build2DsL(
            "[[\"leetcode\",\"google\",\"facebook\"],[\"leetcode\",\"amazon\"],[\"facebook\",\"google\"]]")));

        Assert.assertEquals(Arrays.asList(0, 1, 2, 3),
            s.peopleIndexes(Arrs.build2DsL("[[\"leetcode\"],[\"google\"],[\"facebook\"],[\"amazon\"]]")));

    }

}
