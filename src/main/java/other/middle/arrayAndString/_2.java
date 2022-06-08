package other.middle.arrayAndString;

import java.util.Arrays;

public class _2 {

	class Solution {
	    public void setZeroes(int[][] matrix) {
	    	
	    	if(matrix.length==0||matrix[0].length==0)
	    		return;
	        
	    	//记录第一行是否有0
	    	boolean rowFlag=false;
	    	for(int i=0;i<matrix[0].length;i++){
	    		if(matrix[0][i]==0){
	    			rowFlag=true;
	    			break;
	    		}
	    	}
	    	
	    	//记录第一列是否有0
	    	boolean colFlag=false;
	    	for(int i=0;i<matrix.length;i++){
	    		if(matrix[i][0]==0){
	    			colFlag=true;
	    			break;
	    		}
	    	}
	    	
	    	//由于第一行已经记录是否有0，所以我们可以拿第一行或列来记录本行或本列是否有0
	    	for(int i=1;i<matrix.length;i++){
	    		for(int j=1;j<matrix[0].length;j++){
	    			if(matrix[i][j]==0){
	    				matrix[0][j]=0;
	    				matrix[i][0]=0;
	    			}
	    		}
	    	}
	    	
	    	System.out.println(Arrays.toString(matrix[0]));
	    	
	    	//如果本列第一个数为0，则将本列所有数置为0
	    	for(int i=0;i<matrix[0].length;i++){
	    		if(matrix[0][i]==0){
	    			for(int j=1;j<matrix.length;j++){
	    				matrix[j][i]=0;
	    			}
	    		}
	    	}
	    	
	    	//如果本行第一个数为0，则将本行所有数置为0
	    	for(int i=0;i<matrix.length;i++){
	    		if(matrix[i][0]==0){
	    			for(int j=1;j<matrix[0].length;j++){
	    				matrix[i][j]=0;
	    			}
	    		}
	    	}
	    	
	    	//如果第一行有数为0，则将第一行所有数置为0
	    	if(rowFlag){
	    		for(int i=0;i<matrix[0].length;i++){
		    		matrix[0][i]=0;
		    	}
	    	}
	    	
	    	//如果第一列有数为0，则将第一列所有数置为0
	    	if(colFlag){
	    		for(int i=0;i<matrix.length;i++){
		    		matrix[i][0]=0;
		    	}
	    	}
	    	
	    }
	}
	
}
