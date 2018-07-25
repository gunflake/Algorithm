package nhn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2 {

	public String encrypt(String secretKey, String messge, int rotate) {
		
		String changeMsg="";
		for (int i = 0; i < secretKey.length(); i++) {
			int s, m, c;
			s = (int)(secretKey.charAt(i)-'a');
			m = (int)(messge.charAt(i)-'a');
			c=s+m;
			
			if(c>25) {
				c%=26;
			}
			changeMsg+=(char)('a'+c);
		}
		
		int msgLength = changeMsg.length();
		
		if(rotate>msgLength)
			rotate%=msgLength;
		
		String first="";
		String second="";
		
		first=changeMsg.substring(0, rotate);
		second=changeMsg.substring(rotate,msgLength);
		
		return second+first;
	}
	
public String decrypt(String secretKey, String messge, int rotate) {
		
		String changeMsg="";
		String resultMsg="";
		int msgLength = messge.length();
		String first="";
		String second="";
		
		first=messge.substring(0, msgLength-rotate);
		second=messge.substring(msgLength-rotate,msgLength);
			
		
		for (int i = 0; i < secretKey.length(); i++) {
			int s, m, c;
			m = (int)(changeMsg.charAt(i)-'a');
			s = (int)(secretKey.charAt(i)-'a');
			c=m-s;
			
			if(c<0) {
				c+=26;
			}
			
			resultMsg+=(char)('a'+c);
		}
		
		return resultMsg;
	}
	
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		String condition = st.nextToken();
		String secretKey = st.nextToken();
		int rotate = Integer.parseInt(st.nextToken());
		String messge = st.nextToken();
		
		P2 p = new P2();
		
		if(condition.equals("encrypt"))
			System.out.println(p.encrypt(secretKey, messge, rotate));
		else if(condition.equals("decrypt")) {
			System.out.println(p.decrypt(secretKey, messge, rotate));
			
		}
		
	}

}
