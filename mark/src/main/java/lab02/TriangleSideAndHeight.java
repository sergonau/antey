package lab02;

/**
 * Custom triangle for calculation by the side and 
 * the height drawn to it
 * 
 * @author Mark Lobanov
 * @version 2.0.2
 */
public class TriangleSideAndHeight extends TriangleRoot {
	private double side;
	private double height;

	// class constructor
	public TriangleSideAndHeight() {
		side = 0;
		height = 0;
	}

	/**
	 * One sides and and the height drawn to it area calculation method
	 * @return triangle area
	 */
	@Override
	public double calculateArea() {
		return 0.5 * side * height;
	}

	/**
	 * Triangle setup method
	 * accepts one side and the height drawn to it values as some string
	 *
	 * @param data string with triangle parameters
	 * @throws IllegalArgumentException if wrong data.data.getTriangleKind()
	 */
	@Override
	public void initFrom(TriangleData data) {
		if ( data.getTriangleKind() != TrialgleKind.SIDE_AND_HEIGHT ) {
			throw new IllegalArgumentException( MsgConsts.MSG_INIT_ERROR_NOT_SIDE_AND_HEIGHT.toString() );
		} else {
			side = data.getSideA();
			height = data.getHeight();
		}
	}
}
