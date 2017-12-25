import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CommonTests {
    @Test
    public void apply_Test() {
        Calculate calculate = new Calculate(0);
        calculate.apply(5);
        assertEquals(5, calculate.amount);
    }

}