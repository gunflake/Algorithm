import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {

		boolean [] number = new boolean[1000001];

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=2;i<=1000000;i++) {
			
			if(!number[i]) {
				bw.write(""+i+" ");
				
				for(int j=i;j<=1000000;j+=i) {
					number[j]=true;
				}
			}
			
		}
		bw.flush();
		
	}
	
	

}
