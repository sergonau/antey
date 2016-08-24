package lab02;

/**
 * Main work method
 *
 * @author Mark Lobanov (17.08.2016)
 * @version 2.0.2
 */
public class Worker {
    /** Console reader/writer private class member */
    private ConsoleInOut cons;
    private TriangleFactory fact;

    /**
     * Class constructor
     * @param aFactory Triangle factory
	 * @param aConsole Console reader/writer
     * */
    public Worker(TriangleFactory aFactory, ConsoleInOut aConsole) {
        this.cons = aConsole;
        this.fact = aFactory;
    }

    /** main working method */
    public void runWork() {
    	cons.writeString( MsgConsts.MSG_WELLCOME.toString() );

    	while ( cons.hasProperLevel1InputString() ) {
			// Proper input
    		if ( cons.getLastInputValue().getTriangleKind() != TrialgleKind.NOTHING ) {
				// creating the triangle of defined kind
				TriangleRoot tri = fact.newTriangle( cons.getLastInputValue().getTriangleKind() );

				while ( cons.hasProperLevel2InputString() ) {

					if ( cons.getLastInputValue().canBeUsed() ) {
						try {

							tri.initFrom( cons.getLastInputValue() );
							cons.writeStringLn("TriangleArea=" + tri.calculateArea() + " (OK)" );

						} catch (NumberFormatException e) {
							cons.writeStringLn( MsgConsts.MSG_NFE.toString() + e.getMessage() );
						} catch (IllegalArgumentException e) {
							cons.writeStringLn( MsgConsts.MSG_IAE.toString() + e.getMessage() );
						}
					}
				}
				cons.writeString( MsgConsts.MSG_NEW_LINE.toString() );
			}
    	}
    	cons.writeString( MsgConsts.MSG_FINAL.toString() );
    }
}
