import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

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
        calculate.add(4);
        assertEquals(4, calculate.amount);
        calculate.add(5);
        assertEquals(9, calculate.amount);
    }

    @Test
    public void divideTest() {
        Calculate calculate = new Calculate();
        calculate.add(6);
        calculate.divide(2);
        assertEquals(3, calculate.amount);
    }
}