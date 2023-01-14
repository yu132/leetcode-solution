package old._0300_0399;

public class _394 {

	class Solution {
	    public String decodeString(String s) {
	    	
	    	return null;
	    }
	}
/*	
		StringBuilder sb=new StringBuilder(s.length()*2);
	    	
	    	boolean getInt=false;
	    	boolean getString=false;
	    	
	    	int times=0;
	    	
	    	int front=0;
	    	
	        for(int i=0;i<s.length();++i){
	        	
	        	char c=s.charAt(i);

	        	if(c>='0'&&c<='9'){
	        		getInt=true;
	        		sb.append(s.substring(front, i));
	        	}
	        	
	        	if(getInt){
	        		if(c>='0'&&c<='9'){
	        			times=times*10+s.charAt(i)-'0';
	        		}else{
	        			getInt=false;
	        			getString=true;
	        			front=i+1;
	        		}
	        	}else if(getString){
	        		if(c==']'){
	        			getString=false;
	        			
	        			String repeat=s.substring(front, i);
	        			
	        			for(int j=0;j<times;++j)
	        				sb.append(repeat);
	        			
	        			times=0;
	        			
	        			front=i+1;
	        		}
	        	}
	        }
	        
	        sb.append(s.substring(front, s.length()));
	        
	        return sb.toString();
	
	*/
}
