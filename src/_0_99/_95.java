package _0_99;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.TreeNode;

public class _95 {
	
	class Solution {
		public List<TreeNode> generateTrees(int f,int e){
			
			if(f>e)
				return null;
			
			List<TreeNode> l=new ArrayList<>();
			
			if(f==e){
				TreeNode t=new TreeNode(f);
				l.add(t);
				return l;
			}
			
			for(int i=f;i<=e;i++){
				
				List<TreeNode> nextLeft=generateTrees(f,i-1);
				List<TreeNode> nextRight=generateTrees(i+1,e);
				
				System.out.println(f+" "+i+" "+e);
				
				if(nextLeft==null){
					
					for(int j=0;j<nextRight.size();j++){
						TreeNode t=new TreeNode(i);
						
						t.left=null;
						t.right=nextRight.get(j);
						
						l.add(t);
					}
					
				}else if(nextRight==null){
					
					for(int j=0;j<nextLeft.size();j++){
						
						TreeNode t=new TreeNode(i);
						
						t.left=nextLeft.get(j);
						t.right=null;
						
						l.add(t);
					}
					
				}else{
					
					for(int j=0;j<nextLeft.size();j++){
						for(int k=0;k<nextRight.size();k++){
							
							TreeNode t=new TreeNode(i);
							
							t.left=nextLeft.get(j);
							t.right=nextRight.get(k);
							
							l.add(t);
						}
					}
					
				}
			}
			
			return l;
		}
		
	    public List<TreeNode> generateTrees(int n) {
	    	
	    	if(n==0){
	    		return Collections.emptyList();
	    	}
	    	
	        return generateTrees(1,n);
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(new _95().new Solution().generateTrees(3));
	}
}
