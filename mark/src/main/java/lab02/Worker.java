package lab02;

public class Worker {
    /** Console reader/writer private class member */
    private ConsoleInOut cons;
    private TriangleFactory fact;

    /**
     * Class constructor
     * @param aConsole Console reader/writer
     * */
    public Worker(TriangleFactory aFactory, ConsoleInOut aConsole) {
        this.cons = aConsole;
        this.fact = aFactory;
    }

    /** main working method */
    public void runWork() {
    	cons.writeString( MsgConsts.MSG_WELLCOME.toString() );

    	while ( cons.hasProperInputString( MsgConsts.MSG_MENU_LEVEL1.toString()+cons.printQuitSignatures()+MsgConsts.MSG_MENU_LEVEL1add.toString() ) ) {
    		// user choice must be number in 1..3 or exit signature
    		int ch = 0;
    		TriangleRoot tri = null;
    		
    		try {
    			ch = Integer.parseInt( cons.getLastInputValue() );
    			if ((ch <= 0) || (ch > 3)) {
    				throw new NumberFormatException(); 
    			}
    		} catch (NumberFormatException e) { 
    			cons.writeString( "IllegalArgumentException: Invalid choice. Your choice mast be number 1..3. Actual: "+cons.getLastInputValue()+"\n\n" );
			}
    		
    		// creating the triangle of defined kind 
    		tri = fact.newTriangle( ch );

    		while ( cons.hasProperInputString( tri.getPrompt()+cons.printQuitSignatures()+MsgConsts.MSG_MENU_LEVEL2add.toString() ) ) {
    			try {
    				tri.parseTriangleParams( cons.getLastInputValue() );
    				cons.writeStringFormat("TriangleArea="+tri.calculateArea()+" (OK)" );
				} catch (NumberFormatException e) {
    				cons.writeString("(parseTriangleParams):"+" NumberFormatException "+e.getMessage() );
    			} catch (IllegalArgumentException e) {
    				cons.writeString("(parseTriangleParams):"+" IllegalArgumentException "+e.getMessage() );
				}
    		}
    		
    		cons.writeString( MsgConsts.MSG_NEW_LINE.toString() );
    	}
    	cons.writeString( MsgConsts.MSG_FINAL.toString() );
    }
}
