package _600_699;

import model.TreeNode;

public class _606 {

	class Solution {
		
		private StringBuilder sb=new StringBuilder();
		
		public void level(TreeNode t) {
			if(t==null) {
				return;
			}
			sb.append("(");
			sb.append(t.val);
			if(t.left!=null) {
				level(t.left);
				level(t.right);
			}else {
				if(t.right!=null) {
					sb.append("()");
					level(t.right);
				}
			}
			sb.append(")");
		}
		
	    public String tree2str(TreeNode t) {
	    	if(t==null) {
				return "";
			}
	    	sb.append(t.val);
			if(t.left!=null) {
				level(t.left);
				level(t.right);
			}else {
				if(t.right!=null) {
					sb.append("()");
					level(t.right);
				}
			}
	    	return sb.toString();
	    }
	}
	
}
