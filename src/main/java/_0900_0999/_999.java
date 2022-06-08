package _0900_0999;

public class _999 {

	class Solution {
		int[] dir=new int[]{-1,0,1,0,0,1,0,-1};
	    public int numRookCaptures(char[][] board) {
	    	
	    	int count=0;
	    	
	        l:for(int i=0;i<8;++i)
	        	for(int j=0;j<8;++j)
	        		if(board[i][j]=='R'){
	        			for(int k=0;k<4;++k){
	        				int p=1;
	        				while(true){
	        					int x=i+p*dir[k*2];
	        					int y=j+p*dir[k*2+1];
	        					if(x<0||x==8||y==0||y==8)
	        						break;
	        					if(board[x][y]=='B')
	        						break;
	        					else if(board[x][y]=='p'){
	        						++count;
	        						break;
	        					}
	        					++p;
	        				}
	        			}
	        			break l;
	        		}
	        
	        return count;
	    }
	}
	
}
