package lab02;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mark Lobanov on 24.08.2016.
 */
public class TrianglesTest {
    @Test
    public void calculateArea1() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( TrialgleKind.SIDE_AND_HEIGHT );
        TriangleData data = new TriangleData();

        data.setTriangleKind( TrialgleKind.SIDE_AND_HEIGHT );
        data.setSideAndHeight(12, 34.8);
        tri.initFrom( data );
        double res = tri.calculateArea();

        assertTrue("Triangle area=" + res, res == 208.79999999999998);
    }
    @Test
    public void calculateArea2() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( TrialgleKind.THREE_SIDES );
        TriangleData data = new TriangleData();

        data.setTriangleKind( TrialgleKind.THREE_SIDES );
        data.setThreeSides(12, 10, 11);
        tri.initFrom( data );
        double res = tri.calculateArea();

        assertTrue("Triangle area=" + res, res == 51.521233486786784);
    }
    @Test
    public void calculateArea3() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( TrialgleKind.TWO_SIDES_AND_ANGLE );
        TriangleData data = new TriangleData();

        data.setTriangleKind( TrialgleKind.TWO_SIDES_AND_ANGLE );
        data.setTwoSidesAndAngle(12, 10, 76);
        tri.initFrom( data );
        double res = tri.calculateArea();

        assertTrue("Triangle area=" + res, res == 58.21774357655979);
    }
}