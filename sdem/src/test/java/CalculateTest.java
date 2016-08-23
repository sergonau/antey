import task02.Calculate;

import org.junit.Test;
import static junit.framework.TestCase.*;

public class CalculateTest {
    @Test
    public void testCalA() throws Exception {
        Calculate calculate = new Calculate();
        int n = calculate.calA(2, 2);

        assertEquals(4, n);
    }
}