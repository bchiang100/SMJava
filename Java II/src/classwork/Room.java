package classwork;

import java.util.ArrayList;

public class Room {
	String name;
	int length;
	int width;
	int height;
	ArrayList<Integer> amount = new ArrayList<Integer>();
	ArrayList<Material> material = new ArrayList<Material>();
	public Room(String name, int length, int width, int height, ArrayList<Integer> amount) {
		this.name = name;
		this.length = length;
		this.width = width;
		this.height = height;
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		int price = 0;
		for (int i = 0; i < material.size(); i++) {
			price += material.get(i).getPrice() * amount.get(i);
		}
		return price;
	}
	public int getVolume() {
		return length * width * height;
	}
	public int squareFootage() {
		return length * width;
	}
	public void renovate(String n, int l, int w, int h, ArrayList<Material> m) {
		name = n;
		length = l;
		width = w;
		height = h;
		material = m;
	}
}
