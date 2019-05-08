package other.middle.tree;

public class _6 {

	class Solution {
	    public int numIslands(char[][] grid) {
	        int count=0;
	        
	        for(int i=0;i<grid.length;i++){
	        	for(int j=0;j<grid[0].length;j++){
	        		if(dfs(grid,i,j))
	        			count++;
	        	}
	        }
	        
	        return count;
	    }
	    
	    public boolean dfs(char[][] grid,int i,int j){
	    	if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
	    		return false;
	    	
	    	if(grid[i][j]=='1'){
	    		grid[i][j]='2';
	    		
	    		dfs(grid,i+1,j);
	    		dfs(grid,i-1,j);
	    		dfs(grid,i,j+1);
	    		dfs(grid,i,j-1);
	    		
	    		return true;
	    	}else
	    		return false;
	    }
	}
	
}
