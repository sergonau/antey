package lab02;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mark Lobanov on 24.08.2016.
 */
public class TriangleCalculatorFactoryTest extends Assert {
    @Test
    public void newTriangle1() {
        TriangleCalculatorFactory fac = new TriangleCalculatorFactory();
        TriangleCalculator tri = fac.newTriangleCalculator( TrialgleCalculationKind.SIDE_AND_HEIGHT );
        assertTrue(tri instanceof TriangleCalculatorSideAndHeight);
    }
    @Test
    public void newTriangle2() {
        TriangleCalculatorFactory fac = new TriangleCalculatorFactory();
        TriangleCalculator tri = fac.newTriangleCalculator( TrialgleCalculationKind.THREE_SIDES );
        assertTrue(tri instanceof TriangleCalculatorThreeSides);
    }
    @Test
    public void newTriangle3() {
        TriangleCalculatorFactory fac = new TriangleCalculatorFactory();
        TriangleCalculator tri = fac.newTriangleCalculator( TrialgleCalculationKind.TWO_SIDES_AND_ANGLE );
        assertTrue(tri instanceof TriangleCalculatorTwoSidesAndAngle);
    }
    @Test
    public void newTriangle4() {
        TriangleCalculatorFactory fac = new TriangleCalculatorFactory();
        TriangleCalculator tri = fac.newTriangleCalculator( TrialgleCalculationKind.NOTHING );
        assertTrue(tri == null);
    }
}