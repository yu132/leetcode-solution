package redo.p2900_2999;

import redo.testUtil.Arrs;

import java.util.*;

public class P2975 {

    class Solution {

        public final static int MOD = 1_000_000_007;

        public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
            List<Integer> h = helper(m, hFences);
            List<Integer> v = helper(n, vFences);
            int ans = -1;
            Iterator<Integer> it1 = h.iterator(), it2 = v.iterator();
            int val1 = it1.next();
            int val2 = it2.next();
            while (true) {
                if (val1 == val2) {
                    ans = (int) (((long) val1 * val2) % MOD);
                    if (!it1.hasNext()) {
                        break;
                    }
                    val1 = it1.next();
                    if (!it2.hasNext()) {
                        break;
                    }
                    val2 = it2.next();
                } else if (val1 < val2) {
                    if (!it1.hasNext()) {
                        break;
                    }
                    val1 = it1.next();
                } else {
                    if (!it2.hasNext()) {
                        break;
                    }
                    val2 = it2.next();
                }
            }
            return ans;
        }

        List<Integer> helper(int m, int[] fences) {
            Set<Integer> treeSet = new HashSet<>();
            List<Integer> list = new ArrayList<>();
            list.add(1);
            Arrays.sort(fences);
            for (int num : fences) {
                list.add(num);
            }
            list.add(m);
            for (int i = 0; i < list.size(); ++i) {
                for (int j = i + 1; j < list.size(); ++j) {
                    treeSet.add(list.get(j) - list.get(i));
                }
            }
            List<Integer> ans = new ArrayList<>(treeSet);
            Collections.sort(ans);
            return ans;
        }

    }

    public static void main(String[] args) {
        new P2975().new Solution().maximizeSquareArea(4, 3, Arrs.build("[2,3]"), Arrs.build("[2]"));
    }


}
