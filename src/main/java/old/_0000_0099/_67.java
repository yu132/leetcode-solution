package old._0000_0099;

public class _67 {
	
	public String addBinary(String a, String b) {
        
		int l;
		int f=a.length()-b.length();
		
		char[] ans;
		
		if(f>=0){
			l=a.length();
			ans=new char[a.length()];
		}else{
			l=b.length();
			ans=new char[b.length()];
		}
		int p1=0;
		
		for(int i=0;i<l;i++){
			int res=((a.length()-1-i)>=0?a.charAt(a.length()-1-i):'0')+((b.length()-1-i)>=0?b.charAt(b.length()-1-i):'0')-'0'*2+p1;
			if(res==3){
				p1=1;
				ans[l-1-i]='1';
			}else if(res==2){
				p1=1;
				ans[l-1-i]='0';
			}else if(res==1){
				p1=0;
				ans[l-1-i]='1';
			}else{
				p1=0;
				ans[l-1-i]='0';
			}
		}
		
		if(p1==1){
			return '1'+new String(ans);
		}else
			return new String(ans);
		
    }
	
	
	public static void main(String[] args) {
		System.out.println(new _67().addBinary("1", "111"));
	}

}
