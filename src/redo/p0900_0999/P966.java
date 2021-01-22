package redo.p0900_0999;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**  
 * @ClassName: P966  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月21日  
 *  
 */
public class P966 {

    static//

    class Solution {
        public String[] spellchecker(String[] wordlist, String[] queries) {
            Map<String, String> exa = new HashMap<>(), caseWrong = new HashMap<>(), vowelWrong = new HashMap<>();
            for (String str : wordlist) {
                exa.put(str, str);
                caseWrong.putIfAbsent(str.toLowerCase(), str);
                vowelWrong.putIfAbsent(str.toLowerCase().replaceAll("a|i|o|u|e", "*"), str);
            }
            String[] ans = new String[queries.length];
            for (int i = 0; i < queries.length; ++i) {
                String result = exa.get(queries[i]);
                if (result != null) {
                    ans[i] = result;
                    continue;
                }
                result = caseWrong.get(queries[i].toLowerCase());
                if (result != null) {
                    ans[i] = result;
                    continue;
                }
                result = vowelWrong.get(queries[i].toLowerCase().replaceAll("a|i|o|u|e", "*"));
                if (result != null) {
                    ans[i] = result;
                    continue;
                }
                ans[i] = "";
            }
            return ans;
        }
    }

    //
    // class Solution {
    // public String[] spellchecker(String[] wordlist, String[] queries) {
    // UniqueTrie trie = new UniqueTrie();
    // trie.addAll(wordlist);
    // String[] ans = new String[queries.length];
    // for (int i = 0; i < queries.length; ++i) {
    // String query = queries[i];
    // String result = searchExcat(trie.head, query);
    // if (result != null) {
    // ans[i] = result;
    // continue;
    // }
    // result = searchLowerUpperCaseWrong(trie.head, query);
    // if (result != null) {
    // ans[i] = result;
    // continue;
    // }
    // result = searchVowelWrong(trie.head, query);
    // if (result != null) {
    // ans[i] = result;
    // continue;
    // }
    // ans[i] = "";
    // }
    // return ans;
    // }
    //
    // public String searchExcat(TrieNode root, String str) {
    // int index = 0;
    // while (root != null && index < str.length()) {
    // if (!root.children.containsKey(str.charAt(index))) {
    // return null;
    // }
    // root = root.children.get(str.charAt(index++));
    // }
    // if (index == str.length() && root.isWord) {
    // return str;
    // }
    // return null;
    // }
    //
    // public String searchLowerUpperCaseWrong(TrieNode root, String str) {
    // Deque<Visit> stack = new LinkedList<>();
    // stack.push(new Visit(root, 0));
    //
    // int minIndex = Integer.MAX_VALUE;
    // String minStr = null;
    //
    // while (!stack.isEmpty()) {
    // Visit v = stack.pop();
    // if (v.index == str.length()) {
    // if (v.node.isWord) {
    // if (v.node.index < minIndex) {
    // minIndex = v.node.index;
    // minStr = v.node.str;
    // }
    // }
    // continue;
    // }
    // char lower = Character.toLowerCase(str.charAt(v.index)),
    // upper = Character.toUpperCase(str.charAt(v.index));
    // if (v.node.children.containsKey(lower)) {
    // stack.push(new Visit(v.node.children.get(lower), v.index + 1));
    // }
    // if (v.node.children.containsKey(upper)) {
    // stack.push(new Visit(v.node.children.get(upper), v.index + 1));
    // }
    // }
    //
    // return minStr;
    // }
    //
    //
    // public boolean isVowel(char ch) {
    // ch = Character.toLowerCase(ch);
    // return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    // }
    //
    // public final static char[] VOWELS = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    //
    // public String searchVowelWrong(TrieNode root, String str) {
    // Deque<Visit> stack = new LinkedList<>();
    // stack.push(new Visit(root, 0));
    //
    // int minIndex = Integer.MAX_VALUE;
    // String minStr = null;
    //
    // while (!stack.isEmpty()) {
    // Visit v = stack.pop();
    // if (v.index == str.length()) {
    // if (v.node.isWord) {
    // if (v.node.index < minIndex) {
    // minIndex = v.node.index;
    // minStr = v.node.str;
    // }
    // }
    // continue;
    // }
    // char ch = str.charAt(v.index);
    // if (!isVowel(ch)) {
    // char lower = Character.toLowerCase(str.charAt(v.index)),
    // upper = Character.toUpperCase(str.charAt(v.index));
    // if (v.node.children.containsKey(lower)) {
    // stack.push(new Visit(v.node.children.get(lower), v.index + 1));
    // }
    // if (v.node.children.containsKey(upper)) {
    // stack.push(new Visit(v.node.children.get(upper), v.index + 1));
    // }
    // } else {
    // for (char vowel : VOWELS) {
    // if (v.node.children.containsKey(vowel)) {
    // stack.push(new Visit(v.node.children.get(vowel), v.index + 1));
    // }
    // }
    // }
    // }
    //
    // return minStr;
    // }
    //
    // static class Visit {
    // TrieNode node;
    // int index;
    //
    // public Visit(TrieNode node, int index) {
    // super();
    // this.node = node;
    // this.index = index;
    // }
    //
    // }
    //
    // static class UniqueTrie {
    //
    // TrieNode head = new TrieNode('\0');
    //
    // Set<String> contains = new HashSet<>();
    //
    // public void add(String str, int index) {
    // if (contains.contains(str)) {
    // return;
    // }
    // TrieNode node = head;
    // for (char ch : str.toCharArray()) {
    // node.children.putIfAbsent(ch, new TrieNode(ch));
    // node = node.children.get(ch);
    // }
    // node.isWord = true;
    // node.index = index;
    // node.str = str;
    // }
    //
    // public void addAll(String[] strs) {
    // for (int i = 0; i < strs.length; ++i) {
    // add(strs[i], i);
    // }
    // }
    //
    // }
    //
    // static class TrieNode {
    // char ch;
    // boolean isWord = false;
    // int index;
    // String str;
    // HashMap<Character, TrieNode> children = new HashMap<>();
    //
    // public TrieNode(char ch) {
    // super();
    // this.ch = ch;
    // }
    // }
    // }



    @Test
    public void test() {
        Solution s = new Solution();
        Assert.assertArrayEquals(new String[] {"a"}, s.spellchecker(new String[] {"a"}, new String[] {"a"}));
        Assert.assertArrayEquals(new String[] {"A"}, s.spellchecker(new String[] {"A"}, new String[] {"a"}));
        Assert.assertArrayEquals(new String[] {"e"}, s.spellchecker(new String[] {"e"}, new String[] {"a"}));
        Assert.assertArrayEquals(new String[] {"a"}, s.spellchecker(new String[] {"e", "a"}, new String[] {"a"}));
        Assert.assertArrayEquals(new String[] {"a"}, s.spellchecker(new String[] {"A", "a"}, new String[] {"a"}));
        Assert.assertArrayEquals(new String[] {"kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe"},
            s.spellchecker(new String[] {"KiTe", "kite", "hare", "Hare"},
                new String[] {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"}));
    }

}
