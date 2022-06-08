package redo.p0400_0499;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**  
 * @ClassName: P460  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月22日  
 *  
 */
public class P460 {

    // class LFUCache {
    //
    // int nodesNum = 0;
    //
    // Map<Integer, Node> map = new HashMap<>();
    // Map<Integer, LinkedList<Node>> freq = new HashMap<>();
    //
    // int minFeq = 0;
    //
    // int k;
    //
    // public LFUCache(int capacity) {
    // k = capacity;
    // }
    //
    // public int get(int key) {
    // if (k == 0) {
    // return -1;
    // }
    // if (!map.containsKey(key)) {
    // return -1;
    // }
    // plus1(key);
    // return map.get(key).val;
    // }
    //
    // public void put(int key, int value) {
    // if (k == 0) {
    // return;
    // }
    // if (map.containsKey(key)) {
    // map.get(key).val = value;
    // plus1(key);
    // } else {
    // if (nodesNum < k) {
    // addKey(key, value);
    // ++nodesNum;
    // } else {
    // removeLowFrqKey();
    // addKey(key, value);
    // }
    // }
    // }
    //
    // void removeLowFrqKey() {
    // Node toRemove = freq.get(minFeq).pollLast();
    // if (freq.get(minFeq).size() == 0) {
    // freq.remove(minFeq);
    // }
    // map.remove(toRemove.key);
    // }
    //
    // void addKey(int key, int val) {
    // Node node = new Node();
    // node.key = key;
    // node.val = val;
    // node.times = 1;
    // map.put(key, node);
    //
    // minFeq = 1;
    // freq.computeIfAbsent(minFeq, (x) -> new LinkedList<>())
    // .addFirst(node);
    // }
    //
    // void plus1(int key) {
    // Node node = map.get(key);
    //
    // if (node.times != 0) {
    // System.out.println(freq.get(node.times).remove(node));
    //
    // if (freq.get(node.times).size() == 0) {
    // freq.remove(node.times);
    // if (node.times == minFeq) {
    // ++minFeq;
    // }
    // }
    //
    // ++node.times;
    //
    // freq.computeIfAbsent(node.times, (x) -> new LinkedList<>())
    // .addFirst(node);
    // }
    // }
    //
    // class Node {
    // int times;
    // int key;
    // int val;
    // }
    //
    // int[] toArray(List<Integer> list) {
    // int[] arr = new int[list.size()];
    // for (int i = 0; i < list.size(); ++i) {
    // arr[i] = list.get(i);
    // }
    // return arr;
    // }
    // }



    // @Test
    // public void test() {
    // LFUCache s = new LFUCache(2);
    // s.put(1, 1);
    // assertEquals(1, s.get(1));
    // s.put(2, 2);
    // assertEquals(1, s.get(1));
    // s.put(3, 3);
    // assertEquals(-1, s.get(2));
    // }

}
