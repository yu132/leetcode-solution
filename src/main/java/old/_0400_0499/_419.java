package old._0400_0499;

public class _419 {

	class Solution {
	    public int countBattleships(char[][] board) {
	        
	    	int count=0;
	    	
	    	for(int i=0;i<board.length;++i){
	    		for(int j=0;j<board[0].length;++j){
	    			if(board[i][j]=='X'){
	    				if(i>=1&&board[i-1][j]=='X');
	    				else if(j>=1&&board[i][j-1]=='X');
	    				else
	    					++count;
	    			}
	    		}
	    	}
	    	
	    	return count;
	    }
	}
	
}
