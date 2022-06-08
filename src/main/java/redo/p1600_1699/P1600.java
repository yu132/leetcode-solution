package redo.p1600_1699;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**  
 * @ClassName: P1600  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年1月3日  
 *  
 */
public class P1600 {

    static//

    class ThroneInheritance {

        private Node familyTree;

        private Map<String, Node> mapping = new HashMap<>();

        public ThroneInheritance(String kingName) {
            familyTree = new Node(kingName);
            mapping.put(kingName, familyTree);
        }

        public void birth(String parentName, String childName) {
            Node node = mapping.get(parentName);
            Node childNode = new Node(childName);
            node.children.add(childNode);
            mapping.put(childName, childNode);
        }

        public void death(String name) {
            mapping.get(name).death = true;
        }

        public List<String> getInheritanceOrder() {
            List<String> ans = new ArrayList<>();
            preorder(familyTree, ans);
            return ans;
        }

        public void preorder(Node node, List<String> ans) {
            if (node == null) {
                return;
            }
            if (!node.death) {
                ans.add(node.name);
            }
            for (Node child : node.children) {
                preorder(child, ans);
            }
        }

        static class Node {
            String name;
            boolean death = false;
            List<Node> children = new ArrayList<>();

            public Node(String name) {
                super();
                this.name = name;
            }
        }
    }

}
