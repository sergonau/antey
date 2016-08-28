package lab02;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mark Lobanov on 24.08.2016.
 */
public class InputParamsParserTest extends Assert {
    /*****************************************
     * correct input
     *****************************************/
    @Test
    public void parseStringToTrialgleKind1_1() throws Exception {
        InputParamsParser parser = new InputParamsParser();
        TrialgleCalculationKind res = parser.parseStringToTrialgleCalculationKind("1");
        assertTrue(res == TrialgleCalculationKind.SIDE_AND_HEIGHT);
    }

    @Test
    public void parseStringToTrialgleKind1_2() throws Exception {
        InputParamsParser parser = new InputParamsParser();
        TrialgleCalculationKind res = parser.parseStringToTrialgleCalculationKind(" 2");
        assertTrue(res == TrialgleCalculationKind.THREE_SIDES);
    }

    @Test
    public void parseStringToTrialgleKind1_3() throws Exception {
        InputParamsParser parser = new InputParamsParser();
        TrialgleCalculationKind res = parser.parseStringToTrialgleCalculationKind("3 ");
        assertTrue(res == TrialgleCalculationKind.TWO_SIDES_AND_ANGLE);
    }

    @Test
    public void parseStringToTrialgleKind1_4() throws Exception {
        InputParamsParser parser = new InputParamsParser();
        double[] res = parser.parseSideAndHeight("10 12");
        assertTrue("res.length="+res.length, res.length == 2);
    }

    @Test
    public void parseStringToTrialgleKind1_5() throws Exception {
        InputParamsParser parser = new InputParamsParser();
        double[] res = parser.parseThreeSides("4 3 2");
        assertTrue("res.length="+res.length, res.length == 3);
    }

    /*****************************************
     * incorrect input
     *****************************************/

    @Test(expected = IllegalArgumentException.class)
    public void parseStringToTrialgleKind2_1() throws Exception {
        InputParamsParser parser = new InputParamsParser();
        TrialgleCalculationKind res = parser.parseStringToTrialgleCalculationKind("7");
    }

    @Test(expected = NumberFormatException.class)
    public void parseStringToTrialgleKind2_2() throws Exception {
        InputParamsParser parser = new InputParamsParser();
        TrialgleCalculationKind res = parser.parseStringToTrialgleCalculationKind("ww");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseStringToTrialgleKind2_3() throws Exception {
        InputParamsParser parser = new InputParamsParser();
        double[] res = parser.parseSideAndHeight("10 12 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseStringToTrialgleKind2_4() throws Exception {
        InputParamsParser parser = new InputParamsParser();
        double[] res = parser.parseSideAndHeight("10 w");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseStringToTrialgleKind2_5() throws Exception {
        InputParamsParser parser = new InputParamsParser();
        double[] res = parser.parseThreeSides("7 3 12");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseStringToTrialgleKind2_6() throws Exception {
        InputParamsParser parser = new InputParamsParser();
        double[] res = parser.parseThreeSides("7 12");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseStringToTrialgleKind2_7() throws Exception {
        InputParamsParser parser = new InputParamsParser();
        double[] res = parser.parseTwoSidesAndAngle("7 3 190");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseStringToTrialgleKind2_8() throws Exception {
        InputParamsParser parser = new InputParamsParser();
        double[] res = parser.parseTwoSidesAndAngle("7");
    }
}