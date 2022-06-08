package redo.p0200_0299;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import redo.testUtil.BinaryTreeTestUtil;

/**  
 * @ClassName: P297  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2021年2月5日  
 *  
 */
public class P297 {

    static//

    public class Codec {

        static class MyTree implements Serializable {
            private static final long serialVersionUID = 1L;

            int val;
            MyTree left;
            MyTree right;

            MyTree(int val) {
                this.val = val;
            }

            static MyTree valueOf(TreeNode node) {
                if (node == null) {
                    return null;
                }
                MyTree n = new MyTree(node.val);
                n.left = valueOf(node.left);
                n.right = valueOf(node.right);
                return n;
            }

            TreeNode to() {
                TreeNode node = new TreeNode(val);
                if (left != null) {
                    node.left = left.to();
                }
                if (right != null) {
                    node.right = right.to();
                }
                return node;
            }
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return writeObj(MyTree.valueOf(root));
        }

        public String writeObj(Object obj) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oops;
            try {
                oops = new ObjectOutputStream(baos);
                oops.writeObject(obj);
                byte[] bytes = baos.toByteArray();
                return Base64.getEncoder().encodeToString(bytes);
            } catch (IOException e) {
            }
            return null;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            try {
                ByteArrayInputStream bais =
                    new ByteArrayInputStream(Base64.getDecoder().decode(data));

                ObjectInputStream ois = new ObjectInputStream(bais);

                MyTree mytree = (MyTree)ois.readObject();

                return mytree.to();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    @Test
    public void test() {
        Codec s = new Codec();

        Assert.assertEquals("[1,2,3,null,null,4,5]",
            s.deserialize(
                s.serialize(BinaryTreeTestUtil.build("[1,2,3,null,null,4,5]")))
                .toString());
    }

}
