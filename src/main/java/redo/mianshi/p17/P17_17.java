package redo.mianshi.p17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: P17_17  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月18日  
 *  
 */
public class P17_17 {

    static//

    class Solution {
        public int[][] multiSearch(String big, String[] smalls) {
            TrieNode root = new TrieNode();

            for (String str : smalls) {
                add(root, str);
            }

            Map<String, Integer> strIndexMap = new HashMap<>();

            for (int i = 0; i < smalls.length; ++i) {
                strIndexMap.put(smalls[i], i);
            }

            @SuppressWarnings("unchecked")
            List<Integer>[] ans = new ArrayList[smalls.length];

            Arrays.setAll(ans, (x) -> new ArrayList<>());

            for (int i = 0; i < big.length(); ++i) {
                find(root, big, i, strIndexMap, ans);
            }

            int[][] aarr = new int[smalls.length][];
            int index = 0;

            for (List<Integer> list : ans) {
                aarr[index] = new int[list.size()];
                for (int i = 0; i < list.size(); ++i) {
                    aarr[index][i] = list.get(i);
                }
                ++index;
            }

            return aarr;
        }

        void find(TrieNode root, String word, int index,
            Map<String, Integer> strIndexMap, List<Integer>[] ans) {

            while (index < word.length()) {
                int chIndex = word.charAt(index++) - 'a';
                if (root.childres[chIndex] == null) {
                    return;
                }
                root = root.childres[chIndex];
                if (root.isWord) {
                    int si = strIndexMap.get(root.word);
                    int start = index - root.word.length();
                    ans[si].add(start);
                }
            }
        }

        void add(TrieNode root, String str) {
            int index = 0;
            while (index < str.length()) {
                int chIndex = str.charAt(index++) - 'a';
                if (root.childres[chIndex] == null) {
                    root.childres[chIndex] = new TrieNode();
                }
                root = root.childres[chIndex];
            }
            if (!root.isWord) {
                root.isWord = true;
                root.word = str;
            }
        }

        static class TrieNode {
            TrieNode[] childres;
            String word;
            boolean isWord;

            public TrieNode() {
                super();
                this.childres = new TrieNode[26];
            }
        }
    }

}
