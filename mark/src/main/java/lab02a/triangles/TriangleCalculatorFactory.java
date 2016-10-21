package lab02a.triangles;

/**
 * Factory than creates some kinds of
 * triangle calculator via interface
 *
 * @author Mark Lobanov (17.08.2016)
 * @version 2.0.3
 */
public class TriangleCalculatorFactory {

    public ITriangleCalculator newTriangleCalculator(TrialgleCalculationKind triangleKind) {
        switch (triangleKind) {
            case SIDE_AND_HEIGHT: {
                return new TriangleCalculatorSideAndHeight();
            }
            case THREE_SIDES: {
                return new TriangleCalculatorThreeSides();
            }
            case TWO_SIDES_AND_ANGLE: {
                return new TriangleCalculatorTwoSidesAndAngle();
            }
            default: {
                return null;
            }
        }
    }
}
