package lab02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mark Lobanov on 24.08.2016.
 */
public class TrianglesTest {
    @Test
    public void calculateArea1() throws Exception {
        TriangleCalculatorFactory fac = new TriangleCalculatorFactory();
        TriangleCalculator tri = fac.newTriangleCalculator( TrialgleCalculationKind.SIDE_AND_HEIGHT );
        TriangleTransferData data = new TriangleTransferData();

        data.setTriangleCalculationKind( TrialgleCalculationKind.SIDE_AND_HEIGHT );
        data.setSideAndHeight(12, 34.8);
        tri.initFrom( data );
        double res = tri.calculateArea();

        assertTrue("Triangle area=" + res, res == 208.79999999999998);
    }
    @Test
    public void calculateArea2() throws Exception {
        TriangleCalculatorFactory fac = new TriangleCalculatorFactory();
        TriangleCalculator tri = fac.newTriangleCalculator( TrialgleCalculationKind.THREE_SIDES );
        TriangleTransferData data = new TriangleTransferData();

        data.setTriangleCalculationKind( TrialgleCalculationKind.THREE_SIDES );
        data.setThreeSides(12, 10, 11);
        tri.initFrom( data );
        double res = tri.calculateArea();

        assertTrue("Triangle area=" + res, res == 51.521233486786784);
    }
    @Test
    public void calculateArea3() throws Exception {
        TriangleCalculatorFactory fac = new TriangleCalculatorFactory();
        TriangleCalculator tri = fac.newTriangleCalculator( TrialgleCalculationKind.TWO_SIDES_AND_ANGLE );
        TriangleTransferData data = new TriangleTransferData();

        data.setTriangleCalculationKind( TrialgleCalculationKind.TWO_SIDES_AND_ANGLE );
        data.setTwoSidesAndAngle(12, 10, 76);
        tri.initFrom( data );
        double res = tri.calculateArea();

        assertTrue("Triangle area=" + res, res == 58.21774357655979);
    }
}