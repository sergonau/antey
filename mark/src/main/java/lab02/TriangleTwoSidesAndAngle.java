/**
 * 
 */
package lab02;

/**
 * Custom triangle for calculation by the two sides and
 * angle between them 
 * 
 * @author Mark Lobanov
 * @version 2.0.1
 */
public class TriangleTwoSidesAndAngle extends TriangleRoot {
	// inner fields for triangle sides
	private double sideA;
	private double sideB;
	private double angle;

	// class constructor
	public TriangleTwoSidesAndAngle(String aPrompt) {
		super( aPrompt );
		sideA = 0;
		sideB = 0;
		angle = 0;
	}

	/**
	 * Method that converts degree angle size into radians 
	 *  
	 * @param str Angle size in degrees 
	 * @return Angle size in radians
	 */
	private double convertDegToRad (double deg)
	{
		return (Math.PI * deg) / 180; 
	}

	/**
	 * Two sides and angle area calculation method
	 * @return triangle area
	 */
	@Override
	public double calculateArea() {
		triangleArea = 0.5 * sideA * sideB * Math.sin( convertDegToRad( angle ) );
		return triangleArea; 
	}

	@Override
	public int getTriangleKind() {
		return 3;
	}

	/**
	 * Triangle setup method
	 * accepts two triangle sides lengths and angle size in degrees between them 
	 * as some string 
	 * 
	 * @param setupString string with triangle parameters
	 * @throws IllegalArgumentException than parameters count is not three or 
	 *                                  one of sides is less than zero or 
	 *                                  angle size is less than zero 
	 * @return Parsed parameters count 
	 * @throws NumberFormatException than one of parameters is not a double value 
	 */
	@Override
	public int parseTriangleParams(String setupString) {
		String tmp = setupString.trim();
		int paramCnt = Utils.partCount(tmp, SPACE_SINGLE); 
		
		if (paramCnt != 3) {
			throw new IllegalArgumentException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"Triangle must be defined with two sides and angle. Actual params count: " + paramCnt);
		} else {
			// sideA value checking
			try {
				sideA = parseStringToDouble( Utils.partAt(0, tmp, SPACE_SINGLE));
				if (sideA <= 0) {
					throw new IllegalArgumentException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"sideA must be greater than zero. Actual: "+sideA);
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"sideA="+e.getMessage());			
			}

			// sideB value checking
			try {
				sideB = parseStringToDouble( Utils.partAt(1, tmp, SPACE_SINGLE));
				if (sideB <= 0) {
					throw new IllegalArgumentException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"sideC must be greater than zero. Actual: "+sideB);
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"sideB="+e.getMessage());			
			}

			// angle value checking
			try {
				angle = parseStringToDouble( Utils.partAt(2, tmp, SPACE_SINGLE));
				if ((angle <= 0) || (angle >= 180)) {
					throw new IllegalArgumentException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"angle value must be in 1..179. Actual: "+angle);
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"angle="+e.getMessage());			
			}
			return paramCnt;
		}
	}
}
