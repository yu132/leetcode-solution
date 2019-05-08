package _0_99;

public class _14 {

	 public String longestCommonPrefix(String[] strs) {
		 
		 if(strs.length==0)
			 return "";
		 
		 if(strs.length==1)
			 return strs[0];
		 
		 int min=Integer.MAX_VALUE;
		 for(int i=0;i<strs.length;i++)
			 if(strs[i].length()<min)
				 min=strs[i].length();
		 
		 StringBuilder sb=new StringBuilder(min);
		 
		 for(int i=0;i<min;i++){
			 char x=strs[0].charAt(i);
			 boolean flag=true;
			 for(int j=1;j<strs.length;j++){
				 if(strs[j].charAt(i)!=x){
					 flag=false;
					 break;
				 }
			 }
			 if(flag)
				 sb.append(x);
			 else
				 break;
		 }
		 
		 return sb.toString();
	 }
	
}
