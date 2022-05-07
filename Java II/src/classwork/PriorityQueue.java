package classwork;

import java.util.ArrayList;

public class PriorityQueue<T> {
	private class Bundle{
		T element;
		int priority;
		
		public Bundle(T e, int p) {
			element = e;
			priority = p;
		}
		ArrayList<Bundle> queue = new ArrayList<Bundle>();
		public void push(T info, int p) {
			for (int i = 0; i < queue.size(); i++) {
				if (queue.get(i).priority < p) {
					queue.add(i ,new Bundle(info, p));
					return;
				}
			}
			queue.add(new Bundle(info, p));
		}
		public T pop() {
			return queue.remove(0).element;
		}
		public int size() {
			return queue.size();
		}
		public String toString() {
			String str = "";
			for (int i = 0; i < queue.size(); i++) {
				str += queue.get(i).element + " and " + queue.get(i).priority + " | ";
			}
			return str;
		}
	}
	public static void main(String [] args) {
		PriorityQueue runner = new PriorityQueue();
		//
		
		
	}
}
