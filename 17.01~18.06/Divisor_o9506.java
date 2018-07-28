package algorithm.mid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Divisor_o9506 {

	static public LinkedList<Integer> divisor(int n) {
		LinkedList<Integer> list = new LinkedList<>();
		int sum =0;
		for (int i = 1, bound = n / 2; i <= bound; i++) {
			if(n%i==0) {
				list.add(i);
				sum+=i;
			}
		}
		
		if(n==sum)
			return list;
		else
			return null;
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Integer> tmp;
		int n=0;
		while(true) {
			n=Integer.parseInt(br.readLine());
			if(n==-1)
				break;
			
			tmp = divisor(n);
			if(tmp==null)
				bw.write(n+" is NOT perfect.\n");
			else {
				bw.write(n+" = ");
				for(int i=0;i<tmp.size();i++) {
					if(i==tmp.size()-1) {
						bw.write(tmp.get(i)+"\n");
						break;
					}
					bw.write(tmp.get(i)+" + ");
				}
			}
		}
		
		bw.flush();
	}
}
