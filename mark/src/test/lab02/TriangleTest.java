package lab02;

import org.junit.Assert;
import org.junit.Test;
import java.lang.IllegalArgumentException;

/**
 * Created by Mark Lobanov on 22.08.2016.
 */
public class TriangleTest extends Assert {

    @Test
    public void parseStringToDouble1() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 1 );
        double res = tri.parseStringToDouble("10.2");
        assertTrue("Double value="+res, res == 10.2);
    }
    @Test
    public void parseStringToDouble2() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 1 );
        double res = tri.parseStringToDouble("   1.2");
        assertTrue("Double value="+res, res == 1.2);
    }
    @Test
    public void parseStringToDouble3() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 3 );
        double res = tri.parseStringToDouble("1,2");
        assertTrue("Double value="+res, res == 1.2);
    }
    @Test(expected = NumberFormatException.class)
    public void parseStringToDouble4() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 3 );
        double res = tri.parseStringToDouble("1a2");
    }

    /************************************************
    *
    *             triangleKind == 1
    *             parseTriangleParams
    *
    ************************************************/

    @Test
    public void parseTriangleParams1_0() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 1 );
        int res = tri.parseTriangleParams("3 4");  // normal run
        assertTrue("params count="+res, res == 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTriangleParams1_1() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 1 );
        int res = tri.parseTriangleParams("3 4 5"); // parameters count greater then 2
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTriangleParams1_2() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 1 );
        int res = tri.parseTriangleParams(""); // parameters count less then 2
    }

    @Test(expected = NumberFormatException.class)
    public void parseTriangleParams1_3() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 1 );
        int res = tri.parseTriangleParams("3 test");
    }


    /************************************************
     *
     *             triangleKind == 2
     *             parseTriangleParams
     *
     ************************************************/
    @Test
    public void parseTriangleParams2_0() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 2 );
        int res = tri.parseTriangleParams("10 12 11");  // normal
        assertTrue("params count="+res, res == 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTriangleParams2_0a() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 2 );
        int res = tri.parseTriangleParams("3 4 12");  // The sum of the lengths of any two sides must be greater than the length of the third
        assertTrue("params count="+res, res == 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTriangleParams2_1() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 2 );
        int res = tri.parseTriangleParams("3 4 5 4"); // parameters count greater then 3
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTriangleParams2_2() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 2 );
        int res = tri.parseTriangleParams("12"); // parameters count less then 3
    }

    @Test(expected = NumberFormatException.class)
    public void parseTriangleParams2_3() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 2 );
        int res = tri.parseTriangleParams("3 test 44");
    }


    /************************************************
     *
     *             triangleKind == 3
     *             parseTriangleParams
     *
     ************************************************/
    @Test
    public void parseTriangleParams3_0() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 3 );
        int res = tri.parseTriangleParams("7 12 42");  // normal
        assertTrue("params count="+res, res == 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTriangleParams3_0a() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 3 );
        int res = tri.parseTriangleParams("3 10 190");  // angle value must be in 1..179
        assertTrue("params count="+res, res == 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTriangleParams3_1() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 3 );
        int res = tri.parseTriangleParams("3 4 5 4"); // parameters count greater then 3
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTriangleParams3_2() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 3 );
        int res = tri.parseTriangleParams("12 3"); // parameters count less then 3
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseTriangleParams3_3() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 3 );
        int res = tri.parseTriangleParams("3 -1 4df4");
    }
    @Test(expected = NumberFormatException.class)
    public void parseTriangleParams3_3a() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 3 );
        int res = tri.parseTriangleParams("3 1 4df4");
    }





    /************************************************
     *
     *             triangleKind == ?
     *
     ************************************************/
    @Test
    public void getTriangleKind1() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 1 );
        int res = tri.getTriangleKind();
        assertTrue("params count="+res, res == 1);
    }
    @Test
    public void getTriangleKind2() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 2 );
        int res = tri.getTriangleKind();
        assertTrue("params count="+res, res == 2);
    }
    @Test
    public void getTriangleKind3() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 3 );
        int res = tri.getTriangleKind();
        assertTrue("params count="+res, res == 3);
    }

    /************************************************
     *
     *
     *             calculateArea
     *
     ************************************************/
    @Test
    public void calculateArea_1() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 1 );
        tri.parseTriangleParams("11,0 12");      // normal
        double res = tri.calculateArea();
        assertTrue("Triangle area="+res, res == 66.0);
    }
    @Test
    public void calculateArea_2() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 2 );
        tri.parseTriangleParams("1 7 6.3");      // normal
        double res = tri.calculateArea();
        assertTrue("Triangle area="+res, res == 2.3678035708225496);
    }
    @Test
    public void calculateArea_3() throws Exception {
        TriangleFactory fac = new TriangleFactory();
        TriangleRoot tri = fac.newTriangle( 3 );
        tri.parseTriangleParams("7.1 12 90");      // normal
        double res = tri.calculateArea();
        assertTrue("Triangle area="+res, res == 42.599999999999994);
    }
}