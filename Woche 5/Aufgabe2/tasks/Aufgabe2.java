/*
    Aufgabe2) Interfaces

    Gegeben sind die Interfaces Movable, Copyable und ShapeOnPlane.
    ShapeOnPlane und Movable beziehen sich auf geometrische Objekte in einem
    2D-Koordinatensystem. Es gibt eine Klasse Point welche einen
    2D-Punkt mit x- und y-Koordinaten repräsentiert. Ergänzen Sie die fehlenden
    Teile zu Point. Es sind folgende Klassen zu implementieren:

    - Point:    ist ein Punkt in der Ebene und implementiert Movable.
    - Triangle: repräsentiert ein Dreieck bestehend aus 3 Eckpunkten (Point).
                Ein Triangle-Objekt wird mit der Angabe von drei Point-Objekten
                erzeugt. Schreiben Sie einen entsprechenden Konstruktor.
    - Circle:   repräsentiert einen Kreis mit Mittelpunkt (Point) und
                radius (double). Ein Circle-Objekt wird mit der Angabe von einem
                Mittelpunkt (Point) und dem Radius (double) erzeugt. Schreiben
                Sie einen entsprechenden Konstruktor.

    Triangle und Circle sollen ShapeOnPlane implementieren. Dies ist die
    gemeinsame Schnittstelle für geometrische Formen in der 2D-Ebene. Solche
    Objekte können verschoben werden (move) und haben einen Umfang (perimeter).
    Weiters können von diesen Objekten mit der parameterlosen Methode copy()
    unabhängige Kopien erzeugt werden. Nachfolgende Änderungen (z.B. durch move)
    des Originals haben keine Auswirkungen auf die Kopie und umgekehrt.

    Triangle und Circle sollen über eine öffentliche parameterlose Methode
    toString() verfügen, die eine lesbare Repräsentation (als String) des
    Objekts zurückliefert. Zahlen sollen dabei mit zwei Nachkommastellen
    dargestellt werden. Siehe die toString()-Methode in Point sowie die
    Testfälle in Aufgabe2.main(). Hinweis: toString() wird implizit aufgerufen,
    wenn ein Objekt vom Typ Triange, Circle, Point, ShapeOnPlane, etc. mit
    System.out.println() ausgegeben wird. Daher wird der Aufruf in den
    Beispielen in Aufgabe2.main() teilweise nicht explizit angegeben.

    Definieren Sie zusätzlich ein Interface DoubleMatrix. Alle Objekte die
    DoubleMatrix sind, verfügen über eine parameterlose Methode toArray() die
    ein zwei-dimensionales Array mit double-Werten liefert. In jeder Zeile des
    Arrays stehen die Koordinaten eines Punktes, oder ein Array mit nur einem
    Element im Fall eines Skalars (z.B. Radius). Point, Circle und Triangle
    sollen DoubleMatrix implementieren. Schreiben Sie weiters eine
    static-Methode print, die einen Parameter vom Typ DoubleMatrix hat und den
    Inhalt des double[][]-Arrays ausgibt. Die Form des Arrays und das Format der
    Ausgabe erkennen Sie an den Testfällen unter Aufgabe2.main().

    Sie können in dieser Aufgabe auch Methoden aus java.util.Arrays nutzen.

    Zusatzfragen:
    1. Wozu benötigt man Interfaces?
    2. Was bedeutet es, wenn ein Interface ein anderes Interface erweitert
       (extends)?
    3. Welche der folgenden Ausdrücke sind nach der Anweisung
       Movable point = new Point(1d,2d);
       gültig? Warum?

        point.distanceTo(new Point(0d,0d))
        point.move(0.5,1d)
        point.copy()
        point.toString()
*/

import java.util.Arrays;

interface Movable {
	//shifts the object by the vector (deltaX, deltaY)
	public void move(double deltaX, double deltaY);
}

interface DoubleMatrix {
	public double[][] toArray();
}

interface Copyable {
	//returns an independent copy of an object
	//should be declared or overridden by every subclass
	//(even by abstract subclasses)
	Copyable copy();
}

interface ShapeOnPlane extends Movable, Copyable {
	//returns the perimeter of the shape
	public double perimeter();

	public ShapeOnPlane copy();
}

class Point implements Movable, DoubleMatrix {

	private double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public String toString() {
		return "(" + String.format("%.2f", x) + "," + String.format("%.2f", y) + ")";
	}

	public void move(double deltaX, double deltaY) {
		this.x += deltaX;
		this.y += deltaY;
	}

	public double distanceTo(Point p) {
		return Math.hypot(p.x - this.x, p.y - this.y);
	}

	public Point copy() {
		return new Point(x, y);
	}

	public double[][] toArray() {
		return new double[][]{{x, y}};
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}


class Triangle implements ShapeOnPlane, DoubleMatrix {
	private Point a, b, c;

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public double perimeter() {
//		return Math.hypot(c.getX() - a.getX(), c.getY() - a.getY())
//			 + Math.hypot(c.getX() - b.getX(), c.getY() - b.getY())
//			 + Math.hypot(a.getX() - b.getX(), a.getY() - b.getY());

		return a.distanceTo(c) + b.distanceTo(c) + a.distanceTo(b);
	}

	@Override
	public ShapeOnPlane copy() {
		return new Triangle(a.copy(), b.copy(), c.copy());
	}

	@Override
	public void move(double deltaX, double deltaY) {
		a.move(deltaX, deltaY);
		b.move(deltaX, deltaY);
		c.move(deltaX, deltaY);
	}

	@Override
	public String toString() {
		return "[" + a + ", " + b + ", " + c + "]";
	}

	@Override
	public double[][] toArray() {
		return new double[][]{
				a.toArray()[0],
				b.toArray()[0],
				c.toArray()[0]
		};
	}
}

class Circle implements ShapeOnPlane, DoubleMatrix {

	private Point center;
	private double radius;

	public Circle(Point center, double radius) {
		this.center = center;
		this.radius = radius;
	}

	@Override
	public double perimeter() {
		return 2*radius*Math.PI;
	}

	@Override
	public ShapeOnPlane copy() {
		return new Circle(center.copy(), radius);
	}

	@Override
	public void move(double deltaX, double deltaY) {
		center.move(deltaX, deltaY);
	}

	@Override
	public String toString() {
		return "[" + center + ", " + String.format("%.2f", radius) + "]";
	}

	@Override
	public double[][] toArray() {
		return new double[][]{
				center.toArray()[0], // unwrap array
				{radius}
		};
	}
}

public class Aufgabe2 {

	public static void print(DoubleMatrix dm) {
		System.out.print("[");
		for(double[] d : dm.toArray()) {
			System.out.print(Arrays.toString(d));
		}
		System.out.println("]");
	}

	// just for testing ...
	public static void main(String[] args) {
		//Entfernen Sie zum Testen die folgenden Kommentarzeichen.

        ShapeOnPlane shape = new Circle(new Point(2.5, -1.0), 1.0);
        System.out.println(shape.toString()); //[(2.50,-1.00),1.00]
        ShapeOnPlane copy = shape.copy();
        shape.move(1.0,1.5);
        System.out.println(shape); //[(3.50,0.50),1.00]
        System.out.println(copy); //[(2.50,-1.00),1.00]
        System.out.println(shape.perimeter()); //6.283185307179586
        System.out.println(copy.perimeter()); //6.283185307179586
        shape.move(1.0,1.5);
        System.out.println(shape); //[(4.50,2.00),1.00]
        shape = new Triangle(new Point(2.5, 1.0),
                             new Point(-1.0,3.0),
                             new Point(0d,0d));
        System.out.println(shape.perimeter()); //9.885988937884907
        System.out.println(shape); //[(2.50,1.00), (-1.00,3.00), (0.00,0.00)]

        DoubleMatrix matrix = new Circle(new Point(2.5, -1.0), 1.0);
        print(matrix); //[[2.5, -1.0][1.0]]
        matrix = new Triangle(new Point(2.5, 1.0),
                              new Point(-1.0,3.0),
                              new Point(0d,0d));
        print(matrix); //[[2.5, 1.0][-1.0, 3.0][0.0, 0.0]]

	}
}