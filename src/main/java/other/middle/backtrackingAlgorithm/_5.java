package other.middle.backtrackingAlgorithm;

public class _5 {

	class Solution {
	    public boolean exist(char[][] board, String word) {
	    	
	    	char[] chs=word.toCharArray();
	    	boolean[][] flag=new boolean[board.length][board[0].length];
	    	
	    	for(int i=0;i<board.length;i++){
	    		for(int j=0;j<board[0].length;j++){
	    			if(dfs(board,chs,flag,0,i,j))
	    				return true;
	    		}
	    	}
	    	
	    	return false;
	    }
	    
	    public boolean dfs(char[][] board,char[] word,boolean[][] flag,int index,int i,int j){
	    	
	    	if(index>=word.length)
	    		return true;
	    	
	    	if(i<0 || i>=board.length || j<0 || j>=board[0].length)
	    		return false;
	    	
	    	if(flag[i][j])
	    		return false;
	    	
	    	if(board[i][j]!=word[index])
	    		return false;
	    	
	    	System.out.println(board[i][j]+" "+word[index]);
	    	
	    	flag[i][j]=true;
	    	
	    	if(dfs(board,word,flag,index+1,i+1,j)
	    			||dfs(board,word,flag,index+1,i-1,j)
	    			||dfs(board,word,flag,index+1,i,j+1)
	    			||dfs(board,word,flag,index+1,i,j-1)){
	    		
	    		flag[i][j]=false;
	    		
	    		return true;
	    	}
	    	
	    	flag[i][j]=false;
	    	
	    	return false;
	    }
	}
	
}
