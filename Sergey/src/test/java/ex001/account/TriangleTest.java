package ex001.account;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by admin on 14.08.16.
 */
public class TriangleTest {

    @Test
    public void testGetAreaTriangle() {
        Triangle triangle = new Triangle(10.0, 10.0, 10.0);
        assertThat(triangle.getArea(), is(43.30127018922193));
    }
}
