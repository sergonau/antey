package lab02;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mark Lobanov on 24.08.2016.
 */
public class TriangleFactoryTest extends Assert {
    @Test
    public void newTriangle1() {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( TrialgleKind.SIDE_AND_HEIGHT );
        assertTrue(tri instanceof TriangleSideAndHeight);
    }
    @Test
    public void newTriangle2() {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( TrialgleKind.THREE_SIDES );
        assertTrue(tri instanceof TriangleThreeSides);
    }
    @Test
    public void newTriangle3() {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( TrialgleKind.TWO_SIDES_AND_ANGLE );
        assertTrue(tri instanceof TriangleTwoSidesAndAngle);
    }
    @Test
    public void newTriangle4() {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( TrialgleKind.NOTHING );
        assertTrue(tri == null);
    }
}