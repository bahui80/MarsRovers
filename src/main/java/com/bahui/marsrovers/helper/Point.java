package com.bahui.marsrovers.helper;

public class Point {
	private int x;
	private int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Point addPoint(Point p) {
		return new Point(p.getX() + x, p.getY() + y);
	}
	
	public boolean checkPointWithin(Point lowerLeft, Point upperRight) {
		return x >= lowerLeft.getX() && x <= upperRight.getX()
				&& y >= lowerLeft.getY() && y <= upperRight.getY();
	}
	
	@Override
	public boolean equals(Object obj) {
		Point point = (Point) obj;
		return point.getX() == x && point.getY() == y;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(x);
		builder.append(" ");
		builder.append(y);
		return builder.toString();
	}
}