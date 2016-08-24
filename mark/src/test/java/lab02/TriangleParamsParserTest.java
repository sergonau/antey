package lab02;

import org.junit.Assert;
import org.junit.Test;
import java.lang.IllegalArgumentException;

import static org.junit.Assert.*;

/**
 * Created by Mark Lobanov on 24.08.2016.
 */
public class TriangleParamsParserTest extends Assert {
    // correct input
    @Test
    public void parseStringToTrialgleKind1() throws Exception {
        TriangleParamsParser parser = new TriangleParamsParser();
        TrialgleKind res = parser.parseStringToTrialgleKind("1");
        assertTrue(res == TrialgleKind.SIDE_AND_HEIGHT);
    }
    @Test
    public void parseStringToTrialgleKind2() throws Exception {
        TriangleParamsParser parser = new TriangleParamsParser();
        TrialgleKind res = parser.parseStringToTrialgleKind(" 2");
        assertTrue(res == TrialgleKind.THREE_SIDES);
    }
    @Test
    public void parseStringToTrialgleKind3() throws Exception {
        TriangleParamsParser parser = new TriangleParamsParser();
        TrialgleKind res = parser.parseStringToTrialgleKind("3 ");
        assertTrue(res == TrialgleKind.TWO_SIDES_AND_ANGLE);
    }

    // incorrect input
    @Test(expected = IllegalArgumentException.class)
    public void parseStringToTrialgleKind4() throws Exception {
        TriangleParamsParser parser = new TriangleParamsParser();
        TrialgleKind res = parser.parseStringToTrialgleKind("7");
    }
    @Test(expected = NumberFormatException.class)
    public void parseStringToTrialgleKind5() throws Exception {
        TriangleParamsParser parser = new TriangleParamsParser();
        TrialgleKind res = parser.parseStringToTrialgleKind("ww");
    }
}