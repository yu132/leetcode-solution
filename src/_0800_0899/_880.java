/**
 * @Title: _880.java
 *
 * @Package _0800_0899
 *
 * @Description: TODO(用一句话描述该文件做什么)
 *
 * @author 余定邦
 *
 * @date 2020年1月31日
 *
 */
package _0800_0899;

/**  
 * @ClassName: _880  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年1月31日  
 *  
 */
public class _880 {

    class Solution {

        private class Node {

            Node front;

            String back;

            long repeatTime;

            long len;

        }

        private Node build(String S) {
            int  from = 0, to = 0;
            Node node = null;

            for (int i = 0; i < S.length();) {

                while (i < S.length() && S.charAt(i) >= 'a') {
                    ++to;
                    ++i;
                }

                long repeat = 1;
                while (i < S.length() && S.charAt(i) <= '9') {
                    repeat *= S.charAt(i) - '0';
                    ++i;
                }

                Node nNode = new Node();
                nNode.front      = node;
                nNode.back       = S.substring(from, to);
                nNode.repeatTime = repeat;
                nNode.len        = ((node == null ? 0 : node.len) + nNode.back.length()) * nNode.repeatTime;
                from             = i;
                to               = i;
                node             = nNode;
            }

            return node;
        }

        private char Search(Node node, int K) {
            long timeLen = node.len / node.repeatTime;
            while (K > timeLen) {
                K -= timeLen;
            }
            if (node.front == null) {// 最内部的节点
                return node.back.charAt(K - 1);
            } else {
                if (K <= node.front.len) {
                    return Search(node.front, K);
                } else {
                    return node.back.charAt((int)(K - node.front.len - 1));
                }
            }
        }


        public String decodeAtIndex(String S, int K) {
            Node node = build(S);
            return String.valueOf(Search(node, K));
        }
    }

    public static void main(String[] args) {
        System.out.println(new _880().new Solution().decodeAtIndex("leet2code3", 20));
    }

}
