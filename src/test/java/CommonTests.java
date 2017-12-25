import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CommonTests {
    @Test
    public void apply_Test() {
        Calculate calculate = new Calculate();
        calculate.apply(5);
        assertEquals(5, calculate.amount);
        calculate.apply(6);
        assertEquals(6, calculate.amount);
    }

    @Test
    public void add_Test() {
        Calculate calculate = new Calculate();
        calculate.add(4);
        assertEquals(4, calculate.amount);
        calculate.add(4);
        assertEquals(8, calculate.amount);
    }
}