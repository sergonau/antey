package lab02;

/**
 * Triangle parent class
 * 
 * @author Mark Lobanov
 * @version 2.0.1
 */
public abstract class TriangleRoot {

	/**
	 * Abstract area calculation method, <b>must be overridden in inheritors</b>
	 * @return nothing
	 */
	public abstract double calculateArea();


	/**
	 * Abstract triangle setup method, <b>must be overridden in inheritors</b>
	 * @param data Object with triangle parameters (sides, height, angle)
	 * @return Parsed parameters count 
	 */
	public abstract void initFrom(TriangleData data);
}
