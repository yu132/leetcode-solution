package redo.p1800_1899;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**  
 * @ClassName: P1859  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年7月26日  
 *  
 */
public class P1859 {

    class Solution {
        public String sortSentence(String s) {
            return String.join(" ", Stream.of(s.split(" "))
                .sorted((a, b) -> Character.compare(a.charAt(a.length() - 1),
                    b.charAt(b.length() - 1)))
                .map(a -> a.substring(0, a.length() - 1))
                .collect(Collectors.toList()));
        }
    }

}
