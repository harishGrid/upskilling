package com.flyweight;

public class Tree {
	
	public int x;
	public int y;
	private TreeType type;

	
	public Tree() {
		super();
	}
	public Tree(int x, int y,TreeType type) {
		super();
		this.x = x;
		this.y = y;
		this.type=type;
	}
	
	public void draw() {
        type.draw(x, y);
    }

	
}
