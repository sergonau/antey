package lab02;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mark Lobanov on 22.08.2016.
 */
public class TriangleFactoryTest extends Assert {

    private int getResult(TriangleRoot tri) {
        // createParameter is greater then tree (error)
        if (tri == null) {
            return -1;
        } else {
            // normal createParameter value
            return tri.getTriangleKind();
        }
    }


    @Test
    public void testNewTriangle1() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 1 );
        int result = getResult( tri );
        assertTrue("TRIANGLE KIND = "+result, result == 1);
    }

    @Test
    public void testNewTriangle2() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 2 );
        int result = getResult( tri );
        assertTrue("TRIANGLE KIND = "+result, result == 2);
    }

    @Test
    public void testNewTriangle3() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 3 );
        int result = getResult( tri );
        assertTrue("TRIANGLE KIND = "+result, result == 3);
    }

    @Test
    public void testNewTriangleNull() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 12 );
        int result = getResult( tri );
        assertTrue("TRIANGLE KIND = "+result, result == -1);
    }

}