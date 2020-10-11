package _1400_1499;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName: _1408  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年5月14日  
 *  
 */
public class _1408 {

    class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < words.length; ++i) {
                for (int j = 0; j < words.length; ++j) {
                    if (i == j) {
                        continue;
                    }
                    if (words[j].contains(words[i])) {
                        list.add(words[i]);
                        break;
                    }
                }
            }
            return list;
        }
    }

}
