package september;


public class Caesar {
	
	public String caesar(String s, int n) {
		String result = "";
		char tmp;
		n%=26;
		for(int i=0;i<s.length();i++) {
			tmp=s.charAt(i); //char 하나 가지고온다
			if(checkCase(tmp)==1)
				result=result+lowerCase(tmp, n);
			else if(checkCase(tmp)==2)
				result=result+upperCase(tmp, n);
			else
				result+=" ";
		}
		return result;
	}
	
	public int checkCase(char a) { //1이면 소문자  2이면 대문자 3이면 아무것도 아님 
		if(a>='a' && a<='z')
			return 1;
		else if(a>='A' && a<='Z')
			return 2;
		else
			return 3;
	}
	
	public char lowerCase(char alpha, int n) {
		if(alpha+n>'z') 
			alpha+=(n-26);
		else
			alpha+=n;
		return alpha;
	}
	
	public char upperCase(char alpha, int n) {
		if(alpha+n>'Z') 
			alpha+=(n-26);
		else
			alpha+=n;
		return alpha;
	}

	public static void main(String[] args) {
		Caesar c = new Caesar();
		
		System.out.println("s는 'a B z', n은 4인 경우: " + c.caesar("HSVBrTKhNFiWHzQ G ACrxw tyFexsvn xzg PSw RGiudLmPc",49));
	}
}
