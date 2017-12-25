import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class commandListTest {

    @Test
    public void applyTest() {
        int expected = 3;
        LinkedList<String> myList = new LinkedList<>();
        myList.add("apply 3");

        int acctual = RunCommands.runCommands(myList);
        assertEquals(expected, acctual);
    }
}
