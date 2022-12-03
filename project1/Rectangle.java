// Written by Anthony Kirby, kirby209

import java.awt.Color;
public class Rectangle {
	
	// Attributes
	private Color shapeColor;
	private double xPos;
	private double yPos;
	private double width;
	private double height;
	
	
	// Constructor
	public Rectangle(double x, double y, double width, double height) {
		
		this.xPos = x;
		this.yPos = y;
		this.width = width;
		this.height = height;
	}
	
	public Rectangle() {}   // Default constructor
	
	
	
	// Accessors
	public void setColor(Color newColor) {
		shapeColor = newColor;
	}
	
	public void setPos(double x, double y) {
		this.xPos = x;
		this.yPos = y;
	}
	
	public void setWidth(double newWidth) {
		this.width = newWidth;
	}
	
	public void setHeight(double newHeight) {
		this.height = newHeight;
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
	
	public double getWidth() {
		return this.width;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	
	
	// Perimeter and Area functions
	public double calculatePerimeter() {
		return 2 * this.width + 2 * this.height;
	}
	
	public double calculateArea() {
		return this.width * this.height; 
	}
}