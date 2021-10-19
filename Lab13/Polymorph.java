package Lab13;

class Polymorph {
	public static void main(String[] args)
	{
		Shape[] tabFormes = { new Circle("red"), new Triangle("yellow") };

		Collect formes = new Collect(10);

		// A collection of formes
		// containing a copy of objets defined in table tabFormes
		for (Shape tabForme : tabFormes)
			formes.add(tabForme.clone());
		formes.draw();
	}
}

class Shape {
	private String color;

	public Shape(String aColor) {
		color = aColor;
	}

	public Shape(Shape other) {
		this.color = other.color;
	}

	public Shape clone()
	{
		return new Shape(this);
	}

	public void draw() {
		System.out.println("A " + color + " shape");
	}
}

class Triangle extends Shape {
	public Triangle(String aColor) {
		super(aColor);
	}

	public Triangle(Triangle otherTriangle) {
		super(otherTriangle);
	}

	public Triangle clone()
	{
		return new Triangle(this);
	}

	public void draw() {
		super.draw();
		System.out.println("toute pointue");
	}
}

class Circle extends Shape {

	public Circle(String aColor) {
		super(aColor);
	}

	public Circle(Circle otherCircle) {
		super(otherCircle);
	}

	public Circle clone()
	{
		return new Circle(this);
	}

	public void draw() {
		super.draw();
		System.out.println("toute ronde");
	}
}

class Collect {
	private Shape[] collect;

	private int index;

	public Collect(int indexMax) {
		collect = new Shape[indexMax];
		index = -1;
	}

	public void add(Shape a) {
		if (index < collect.length - 1) {
			++index;
			collect[index] = a;
		}

	}

	public void draw() {
		for (int i = 0; i <= index; ++i)
			collect[i].draw();
	}
}
