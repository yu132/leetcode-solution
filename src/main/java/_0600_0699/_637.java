package _0600_0699;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class _637 {
	
	class Solution {
		
		private List<Double> sum=new ArrayList<>();
		
		private List<Integer> count=new ArrayList<>();
		
		public void level(TreeNode root,int level) {
			if(root==null) {
				return;
			}
			
			if(sum.size()==level) {
				sum.add(0d);
				count.add(0);
			}
			
			sum.set(level, sum.get(level)+root.val);
			count.set(level, count.get(level)+1);
			
			level(root.left,level+1);
			level(root.right,level+1);
		}
		
	    public List<Double> averageOfLevels(TreeNode root) {
	        level(root,0);
	    	
	    	for(int i=0;i<sum.size();++i) {
	    		sum.set(i, sum.get(i)/count.get(i));
	    	}
	    	
	    	return sum;
	    }
	}
	
}
