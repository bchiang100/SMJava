package classwork;

import java.util.Currency;

public class LinkedList<Q> {
	int size = 0;
	
	private class Node {
		Q info;
		Node next;
		public Node(Q i, Node n) {
			info = i;
			next = n;
		}
	}
	
	private Node head = null;
	
	public void add(Q info) {
		Node newNode = new Node(info, null);
		if (head == null) {
			head = newNode;
		} else {
			Node curr = head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
		}
		size+=1;
	}
	
	public void add(Q info, int i) {
		try {
			Node curr = head;
			if (i == 0) {
				Node newNode = new Node(info, null);
				if (head == null) {
					head = newNode;
				} else {
					head = new Node(info, head);
				}
			} else {
				for (int j = 0; j < i - 1; j++) {
					curr = curr.next;
				}
				curr.next = new Node(info, null);
			}
			size+=1;
		}
		catch (NullPointerException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public Q get(int i) {
		try {
			Node curr = head;
			for (int j = 0; j < i;j++) {
				curr = curr.next;
			}
			return curr.info;
		}
		catch (NullPointerException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public Q remove(int i) {
		try {
			Q storedInfo;
			if (i == 0) {
				storedInfo = head.info;
				head = head.next;
			} else {
				Node curr = head;
				for (int j = 0; j < i-1; j++) {
					curr = curr.next;
				}
				storedInfo = curr.next.info;
				curr.next = curr.next.next;
			}
			size-=1;
			return storedInfo;
			}
		catch (NullPointerException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public int size() {
		return size;
	}
	
	public String toString() {
		String output = "";
		Node curr = head;
		while (curr != null) {
			output += curr.info.toString() + " -> ";
			curr = curr.next;
		}
		return output;
	}
	public static void main(String [] args) {
		LinkedList runner = new LinkedList();
		runner.add(5);
		runner.add(6,1);
		runner.add(2);
		System.out.println(runner);
	}
}
