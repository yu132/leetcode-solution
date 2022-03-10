package redo.p0300_0399;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**  
 * @ClassName: P399  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月16日  
 *  
 */
public class P399 {

    static//

    class Solution {
        public double[] calcEquation(List<List<String>> equations,
            double[] values, List<List<String>> queries) {

            double[] ans = new double[queries.size()];

            Map<String, List<Data>> adjac = toAdjac(equations, values);

            Set<String> visited = new HashSet<>();

            for (int i = 0; i < queries.size(); ++i, visited.clear()) {
                List<String> query = queries.get(i);
                String start = query.get(0);
                String end = query.get(1);

                if (!adjac.containsKey(start) || !adjac.containsKey(end)) {
                    ans[i] = -1;
                    continue;
                }

                ans[i] = dfs(start, end, adjac, visited);
            }

            return ans;
        }

        double dfs(String node, String target, Map<String, List<Data>> adjac,
            Set<String> visited) {

            if (node.equals(target)) {
                return 1;
            }

            if (visited.contains(node)) {
                return -1;
            }
            visited.add(node);

            for (Data d : adjac.getOrDefault(node, Collections.emptyList())) {
                double ret = dfs(d.to, target, adjac, visited);
                if (ret != -1) {
                    return ret * d.val;
                }
            }

            return -1;
        }

        Map<String, List<Data>> toAdjac(List<List<String>> equations,
            double[] values) {

            Map<String, List<Data>> adjac = new HashMap<>();

            for (int i = 0; i < equations.size(); ++i) {
                String s1 = equations.get(i).get(0);
                String s2 = equations.get(i).get(1);
                double s1DivS2 = values[i];

                add(s1, s2, s1DivS2, adjac);
                add(s2, s1, 1 / s1DivS2, adjac);
            }

            return adjac;
        }

        void add(String from, String to, double val,
            Map<String, List<Data>> adjac) {

            adjac.computeIfAbsent(from, (x) -> new ArrayList<>())
                .add(new Data(to, val));
        }

        static class Data {
            String to;
            double val;

            public Data(String to, double val) {
                super();
                this.to = to;
                this.val = val;
            }
        }
    }

}
