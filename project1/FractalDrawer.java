// Written by Anthony Kirby, kirby209

// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;

public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total perimeter

    public FractalDrawer() {}  // constructor
    
    
    // drawFractal creates a new drawing of the specified @param type or shape and @returns the total area
    public double drawFractal(String type) {
    	
    	Canvas drawing = new Canvas(800,800);
    	
    	if (type.toLowerCase().contains("circle")) {
    		this.drawCircleFractal(150,400,400,Color.BLUE,drawing,8);
    		
    	} else if (type.toLowerCase().contains("rectangle")) {
    		this.drawRectangleFractal(150,150,350,300,Color.BLUE,drawing,8);
    		
    	} else if (type.toLowerCase().contains("triangle")) {
    		this.drawTriangleFractal(150,125,325,500,Color.BLUE,drawing,8);
    	}
    	
    	return this.totalArea;
    }

    

    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
    	
    	Color triColor = c;
    		
		// Cycles through RGB colors
		if (level%3 == 2) {
			triColor = Color.BLUE;
			
		} else if (level%3 == 1) {
			triColor = Color.GREEN;
			
		} else {
			triColor = Color.RED;
		}
		
		
		// Creates a new triangle object
		Triangle tri = new Triangle(x,y,width,height);
		tri.setColor(triColor);
		
		// Base step for recursive iteration
		if (level==1) {	
			
	    	can.drawShape(tri);
	    	this.totalArea += tri.calculateArea();
		}
		
	    // Recursive step: adds one triangle of half height/width at each corner
		else {
			
			can.drawShape(tri);
			
			this.drawTriangleFractal(width/2, height/2, x-width/2, y, triColor, can, level-1);
			this.drawTriangleFractal(width/2, height/2, x+width/2 - width/4,y-height, triColor, can, level-1);
			this.drawTriangleFractal(width/2, height/2, x+width, y, triColor, can, level-1);
			
		}
    }

    

    // drawCircleFractal draws a circle fractal using recursive techniques
    // Note: may need to adjust window size
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
    	Color cirColor = c;
		
		// Cycles through RGB colors
		if (level%3 == 2) {
			cirColor = Color.BLUE;
			
		} else if (level%3 == 1) {
			cirColor = Color.GREEN;
			
		} else {
			cirColor = Color.RED;
		}
		
		
		// Creates a new circle object
		Circle cir = new Circle(x,y,radius);
		cir.setColor(cirColor);
		
		// Base step for recursive iteration
		if (level==1) {	
			
	    	can.drawShape(cir);
	    	this.totalArea += cir.calculateArea();
		}
		
	    // Recursive step: adds one circle of half radius in four spots
		else {
			
			can.drawShape(cir);
			
			this.drawCircleFractal(radius/2, x-(3/2)*radius, y, cirColor, can, level-1);
			this.drawCircleFractal(radius/2, x , y+(3/2)*radius, cirColor, can, level-1);
			this.drawCircleFractal(radius/2, x+(3/2)*radius, y, cirColor, can, level-1);
			this.drawCircleFractal(radius/2, x , y-(3/2)*radius, cirColor, can, level-1);
			
		}
    }


    
    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    // Note: may need to adjust window size
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
    	Color recColor = c;
		
    	// Creates gopher colors
    	Color GOLD = new Color(251,185,60);
    	Color MAROON = new Color(134,35,52);
    	
		// Cycles through gopher colors
		if (level%3 == 1) {
			recColor = GOLD;

		} else {
			recColor = MAROON;
		}
		
		
		// Creates a new rectangle object
		Rectangle rec = new Rectangle(x,y,width,height);
		rec.setColor(recColor);
		
		// Base step for recursive iteration
		if (level==1) {	
			
	    	can.drawShape(rec);
	    	this.totalArea += rec.calculateArea();
		}
		
	    // Recursive step: adds one rectangle of half height/width to each corner
		else {
			
			can.drawShape(rec);
			
			this.drawRectangleFractal(width/2, height/2, x-width/2, y-height/2, recColor, can, level-1);
			this.drawRectangleFractal(width/2, height/2, x-width/2, y+(3/2)*height, recColor, can, level-1);
			this.drawRectangleFractal(width/2, height/2, x+(3/2)*width, y+(3/2)*width, recColor, can, level-1);
			this.drawRectangleFractal(width/2, height/2, x+(3/2)*width, y-width/2, recColor, can, level-1);
			
		}
    }


    
    // takes shape input, draws fractal, and outputs total perimeter
    public static void main(String[] args){

    	Scanner askShape = new Scanner(System.in);
    	System.out.print("Enter shape\n");
    	String shape = askShape.nextLine();
    	askShape.close();
    	
    	FractalDrawer drawObj = new FractalDrawer();
    	System.out.print(drawObj.drawFractal(shape));
    	
    }
}