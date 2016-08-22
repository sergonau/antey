package lab02;

/**
 * Custom triangle for calculation by the side and 
 * the height drawn to it
 * 
 * @author Mark Lobanov
 * @version 2.0.1
 */
public class TriangleSideAndHeight extends TriangleRoot {
	private double side;
	private double height;

	// class constructor
	public TriangleSideAndHeight(String aPrompt) {
		super( aPrompt );
		side = 0;
		height = 0;
	}

	/**
	 * One sides and and the height drawn to it area calculation method
	 * @return triangle area
     * @throws UnsupportedOperationException if called directly
	 */
	@Override
	public double calculateArea() {
		triangleArea = 0.5 * side * height;
		return triangleArea;
	}

	@Override
	public int getTriangleKind() {
		return 1;
	}

	/**
	 * Triangle setup method
	 * accepts one side and the height drawn to it values as some string 
	 * 
	 * @param setupString string with triangle parameters
	 * @throws IllegalArgumentException than parameters count is not two or 
	 *                                  side length is less or equal then zero or 
	 *                                  height length is less or equal then zero 
	 *                                  of the other two
	 * @return Parsed parameters count 
	 * @throws NumberFormatException than one of parameters is not a double value 
	 */
	@Override
	public int parseTriangleParams(String setupString) {
		String tmp = setupString.trim();
		int paramCnt = Utils.partCount(tmp, SPACE_SINGLE); 
		
		if (paramCnt != 2) {
			throw new IllegalArgumentException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"Triangle must be defined with side and height. Actual params count: " + paramCnt);
		} else {
			// side value checking
			try {
				side = parseStringToDouble( Utils.partAt(0, tmp, SPACE_SINGLE));
				if (side <= 0) {
					throw new IllegalArgumentException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"side value must be greater than zero. Actual: "+side);
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"side="+e.getMessage());			
			}
			// height value checking
			try {
				height = parseStringToDouble( Utils.partAt(1, tmp, SPACE_SINGLE));
				if (height <= 0) {
					throw new IllegalArgumentException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"height value must be greater than zero. Actual: "+height);
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"height="+e.getMessage());			
			}
			return paramCnt;
		}
	}
}
