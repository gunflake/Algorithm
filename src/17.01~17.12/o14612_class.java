package july;

import java.util.LinkedList;
import java.util.Scanner;

public class o14612_class {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int queryCount = sc.nextInt();
		int tableCount = sc.nextInt();

		OrderKim kim = new OrderKim();
		
		sc.skip("[\\r\\n]+");

		int [][] orderSequence = new int[queryCount][2];

		String[] query = new String[queryCount];

		for (int i = 0; i < queryCount; i++) {
			query[i] = sc.nextLine();
		}

		for (int i = 0; i < queryCount; i++) {
			String[] split = query[i].split(" ");

			if (split[0].equals("sort")) {
				kim.sort();
			} 
			if (split[0].equals("complete")) {
				kim.complete(Integer.parseInt(split[1]));
			} 
			if (split[0].equals("order")) {
				kim.order(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
			}

		}
	}
}


class OrderKim{
	
	private LinkedList<Integer>[] sequence;
	
	public OrderKim() {
		sequence = new LinkedList[2];
		sequence[0] = new LinkedList<>();
		sequence[1] = new LinkedList<>();
	}
	
	public void order(int tableNum, int orderTime) {
		sequence[0].add(tableNum);
		sequence[1].add(orderTime);

		print();
	}

	public void sort() {
		int temp1, temp, indexmin, temp3;

		for (int i = 0; i < sequence[0].size(); i++) {

			indexmin = i;

			for (int j = i + 1; j < sequence[0].size(); j++) {
				if (sequence[1].get(j) < sequence[1].get(indexmin)) {
					indexmin = j;
				}
				
				if(sequence[1].get(i)==sequence[1].get(j)) {
					if(sequence[0].get(i)>sequence[0].get(j)) {
						temp3=sequence[0].get(i);
						sequence[0].set(i, sequence[0].get(j));
						sequence[0].set(j, temp3);
					}
				}
				
			}

			temp = sequence[1].get(indexmin);
			sequence[1].set(indexmin, sequence[1].get(i));
			sequence[1].set(i, temp);

			temp1 = sequence[0].get(indexmin);
			sequence[0].set(indexmin, sequence[0].get(i));
			sequence[0].set(i, temp1);

		}
		
		print();
	}

	public void complete(int tableNum) {

		for (int i = 0; i < sequence[0].size(); i++) {
			if (tableNum == sequence[0].get(i)) {
				sequence[0].remove(i);
				sequence[1].remove(i);
				break;
			}
		}

		print();
	}

	public void print() {
		for (int i = 0; i < sequence[0].size(); i++)
			System.out.print(sequence[0].get(i) + " ");

		if (sequence[0].size() != 0)
			System.out.println();

		if (sequence[0].size() == 0)
			System.out.println("sleep");
	}
	
}
