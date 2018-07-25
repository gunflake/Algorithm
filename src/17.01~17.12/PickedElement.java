package book;

import java.util.LinkedList;

public class PickedElement {
	
	public void pick(int n, LinkedList<Integer> picked, int toPick) {
		if(toPick==0) {
			printList(picked);
			return;
		}
		
		int smallist = picked.isEmpty() ? 0 : picked.getLast()+1;
		
		for(int i=smallist;i<=n;i++) {
			picked.add(i);
			pick(n, picked, toPick-1);
			picked.removeLast();
		}
		
	}
	
	public void printList(LinkedList<Integer> stack) {
		for(int i=0;i<stack.size();i++)
			System.out.print(stack.get(i));
		System.out.println();
	}
	
	public static void main(String[] args) {
		PickedElement p = new PickedElement();
		
		LinkedList<Integer> list = new LinkedList<>();
		p.pick(7, list, 4);
		
		
		
	}

}
