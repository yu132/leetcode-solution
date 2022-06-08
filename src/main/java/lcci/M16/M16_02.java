package lcci.M16;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: M16_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年3月13日  
 *  
 */
public class M16_02 {

    class WordsFrequency {

        private Map<String, Integer> map;

        public WordsFrequency(String[] book) {
            map = new HashMap<>();

            for (String each : book) {
                map.put(each, map.getOrDefault(each, 0) + 1);
            }
        }

        public int get(String word) {
            return map.getOrDefault(word, 0);
        }
    }

}
