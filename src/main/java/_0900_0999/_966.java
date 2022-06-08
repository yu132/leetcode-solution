package _0900_0999;

import java.util.HashMap;
import java.util.HashSet;

/**  
 * @ClassName: _966  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年9月4日  
 *  
 */
public class _966 {

    class Solution {
        public String[] spellchecker(String[] wordlist, String[] queries) {

            HashSet<String>         wordset = new HashSet<>();
            HashMap<String, String> lowMap  = new HashMap<>(), missMap = new HashMap<>();

            for (String each : wordlist) {
                wordset.add(each);
                lowMap.putIfAbsent(each.toLowerCase(), each);
                missMap.putIfAbsent(each.toLowerCase().replaceAll("a|i|e|o|u", "*"), each);
            }

            for (int i = 0; i < queries.length; ++i) {
                if (wordset.contains(queries[i])) {
                    continue;
                }
                String s = lowMap.get(queries[i].toLowerCase());
                if (s != null) {
                    queries[i] = s;
                    continue;
                }
                s = missMap.get(queries[i].toLowerCase().replaceAll("a|i|e|o|u", "*"));
                if (s != null) {
                    queries[i] = s;
                    continue;
                }
                queries[i] = "";
            }

            return queries;
        }
    }

    public static void main(String[] args) {}

}
