package old._0900_0999;

public class _994 {

	class Solution {
	    public int orangesRotting(int[][] grid) {
	        for(int i=0;i<grid.length;++i)
	        	for(int j=0;j<grid[0].length;++j)
	        		if(grid[i][j]==2){
	        			dfs(grid,i+1,j,3);
	        	    	dfs(grid,i-1,j,3);
	        	    	dfs(grid,i,j+1,3);
	        	    	dfs(grid,i,j-1,3);
	        		}
	        
	        int max=2;
	        boolean flag=false;
	        for(int i=0;i<grid.length;++i)
	        	for(int j=0;j<grid[0].length;++j)
	        		if(grid[i][j]==1){
	        			flag=true;
	        			break;
	        		}else if(grid[i][j]>=2)
	        			max=Math.max(grid[i][j], max);
	        
	        return flag?-1:max-2;
	    }
	    
	    public void dfs(int[][] grid,int x,int y,int level){
	    	
	    	if(x<0||x>=grid.length||y<0||y>=grid[0].length)
	    		return;
	    	
	    	if(grid[x][y]==0)
	    		return;
	    	
	    	if(grid[x][y]==1)
	    		grid[x][y]=level;
	    	else{
	    		if(grid[x][y]<=level)
	    			return;
	    		else
	    			grid[x][y]=level;
	    	}
	    	
	    	dfs(grid,x+1,y,level+1);
	    	dfs(grid,x-1,y,level+1);
	    	dfs(grid,x,y+1,level+1);
	    	dfs(grid,x,y-1,level+1);
	    }
	}
	
}
