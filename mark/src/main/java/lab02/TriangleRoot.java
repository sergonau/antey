package lab02;

/**
 * Triangle parent class
 * 
 * @author Mark Lobanov
 * @version 2.0.1
 */
public abstract class TriangleRoot {
	// protected class member for prompt 
	protected String prompt;
	// protected  class member for Triangle area
	protected double triangleArea;
    // any spaces
	protected static final String SPACE_SINGLE = " ";
	protected static final String SPACE_DOUBLE = "  ";
	
	// class constructor
	public TriangleRoot(String aPrompt) {
		triangleArea = 0;
		prompt = aPrompt;
	}

	/** Getter for prompt field */
	public String getPrompt() {
		return prompt;
	}

	/**
	 * Method that prepares input string: 
	 * deletes lead, finish and all inner multiple spaces
	 *  
	 * @param str Input string
	 * @return Prepared string
	 */
	protected String prepareSetupString(String str) {
		String tmp = str.trim();
		while (tmp.indexOf(SPACE_DOUBLE) >= 0) {
			tmp = tmp.replaceAll(SPACE_DOUBLE, SPACE_SINGLE);
		}
		return tmp;
	}
	
	/**
	 * Method than converts string to double
	 * @param str input string
	 * @return converted double
	 * @throws NumberFormatException than input string does not contain proper double value 
	 */
	protected double parseStringToDouble(String str) throws NumberFormatException {
		String tmp = str.trim().replace(",", ".");
		try {
		return Double.parseDouble( tmp );
		} catch (NumberFormatException e) {
			throw new NumberFormatException(str.trim()+" is not a double value");
		}
	}
	
	/**
	 * Abstract area calculation method, <b>must be overridden in inheritors</b>
	 * @return nothing
	 */
	public abstract double calculateArea();

	/**
	 * Abstract triangle setup method, <b>must be overridden in inheritors</b>
	 * @param setupString string with triangle parameters (sides, corners etc)
	 * @return Parsed parameters count 
	 */
	public abstract int parseTriangleParams(String setupString);

	/**
	 * Abstract getter for triangle king method, <b>must be overridden in inheritors</b>
	 * @return triangle Kind
	 */
	public abstract int getTriangleKind();
}
