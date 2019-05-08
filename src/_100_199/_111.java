package _100_199;

import java.util.ArrayDeque;
import java.util.Queue;

import model.TreeNode;

public class _111 {

	class Solution {//bfs
	    public int minDepth(TreeNode root) {
	    	if(root==null)
	    		return 0;
	        
	    	Queue<TreeNode> q=new ArrayDeque<>();
	    	
	    	q.offer(root);
	    	int level=1;
	    	int levelCount=1;
	    	int nextLevelCount=0;
	    	
	    	while(!q.isEmpty()){
	    		TreeNode node=q.poll();
	    		
	    		--levelCount;
	    		
	    		if(node.left==null&&node.right==null)
	    			return level;
	    		
	    		if(node.left!=null){
	    			q.offer(node.left);
	    			++nextLevelCount;
	    		}if(node.right!=null){
	    			q.offer(node.right);
	    			++nextLevelCount;
	    		}
	    		
	    		if(levelCount==0){
	    			++level;
	    			levelCount=nextLevelCount;
	    			nextLevelCount=0;
	    		}
	    	}
	    	
	    	throw new IllegalArgumentException();
	    }
	}
	
}
