package redo.offer2.p17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P17_22  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月19日  
 *  
 */
public class P17_22 {

    class Solution {
        public List<String> findLadders(String beginWord, String endWord,
            List<String> wordList) {

            int n = beginWord.length();

            if (endWord.length() != n) {
                return Collections.emptyList();
            }

            Map<String, List<String>> listMap = new HashMap<>();

            Map<String, List<String>> patternMap = new HashMap<>();

            Map<String, Integer> indexesMap = new HashMap<>();

            int index = 0;

            for (String str : wordList) {
                if (str.length() != n) {
                    continue;
                }
                indexesMap.put(str, index++);
            }
            indexesMap.put(beginWord, index++);

            if (!indexesMap.containsKey(endWord)) {
                return Collections.emptyList();
            }

            for (String str : wordList) {
                if (str.length() != n) {
                    continue;
                }
                genPattern(patternMap, str);
            }
            genPattern(patternMap, beginWord);

            for (String str : wordList) {
                if (str.length() != n) {
                    continue;
                }
                addPattern(listMap, patternMap, str);
            }
            addPattern(listMap, patternMap, beginWord);

            Set<String> inQueue = new HashSet<>();

            Deque<String> queue = new LinkedList<>();

            queue.offer(beginWord);
            inQueue.add(beginWord);

            String[] prev = new String[index];

            while (!queue.isEmpty()) {
                String str = queue.poll();

                if (str.equals(endWord)) {
                    break;
                }

                for (String pattern : patternMap.get(str)) {
                    for (String next : listMap.get(pattern)) {
                        if (inQueue.contains(next)) {
                            continue;
                        }
                        queue.offer(next);
                        inQueue.add(next);
                        prev[indexesMap.get(next)] = str;
                    }
                }
            }

            if (prev[indexesMap.get(endWord)] == null) {
                return Collections.emptyList();
            }

            List<String> ans = new ArrayList<>();

            String word = endWord;

            while (!word.equals(beginWord)) {
                ans.add(word);
                word = prev[indexesMap.get(word)];
            }

            ans.add(beginWord);

            Collections.reverse(ans);

            return ans;
        }


        void genPattern(Map<String, List<String>> patternMap, String str) {
            char[] chs = str.toCharArray();
            for (int i = 0; i < chs.length; ++i) {
                char temp = chs[i];
                chs[i] = '*';
                add(patternMap, str, String.valueOf(chs));
                chs[i] = temp;
            }
        }

        void addPattern(Map<String, List<String>> listMap,
            Map<String, List<String>> patternMap, String str) {
            for (String pattern : patternMap.get(str)) {
                add(listMap, pattern, str);
            }
        }

        void add(Map<String, List<String>> listMap, String key, String val) {
            listMap.computeIfAbsent(key, (x) -> new ArrayList<>()).add(val);
        }
    }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertEquals(
            Arrays.asList("hit", "hot", "dot", "lot", "log", "cog"),
            s.findLadders("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

}
