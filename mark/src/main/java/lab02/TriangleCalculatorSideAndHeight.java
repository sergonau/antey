package lab02;

/**
 * Custom method for triangle calculation by the side and
 * the height drawn to it
 *
 * @author Mark Lobanov
 * @version 2.0.3
 */
public class TriangleCalculatorSideAndHeight implements TriangleCalculator {
    private double side;
    private double height;

    // class constructor
    public TriangleCalculatorSideAndHeight() {
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
     * @throws IllegalArgumentException if wrong data.data.getTriangleCalculationKind()
     */
    @Override
    public void initFrom(TriangleTransferData data) {
        if ( data.getTriangleCalculationKind() != TrialgleCalculationKind.SIDE_AND_HEIGHT ) {
            throw new IllegalArgumentException( MsgConsts.MSG_INIT_ERROR_NOT_SIDE_AND_HEIGHT.toString() );
        } else {
            side = data.getSideA();
            height = data.getHeight();
        }
    }
}
