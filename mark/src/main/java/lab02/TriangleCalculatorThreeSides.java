package lab02;

/**
 * Custom method for triangle calculation by the three sides
 *
 * @author Mark Lobanov
 * @version 2.0.3
 */
public class TriangleCalculatorThreeSides implements TriangleCalculator {
    // inner fields for triangle sides
    private double sideA;
    private double sideB;
    private double sideC;

    // class constructor
    public TriangleCalculatorThreeSides() {
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
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    /**
     * Triangle setup method
     * accepts three triangle sides lengths as some string
     * and sets inner sideA..C fields
     *
     * @param data string with triangle parameters
     * @throws IllegalArgumentException if wrong data.data.getTriangleCalculationKind()
     */
    @Override
    public void initFrom(TriangleTransferData data) {
        if ( data.getTriangleCalculationKind() != TrialgleCalculationKind.THREE_SIDES ) {
            throw new IllegalArgumentException( MsgConsts.MSG_INIT_ERROR_NOT_THREE_SIDES.toString() );
        } else {
            sideA = data.getSideA();
            sideB = data.getSideB();
            sideC = data.getSideC();
        }
    }
}
