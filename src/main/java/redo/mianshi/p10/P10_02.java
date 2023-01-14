package redo.mianshi.p10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: P10_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月11日  
 *  
 */
public class P10_02 {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<StrVal, List<StrVal>> listMap = new HashMap<>();

            for (String str : strs) {
                StrVal strVal = new StrVal(str);
                add(strVal, listMap);
            }

            List<List<String>> ans = new ArrayList<>();

            for (List<StrVal> list : listMap.values()) {
                List<List<StrVal>> temp = new ArrayList<>();
                for (StrVal strVal : list) {

                    boolean notAdd = true;

                    for (List<StrVal> l : temp) {
                        if (l.get(0).equals(strVal)) {
                            l.add(strVal);
                            notAdd = false;
                            break;
                        }
                    }

                    if (notAdd) {
                        temp.add(new ArrayList<>(Arrays.asList(strVal)));
                    }

                }

                for (List<StrVal> l : temp) {
                    List<String> ll = new ArrayList<>(l.size());
                    for (StrVal sv : l) {
                        ll.add(sv.str);
                    }
                    ans.add(ll);
                }
            }

            return ans;
        }

        public void add(StrVal strVal, Map<StrVal, List<StrVal>> listMap) {
            listMap.computeIfAbsent(strVal, (x) -> new ArrayList<>())
                .add(strVal);
        }

        class StrVal {
            String str;

            int[] count;

            public StrVal(String str) {
                super();
                this.str = str;
            }

            void genCount() {
                if (count == null) {
                    count = new int[26];
                    for (char ch : str.toCharArray()) {
                        ++count[ch - 'a'];
                    }
                }
            }

            @Override
            public int hashCode() {
                genCount();
                int hash = 0;
                final int prime = 29;
                for (int num : count) {
                    hash = hash * prime + num;
                }
                return hash;
            }

            @Override
            public boolean equals(Object obj) {
                if (!(obj instanceof StrVal)) {
                    return false;
                }
                StrVal other = (StrVal)obj;
                genCount();
                other.genCount();
                return Arrays.equals(count, other.count);
            }

        }

    }

}
