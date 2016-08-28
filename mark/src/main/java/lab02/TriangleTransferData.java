package lab02;

/**
 * Data transfer object for triange parameters
 *
 * @author Mark Lobanov (23.08.2016)
 * @version 2.0.3
 */
public class TriangleTransferData {
    private TrialgleCalculationKind triangleCalculationKind;
    private double sideA;
    private double sideB;
    private double sideC;
    private double height;
    private double angle;
    private boolean fCanBeUsed;

    /** class constructor */
    public TriangleTransferData() {
        clearFull();
    }

    /****************************************
     *               getters
     *****************************************/
    public TrialgleCalculationKind getTriangleCalculationKind() {
        return triangleCalculationKind;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public double getHeight() {
        return height;
    }

    public double getAngle() {
        return angle;
    }

    public boolean canBeUsed() {
        return fCanBeUsed;
    }

    public void canNotBeUsed() {
        fCanBeUsed = false;
    }

    /****************************************
     *               setters
     *****************************************/
    public void setTriangleCalculationKind(TrialgleCalculationKind triangleCalculationKind) {
        this.triangleCalculationKind = triangleCalculationKind;
    }

    public void setSideAndHeight(double aSide, double aHeigth) {
        if ( triangleCalculationKind == TrialgleCalculationKind.SIDE_AND_HEIGHT) {
            this.sideA  = aSide;
            this.height = aHeigth;
            this.fCanBeUsed = true;
        } else {
            throw new IllegalArgumentException( MsgConsts.MSG_ERROR_TRIALGLE_KIND_IS_NOT_SIDE_AND_HEIGHT.toString() );
        }
    }

    public void setThreeSides(double aSideA, double aSideB, double aSideC) {
        if ( triangleCalculationKind == TrialgleCalculationKind.THREE_SIDES) {
            this.sideA = aSideA;
            this.sideB = aSideB;
            this.sideC = aSideC;
            this.fCanBeUsed = true;
        } else {
            throw new IllegalArgumentException( MsgConsts.MSG_ERROR_TRIALGLE_KIND_IS_NOT_THREE_SIDES.toString() );
        }
    }

    public void setTwoSidesAndAngle(double aSideA, double aSideB, double aAngle) {
        if ( triangleCalculationKind == TrialgleCalculationKind.TWO_SIDES_AND_ANGLE) {
            this.sideA = aSideA;
            this.sideB = aSideB;
            this.angle = aAngle;
            this.fCanBeUsed = true;
        } else {
            throw new IllegalArgumentException( MsgConsts.MSG_ERROR_TRIALGLE_KIND_IS_NOT_TWO_SIDES_AND_ANGLE.toString() );
        }
    }


    /****************************************
     *               setters
     *****************************************/
    public void clearData() {
        this.sideA = 0;
        this.sideB = 0;
        this.sideC = 0;
        this.height = 0;
        this.angle = 0;
        canNotBeUsed();
    }

    public void clearFull() {
        this.triangleCalculationKind = TrialgleCalculationKind.NOTHING;
        clearData();
    }
}
