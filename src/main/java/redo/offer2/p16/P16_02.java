package redo.offer2.p16;

import java.util.HashMap;
import java.util.Map;

/**  
 * @ClassName: P16_02  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月11日  
 *  
 */
public class P16_02 {

    class WordsFrequency {

        Map<String, Integer> counter;

        public WordsFrequency(String[] book) {
            counter = new HashMap<>(book.length);
            for (String word : book) {
                counter.put(word, counter.getOrDefault(word, 0) + 1);
            }
        }

        public int get(String word) {
            return counter.getOrDefault(word, 0);
        }
    }

}
