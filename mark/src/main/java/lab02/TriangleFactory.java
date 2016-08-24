package lab02;

/**
 * Factory than creates some kinds of triangkes
 *
 * @author Mark Lobanov (17.08.2016)
 * @version 2.0.2
 */
public class TriangleFactory {

    public TriangleRoot newTriangle(TrialgleKind triangleKind) {
        switch (triangleKind) {
            case SIDE_AND_HEIGHT: {
                return new TriangleSideAndHeight();
            }
            case THREE_SIDES: {
                return new TriangleThreeSides();
            }
            case TWO_SIDES_AND_ANGLE: {
                return new TriangleTwoSidesAndAngle();
            }
            default: {
                return null;
            }
        }
    }
}
