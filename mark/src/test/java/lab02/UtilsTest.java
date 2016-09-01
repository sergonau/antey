package lab02;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mark Lobanov on 30.08.2016.
 */
public class UtilsTest extends Assert {
    private static final String STR1 = "12;val2;;;val3;";
    private static final String[] ARR = { "e", "q", "exit", "quit" };

    @Test
    public void isStrEmpty1() throws Exception {
        boolean isEmpty = Utils.isStrEmpty(STR1);
        assertFalse("Actual <"+isEmpty+">", isEmpty );
    }

    @Test
    public void isStrEmpty2() throws Exception {
        boolean isEmpty = Utils.isStrEmpty("");
        assertTrue("Actual <"+isEmpty+">", isEmpty );
    }

    @Test
    public void isStringFound1() throws Exception {
        boolean found = Utils.isStringFound("q", ARR);
        assertTrue("Actual <"+found+">", found );
    }

    @Test
    public void isStringFound2() throws Exception {
        boolean found = Utils.isStringFound("eXiT", ARR);
        assertTrue("Actual <"+found+">", found );
    }

    @Test
    public void isStringFound3() throws Exception {
        boolean found = Utils.isStringFound("bla-bla-bla", ARR);
        assertFalse("Actual <"+found+">", found );
    }

    @Test
    public void prepareString() throws Exception {
        String s = Utils.prepareString("  45  46         6 7   ");
        assertTrue("Actual <"+s+">", s.equals("45 46 6 7") );
    }

    @Test
    public void partCount1() throws Exception {
        int res = Utils.partCount(STR1, ";");
        assertTrue("Actual <"+res+">", res==6 );
    }

    @Test
    public void partCount2() throws Exception {
        int res = Utils.partCount(STR1, "val2");
        assertTrue("Actual <"+res+">", res==2 );
    }


    @Test
    public void partAt_1() throws Exception {
        String s = Utils.partAt(1, STR1, ";");
        assertTrue("Actual <"+s+">", s.equals("val2") );
    }

    @Test
    public void partAt_2() throws Exception {
        String s = Utils.partAt(2, STR1, ";");
        assertTrue("Actual <"+s+">", Utils.isStrEmpty(s) );
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void partAt_3() throws Exception {
        String s = Utils.partAt(12, STR1, ";");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void partAt_4() throws Exception {
        String s = Utils.partAt(-1, STR1, ";");
    }

    @Test
    public void partAt_5() throws Exception {
        String s = Utils.partAt( Utils.partCount(STR1,";")-1, STR1, ";"); // get last value
        assertTrue("Actual <"+s+">", Utils.isStrEmpty(s) );
    }
}