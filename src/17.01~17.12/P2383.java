import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Stair {
	int x;
	int y;
	int length;
	int now;

	public Stair(int x, int y, int length, int now) {
		super();
		this.x = x;
		this.y = y;
		this.length = length;
		this.now = now;
	}

}

public class Solution {
	
	static int minute=Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[][] board = new int[n][n];

			int people = 0;
			int flag = 0;
			Stair[] stair = new Stair[2];

			for (int a = 0; a < n; a++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int b = 0; b < n; b++) {
					int tmp = Integer.parseInt(st.nextToken());
					board[a][b] = tmp;

					if (tmp == 1)
						people++;
					else if (tmp > 1) {
						stair[flag] = new Stair(b, a, tmp, 0);
						flag++;
					}

				}
			}

			int[][] dis_people = new int[people][2]; // [0] 사람과 계단 1과의 거리, [1] 사람과 계단 2와의 거리
			int x = 0;
			// solve

			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					if (board[a][b] == 1) {
						dis_people[x][0] = cal_dis(b, a, stair[0].x, stair[0].y);
						dis_people[x][1] = cal_dis(b, a, stair[1].x, stair[1].y);
						x++;
					}
				}
			}

			choiceStair(new LinkedList<Integer>(), new LinkedList<Integer>(), 0, people, stair[0].length, stair[1].length, dis_people);// dfs

			// print
			bw.write("#"+i+" "+minute);
			bw.newLine();
			minute=Integer.MAX_VALUE;
		}
		
		bw.flush();
	}

	private static int cal_dis(int px, int py, int dx, int dy) {
		int sum = minusAbs(px, dx) + minusAbs(py, dy);
		return sum;
	}

	private static int minusAbs(int x, int y) {
		if (x > y)
			return x - y;
		else
			return y - x;

	}

	private static void choiceStair(LinkedList<Integer> s1, LinkedList<Integer> s2, int now, int n, int s1_length, int s2_length, int[][] dis_people) {
		if (now == n) {

			LinkedList<Integer> c1 = new LinkedList<>();
			LinkedList<Integer> c2 = new LinkedList<>();
			
			
			//사람 - 계단 거리로 치환 
			
			for(int i=0;i<s1.size();i++) {
				c1.add(dis_people[s1.get(i)][0]);
			}
			
			for(int i=0;i<s2.size();i++) {
				c2.add(dis_people[s2.get(i)][1]);
			}
			
			
			int a1 = stairTimer(c1,s1_length);
			int a2 = stairTimer(c2,s2_length);
			

			if(a1>a2) {
				
				if(minute>a1)
					minute=a1;
			}else {
				if(minute>a2)
					minute=a2;
			}

			return;
		}

		s1.add(now);
		choiceStair(s1, s2, now + 1, n, s1_length, s2_length, dis_people);
		s1.removeLast();

		s2.add(now);
		choiceStair(s1, s2, now + 1, n, s1_length, s2_length, dis_people);
		s2.removeLast();

	}

	private static int stairTimer(LinkedList<Integer> p, int stairLength) {
		int time = 0;
		
		
		
		

		LinkedList<Integer> stair = new LinkedList<>();
		
		while (!p.isEmpty() || !stair.isEmpty()) {

			time++;
			
			for(int i=0;i<stair.size();i++) { //계단에 있는 사람이 밑으로 이동 
				if(stair.get(i)==0) {
					stair.remove(i--);
				}else {
					int tmp = stair.remove(i) - 1;
					stair.add(i, tmp);
				}
			}
			
			
			
			for (int i = 0; i < p.size(); i++) { //사람이 계단으로 이동 
				if (p.get(i) == 1) {
					
					if(stair.size()<3) {
						p.remove(i--);
						stair.add(stairLength);
					}
					
					
				} else {
					int tmp = p.remove(i) - 1;
					p.add(i, tmp);
				}

			}
			
			
			
			
			
			
			
		}

		return time;
	}

}
