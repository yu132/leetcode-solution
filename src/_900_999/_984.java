package _900_999;

public class _984 {

	class Solution {
	    public String strWithout3a3b(int A, int B) {
	    	
	    	StringBuilder sb=new StringBuilder(A+B);
	    	
	        char more,less;
	        int Cmore,Cless;
	        
	        if(A>=B){
	        	more='a';
	        	less='b';
	        	Cmore=A;
	        	Cless=B;
	        }else{
	        	more='b';
	        	less='a';
	        	Cmore=B;
	        	Cless=A;
	        }
	        
	        while(Cmore>=0||Cless>=0){
	        	if(Cmore>Cless){
	        		if(Cmore>=2){
	        			sb.append(more).append(more);
	        			Cmore-=2;
	        		}else{
	        			sb.append(more);
	        			--Cmore;
	        		}
	        		
	        		if(Cless-->=1){
	        			sb.append(less);
	        		}
	        	}else{
	        		sb.append(more);
	        		--Cmore;
	        		sb.append(less);
	        		--Cless;
	        	}
	        }
	        
	        return sb.toString();
	    }
	}
	
}
