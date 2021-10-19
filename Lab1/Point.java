package Lab1;

public class Point {
	private double x ;
	private double y;
    public Point(double x, double y) {
    	this.x=x;
    	this.y=y;
    	
    }
    public Point() {
    	this.x=0;
    	this.y=0;
    }
    public void translate (double dx , double dy) {
    	x+=dx;
    	y+=dy;
    }
    public String toString() {
    	return "("+ x+","+y+")";
    }
    public double getX() {
    	return this.x;
    }
    public double getY() {
    	return this.y;
    }
    public double distance(Point p) {
    	return Math.sqrt((this.x -p.x)*(this.x-p.x)+ (this.y-p.y)*(this.y-p.y));
    }
    public boolean same(Point p) {
    	if(this.x== p.x && this.y == p.y) return true;
    	return false;
    	
    }
    public boolean isVertical(Point p) {
    	if(this.x==p.x) return true;
    	return false;
    	
    }
    public double slope(Point p) {
    	if(x==p.x) {
    		throw new IllegalArgumentException();
    	}
    	return p.y-y/1.0 *p.x-x;
    }
    
   // public boolean isCollinear(Point p1, Point p2) {
    	
   // }
	public static void main(String[] args) {
			 Point o = new Point(0,0);
			 System.out.println(o.toString());
			 Point p = new Point(1.5,3.4);
			 System.out.println(p.toString());
			 p.translate(0.5,-1.4);
			 System.out.println("After moving: " + p.toString());
			 Point p1 = new Point();
			 Point p2 = new Point();
			 System.out.println(p1 == p2);
			 System.out.println(p1.same(p2));
			 }


	}


