package algorithm.mid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Star8_o2445 {
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		solve(n);
		bw.flush();
	}

	private static void solve(int n) throws IOException {
		for(int i=1;i<n;i++) {
			printStar(n,i);
		}
		
		for(int i=n;i>=1;i--) {
			printStar(n,i);
		}
		
	}

	private static void printStar(int n, int printCount) throws IOException {

		int gap = n-printCount;
		
		
		//left
		for(int i=0;i<printCount;i++)
			bw.write("*");
		
		for(int i=0;i<gap;i++) {
			bw.write(" ");
		}
		
		//right
		for(int i=0;i<gap;i++) {
			bw.write(" ");
		}
		for(int i=0;i<printCount;i++)
			bw.write("*");
		
		bw.write("\n");
		
	}

}
