package old._0200_0299;

import model.TreeNode;

public class _235 {
/* v1
	class Solution {
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root==null)
	        	return null;
	        
	        if(root==p){
	        	if(q.val<root.val){
	        		if(lowestCommonAncestor(root.left, p, q)==q){
	        			return root;
	        		}else{
	        			return p;
	        		}
	        	}else{//>
	        		if(lowestCommonAncestor(root.right, p, q)==q){
	        			return root;
	        		}else{
	        			return p;
	        		}
	        	}
	        }else if(root==q){
	        	if(p.val<root.val){
	        		if(lowestCommonAncestor(root.left, p, q)==p){
	        			return root;
	        		}else{
	        			return q;
	        		}
	        	}else{//>
	        		if(lowestCommonAncestor(root.right, p, q)==p){
	        			return root;
	        		}else{
	        			return q;
	        		}
	        	}
	        }else{
	        	int temp1=p.val-root.val;
	        	int temp2=q.val-root.val;
	        	
	        	if(temp1>0&&temp2>0)
	        		return lowestCommonAncestor(root.right, p, q);
	        	else if(temp1<0&&temp2<0)
	        		return lowestCommonAncestor(root.left, p, q);
	        	else{
	        		TreeNode leftnode=lowestCommonAncestor(root.left, p, q);
	        		TreeNode rightnode=lowestCommonAncestor(root.right, p, q);
	        		
	        		boolean flagP=false,flagQ=false;
	        		if(leftnode==p||rightnode==p)
	        			flagP=true;
	        		if(leftnode==q||rightnode==q)
	        			flagQ=true;
	        		
	        		if(flagP&&flagQ)
	        			return root;
	        		if(flagP)
	        			return p;
	        		if(flagQ)
	        			return q;
	        		
	        		return null;
	        	}
	        }
	    }
	}*/
	
	class Solution {
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if (root == null) {
	            return null;
	        }
	        if (p.val > root.val && q.val > root.val) {
	            return lowestCommonAncestor(root.right, p, q);
	        } else if (p.val < root.val && q.val < root.val) {
	            return lowestCommonAncestor(root.left, p, q);
	        } else {
	            return root;
	        }
	    }
	}
	
}
