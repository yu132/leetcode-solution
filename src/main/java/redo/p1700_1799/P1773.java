package redo.p1700_1799;

import java.util.List;

/**  
 * @ClassName: P1773  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年3月1日  
 *  
 */
public class P1773 {

    class Solution {
        public int countMatches(List<List<String>> items, String ruleKey,
            String ruleValue) {
            int index;
            if (ruleKey.equals("type")) {
                index = 0;
            } else if (ruleKey.equals("color")) {
                index = 1;
            } else {
                index = 2;
            }

            int count = 0;

            for (List<String> item : items) {
                if (ruleValue.equals(item.get(index))) {
                    ++count;
                }
            }

            return count;
        }
    }

}
