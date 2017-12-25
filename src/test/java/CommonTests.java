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
    }

    @Test
    public void applyTwiceTest() {
        Calculate calculate = new Calculate();
        calculate.apply(5);
        calculate.apply(6);
        assertEquals(5, calculate.amount);
    }

    @Test
    public void secondApplyWillFailTest() {
        Calculate calculate = new Calculate();
        calculate.apply(5);
        assertFalse(calculate.apply(6));
    }

    @Test
    public void addTest() {
        Calculate calculate = new Calculate();
        assertTrue(calculate.apply(0));
        assertTrue(calculate.add(2));
        assertEquals(2, calculate.amount);
    }

    @Test
    public void addBeforeApplyTest() {
        Calculate calculate = new Calculate();
        assertFalse(calculate.add(4));
        assertEquals(0, calculate.amount);
    }


    @Test
    public void divideTest() {
        Calculate calculate = new Calculate();
        calculate.apply(6);
        calculate.divide(2);
        assertEquals(3, calculate.amount);
    }

    @Test
    public void divideBeforeApplyTest() {
        Calculate calculate = new Calculate();
        assertFalse(calculate.divide(5));
    }

    @Test
    public void divideByZeroTest() {
        Calculate calculate = new Calculate();
        calculate.apply(6);
        assertFalse(calculate.divide(0));
    }

}