import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommonTests {
    @Test
    public void applyTest() {
        Calculate calculate = new Calculate();
        calculate.apply(5);
        assertEquals(5, calculate.amount);
        assertFalse(calculate.apply(6));
        assertEquals(5, calculate.amount);
    }

    @Test
    public void addTest() {
        Calculate calculate = new Calculate();
        assertFalse(calculate.add(4));
        assertEquals(0, calculate.amount);
        assertFalse(calculate.add(5));
        assertEquals(0, calculate.amount);
        assertTrue(calculate.apply(0));
        assertTrue(calculate.add(2));
        assertEquals(2, calculate.amount);
    }

    @Test
    public void divideTest() {
        Calculate calculate = new Calculate();
        calculate.add(6);
        calculate.divide(2);
        assertEquals(3, calculate.amount);
    }
}