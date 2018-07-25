package kakao;

public class P1 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		int [] bit = new int[n];
		String [] bitString = new String[n];
		
		for(int i=0;i<n;i++) {
			bit[i]=arr1[i] | arr2[i];
			bitString[i] = Integer.toBinaryString(bit[i]);
		}
		
		for(int i=0;i<n;i++) {
			answer[i]=changeS(bitString[i], n);
		}
		
		
		
		for(int i=0;i<n;i++) 
			System.out.println(answer[i]);

		return answer;
	}
	
	
	public String changeS(String a, int n) {
		String result = "";
		
		int tmp=a.length();
		while(tmp<n) {
			result+=" ";
			tmp++;
		}
			
		for(int i=0;i<a.length();i++) {
			if(a.charAt(i)=='1')
				result=result+"#";
			else if(a.charAt(i)=='0')
				result=result+" ";
		}
		
		return result;
	}
	

	public static void main(String[] args) {
		P1 p1 = new P1();
		int [] a1 = {46, 33, 33 ,22, 31, 50};
		int [] a2 = {27 ,56, 19, 14, 14, 10};
		
		p1.solution(6, a1, a2);
	}

}
