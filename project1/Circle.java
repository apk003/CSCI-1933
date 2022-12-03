// Written by Anthony Kirby, kirby209

import java.awt.Color;
public class Circle {
	
	// Attributes
	private Color shapeColor;
	private double xPos;
	private double yPos;
	private double radius;
	
	
	// Constructor
	public Circle(double x, double y, double rad) {
		
		this.xPos = x;
		this.yPos = y;
		this.radius = rad;
	}
	
	public Circle() {}   // Default constructor
	
	
	
	// Accessors
	public void setColor(Color newColor) {
		shapeColor = newColor;
	}
	
	public void setPos(double x, double y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public void setRadius(double newRadius) {
		this.radius = newRadius;
	}
	
	public Color getColor() {
		return this.shapeColor;
	}
	
	public double getXPos() {
		return this.xPos;
	}
	
	public double getYPos() {
		return this.yPos;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	
	
	// Perimeter and Area functions
	public double calculatePerimeter() {
		return this.radius * 2 * Math.PI;
	}
	
	public double calculateArea() {
		return Math.pow(this.radius,2) * Math.PI; 
	}
}
