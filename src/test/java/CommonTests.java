import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CommonTests {
    @Test
    public void applyTest() {
        Calculate calculate = new Calculate();
        calculate.apply(5);
        assertTrue(calculate.equals(5));
    }

    @Test
    public void applyTwiceTest() {
        Calculate calculate = new Calculate();
        calculate.apply(5);
        calculate.apply(6);
        assertTrue(calculate.equals(5));
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
        assertTrue(calculate.equals(2));
    }

    @Test
    public void addBeforeApplyTest() {
        Calculate calculate = new Calculate();
        assertFalse(calculate.add(4));
        assertTrue(calculate.equals(0));
    }

    @Test
    public void divideTest() {
        Calculate calculate = new Calculate();
        calculate.apply(6);
        calculate.divide(2);
        assertTrue(calculate.equals(3));
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

    @Test
    public void subtractTest() {
        Calculate calculate = new Calculate();
        calculate.apply(10);
        calculate.subtract(5);
        assertTrue(calculate.equals(5));
    }

    @Test
    public void subtractBeforeApplyTest() {
        Calculate calculate = new Calculate();
        assertFalse(calculate.subtract(5));
    }

    @Test
    public void multiplyTest() {
        Calculate calculate = new Calculate();
        calculate.apply(2);
        calculate.multiply(4);
        assertTrue(calculate.equals(8));
    }

    @Test
    public void multiplyBeforeApply() {
        Calculate calculate = new Calculate();
        assertFalse(calculate.multiply(4));
    }
}