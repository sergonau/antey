package lab02;

/**
 * Custom triangle for calculation by the three sides 
 * 
 * @author Mark Lobanov
 * @version 2.0.1
 */
public class TriangleThreeSides extends TriangleRoot {
	// inner fields for triangle sides
	private double sideA;
	private double sideB;
	private double sideC;

	// class constructor
	public TriangleThreeSides(String aPrompt) {
		super( aPrompt );
		sideA = 0;
		sideB = 0;
		sideC = 0;
	}

	/** semiPerimeter calculation method */
	private double getSemiPerimeter() {
		return ( sideA + sideB + sideC )/2;
	}

	/**
	 * Three sides area calculation method (Heron's formula)
	 * @return triangle area
	 */
	@Override
	public double calculateArea() {
		double p = getSemiPerimeter();
		triangleArea = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
		return triangleArea;
	}


	@Override
	public int getTriangleKind() {
		return 2;
	}

	/**
	 * Triangle setup method
	 * accepts three triangle sides lengths as some string 
	 * and sets inner sideA..C fields 
	 * 
	 * @param setupString string with triangle parameters
	 * @throws IllegalArgumentException than parameters count is not three or 
	 *                                  one of sides is less then zero or
	 *                                  one of sides is greater than or equal to the sum of the other two
	 * @return Parsed parameters count 
	 * @throws NumberFormatException than one of parameters is not a double value 
	 */
	@Override
	public int parseTriangleParams(String setupString) {
		String tmp = setupString.trim();
		int paramCnt = Utils.partCount(tmp, SPACE_SINGLE); 
		
		if (paramCnt != 3) {
			throw new IllegalArgumentException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"Triangle must be defined with three sides. Actual params count: " + paramCnt);
		} else {
			// sideA value checking
			try {
				sideA = parseStringToDouble( Utils.partAt(0, tmp, SPACE_SINGLE));
				if (sideA <= 0) {
					throw new IllegalArgumentException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"sideA must be greater than zero. Actual: "+sideA);
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"sideA=<"+e.getMessage());			
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

			// sideC value checking
			try {
				sideC = parseStringToDouble( Utils.partAt(2, tmp, SPACE_SINGLE));
				if (sideC <= 0) {
					throw new IllegalArgumentException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"sideC must be greater than zero. Actual: "+sideC);
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"sideC="+e.getMessage());			
			}

			// all sides value checking
			if ( ((sideB + sideC) <= sideA) || ((sideA + sideC) <= sideB ) || ((sideA + sideB) <= sideC) ) {
				throw new IllegalArgumentException(MsgConsts.MSG_SETUP_TRIANGLE_ERROR+"The sum of the lengths of any two sides must be greater than the length of the third side. Actual: <"+sideA+"> <"+sideB+"> <"+sideC+">");
			}
			return paramCnt;		
		}
	}
}
